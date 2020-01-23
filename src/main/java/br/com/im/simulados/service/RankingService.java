package br.com.im.simulados.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

    Map<Aluno, List<AlunoResposta>> mapAlunosRespostas = listaToMap(alunosResposta);

    Map<Aluno, Map<Prova, List<Questao>>> mapAlunosProvasQuestoesAcertadas = verificarQuestoesCorretas(
        mapAlunosRespostas, provas);

    Map<Aluno, Long> mapAlunosNotas = calcularNotaPorAluno(mapAlunosProvasQuestoesAcertadas);

    return computarRanking(mapAlunosNotas);

  }

  public Map<Aluno, List<AlunoResposta>> listaToMap(List<AlunoResposta> alunosResposta) {

    Map<Aluno, List<AlunoResposta>> map = new HashMap<Aluno, List<AlunoResposta>>();
    if (alunosResposta != null && !alunosResposta.isEmpty()) {
    	
    	map = alunosResposta.stream().
    		collect(Collectors.groupingBy(AlunoResposta::getAluno));
    }
    return map;
  }

  public Map<Aluno, Map<Prova, List<Questao>>> verificarQuestoesCorretas(
      Map<Aluno, List<AlunoResposta>> mapAlunosRespostas, List<Prova> provas) {

    Map<Aluno, Map<Prova, List<Questao>>> mapAlunoProvaAlternativasCertas = new HashMap<>();

    for (Map.Entry<Aluno, List<AlunoResposta>> entry : mapAlunosRespostas.entrySet()) {
      Map<Prova, List<Questao>> questoesPorProva = new HashMap<>();

      List<Prova> alunoProvas = entry.getValue().stream().filter(i -> i.getAluno().equals(entry.getKey()))
          .map(AlunoResposta::getProva).distinct().collect(Collectors.toList());

      for (Prova prova : alunoProvas) {
        List<Questao> questoesCertas = new ArrayList<>();
        Prova prova_ = provas.get(provas.indexOf(prova));
        Gabarito gabarito = gabaritoService.findByProvaId(prova_.getId());
        List<Alternativa> altenartivasCertas = gabarito.getAltenartivas();
        List<Alternativa> map = entry.getValue().stream().filter(i -> i.getProva().equals(prova_))
            .map(AlunoResposta::getAlternativa).distinct().collect(Collectors.toList());

        map.stream().filter(i -> altenartivasCertas.contains(i)).forEach(i -> questoesCertas.add(i.getQuestao()));
        questoesPorProva.put(prova, questoesCertas);
        mapAlunoProvaAlternativasCertas.put(entry.getKey(), questoesPorProva);
      }
    }
    return mapAlunoProvaAlternativasCertas;
  }

  public Map<Aluno, Long> calcularNotaPorAluno(
      Map<Aluno, Map<Prova, List<Questao>>> mapAlunosQuestoesAcertadas) {

    Map<Aluno, Long> notasPorAluno = new HashMap<>();

    if(mapAlunosQuestoesAcertadas != null && !mapAlunosQuestoesAcertadas.isEmpty()){
      for (Map.Entry<Aluno, Map<Prova, List<Questao>>> entry : mapAlunosQuestoesAcertadas.entrySet()) {
        Map<Prova, Long> notasPorProva = new HashMap<>();

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

  public List<RankingDTO> computarRanking(Map<Aluno, Long> mapAlunosNotas) {
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