package br.com.im.simulados.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.dto.RankingDTO;
import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.AlunoResposta;
import br.com.im.simulados.model.DificuldadeQuestao;
import br.com.im.simulados.model.Gabarito;
import br.com.im.simulados.model.Prova;
import br.com.im.simulados.model.Questao;

@Service
public class RankingService {

  @Autowired
  private AlunoRespostaService alunoRespostaService;

  @Autowired
  private ProvaService provaService;

  @Autowired
  private GabaritoService gabaritoService;

  public List<RankingDTO> buscarRakingPorSimulado(Long id) {
    List<AlunoResposta> alunosResposta = alunoRespostaService.findAllBySimuladoId(id);

    List<Prova> provas = provaService.findAllBySimuladoId(id);

    LinkedHashMap<Aluno, List<AlunoResposta>> mapAlunosRespostas = listaToMap(alunosResposta);

    LinkedHashMap<Aluno, LinkedHashMap<Prova, List<Questao>>> mapAlunosProvasQuestoesAcertadas = verificarQuestoesCorretas(
        mapAlunosRespostas, provas);

    LinkedHashMap<Aluno, Long> mapAlunosNotas = calcularNotaPorAluno(mapAlunosProvasQuestoesAcertadas);

    return computarRanking(mapAlunosNotas);

  }

  public LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap(List<AlunoResposta> alunosResposta) {

    LinkedHashMap<Aluno, List<AlunoResposta>> map = new LinkedHashMap<Aluno, List<AlunoResposta>>();
    if (alunosResposta != null && !alunosResposta.isEmpty()) {

      List<Aluno> alunos = alunosResposta.stream().map(AlunoResposta::getAluno).collect(Collectors.toList());
      if (alunos != null && !alunos.isEmpty()) {
        for (Aluno aluno : alunos) {
          List<AlunoResposta> lista = alunosResposta.stream().filter(i -> i.getAluno().equals(aluno))
              .collect(Collectors.toList());
          map.put(aluno, lista);
        }
      }
    }
    return map;
  }

  public LinkedHashMap<Aluno, LinkedHashMap<Prova, List<Questao>>> verificarQuestoesCorretas(
      LinkedHashMap<Aluno, List<AlunoResposta>> mapAlunosRespostas, List<Prova> provas) {

    LinkedHashMap<Aluno, LinkedHashMap<Prova, List<Questao>>> mapAlunoProvaAlternativasCertas = new LinkedHashMap<>();

    for (Map.Entry<Aluno, List<AlunoResposta>> entry : mapAlunosRespostas.entrySet()) {
      LinkedHashMap<Prova, List<Questao>> questoesPorProva = new LinkedHashMap<>();

      List<Prova> alunoProvas = entry.getValue().stream().filter(i -> i.getAluno().equals(entry.getKey()))
          .map(AlunoResposta::getProva).distinct().collect(Collectors.toList());

      for (Prova prova : alunoProvas) {
        List<Questao> questoesCertas = new ArrayList<>();
        Prova prova_ = provas.get(provas.indexOf(prova));
        Gabarito gabarito = gabaritoService.findByProvaId(prova_.getId());
        List<Alternativa> altenartivasCertas = gabarito.getAlternativas();
        List<Alternativa> map = entry.getValue().stream().filter(i -> i.getProva().equals(prova_))
            .map(AlunoResposta::getAlternativa).distinct().collect(Collectors.toList());

        map.stream().filter(i -> altenartivasCertas.contains(i)).forEach(i -> questoesCertas.add(i.getQuestao()));
        questoesPorProva.put(prova, questoesCertas);
        mapAlunoProvaAlternativasCertas.put(entry.getKey(), questoesPorProva);
      }
    }
    return mapAlunoProvaAlternativasCertas;
  }

  public LinkedHashMap<Aluno, Long> calcularNotaPorAluno(
      LinkedHashMap<Aluno, LinkedHashMap<Prova, List<Questao>>> mapAlunosQuestoesAcertadas) {

    LinkedHashMap<Aluno, Long> notasPorAluno = new LinkedHashMap<>();

    if(mapAlunosQuestoesAcertadas != null && !mapAlunosQuestoesAcertadas.isEmpty()){
      for (Map.Entry<Aluno, LinkedHashMap<Prova, List<Questao>>> entry : mapAlunosQuestoesAcertadas.entrySet()) {
        LinkedHashMap<Prova, Long> notasPorProva = new LinkedHashMap<>();

        if(entry != null && entry.getValue() != null && !entry.getValue().isEmpty()){
          for (Map.Entry<Prova, List<Questao>> innerEntry : entry.getValue().entrySet()) {
            Long nota = calcularNota(innerEntry.getValue());
            notasPorProva.put(innerEntry.getKey(), nota);
          }
          Long media = calcularMediaProvas(notasPorProva.values());
          notasPorAluno.put(entry.getKey(), media);
        }
      }
    }
    return notasPorAluno;
  }

  public Long calcularMediaProvas(Collection<Long> notasPorProva) {
    if(notasPorProva != null && !notasPorProva.isEmpty()){
      LongSummaryStatistics sumario = notasPorProva.stream().collect(LongSummaryStatistics::new,
          LongSummaryStatistics::accept, LongSummaryStatistics::combine);
      return Double.valueOf(sumario.getAverage()).longValue();
    }
    return 0L;
  }

  public Long calcularNota(List<Questao> questoes) {

    Long qtdeFacil = 0L;
    Long qtdeMedia = 0L;
    Long qtdeDificil = 0L;

    if (questoes != null && !questoes.isEmpty()) {
      for (Questao questao : questoes) {
        if (questao != null && questao.getDificuldadeQuestao() != null) {
          if (questao.getDificuldadeQuestao().equals(DificuldadeQuestao.FACIL)) {
            qtdeFacil++;
          }
          if (questao.getDificuldadeQuestao().equals(DificuldadeQuestao.MEDIA)) {
            qtdeMedia++;
          }
          if (questao.getDificuldadeQuestao().equals(DificuldadeQuestao.DIFICIL)) {
            qtdeDificil++;
          }
        }
      }
    }
    Long valorFacil = qtdeFacil == 0 ? 0 : qtdeFacil * DificuldadeQuestao.FACIL.getValor();
    Long valorMedia = qtdeMedia == 0 ? 0 : qtdeMedia * DificuldadeQuestao.MEDIA.getValor();
    Long valorDificil = qtdeDificil == 0 ? 0 : qtdeDificil * DificuldadeQuestao.DIFICIL.getValor();
    return (valorFacil + valorMedia + valorDificil + 600);
  }

  public List<RankingDTO> computarRanking(LinkedHashMap<Aluno, Long> mapAlunosNotas) {
    List<RankingDTO> ranking = new ArrayList<>();
    if (mapAlunosNotas != null && !mapAlunosNotas.isEmpty()) {

      for (Map.Entry<Aluno, Long> entry : mapAlunosNotas.entrySet()) {
        Aluno aluno = entry.getKey();
        Long nota = entry.getValue();
        if (aluno != null && aluno.getId() != null && aluno.getNome() != null && nota != null) {
          RankingDTO dto = new RankingDTO();
          dto.setAlunoId(aluno.getId());
          dto.setAlunoNome(aluno.getNome());
          dto.setNota(nota);
          ranking.add(dto);
        }
      }

      if (!ranking.isEmpty()) {
        ranking = ranking.stream().sorted().collect(Collectors.toList());
        RankingDTO ultimaPosicao = null;
        for (Long i = 0L; i <= ranking.size() - 1; i++) {
          Long j = i + 1;
          RankingDTO dto = ranking.get(i.intValue());
          if (ultimaPosicao != null) {
            if (ultimaPosicao.getNota().equals(dto.getNota())) {
              dto.setRanking(i);
            }
          }
          if (dto.getRanking() == null) {
            dto.setRanking(j);
          }
          ultimaPosicao = dto;
        }
      }
    }
    return ranking;
  }

}