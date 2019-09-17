package br.com.im.simulados.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    LinkedHashMap<Aluno, List<Questao>> mapAlunosQuestoesAcertadas = verificarQuestoesCorretas(mapAlunosRespostas,
        provas);
    LinkedHashMap<Aluno, Long> mapAlunosNotas = calcularNotaPorAluno(mapAlunosQuestoesAcertadas);
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

  public LinkedHashMap<Aluno, List<Questao>> verificarQuestoesCorretas(
      LinkedHashMap<Aluno, List<AlunoResposta>> mapAlunosRespostas, List<Prova> provas) {

    LinkedHashMap<Aluno, List<Questao>> mapAlunoAlternativasCertas = new LinkedHashMap<>();

    for (Map.Entry<Aluno, List<AlunoResposta>> entry : mapAlunosRespostas.entrySet()) {
      List<Questao> questoesCertas = new ArrayList<>();

      List<Prova> alunoProvas = entry.getValue().stream().filter(i -> i.getAluno().equals(entry.getKey()))
          .map(AlunoResposta::getProva).distinct().collect(Collectors.toList());

      for (Prova prova : alunoProvas) {
        Prova prova_ = provas.get(provas.indexOf(prova));
        Gabarito gabarito = gabaritoService.findByProvaId(prova_.getId());
        List<Alternativa> altenartivasCertas = gabarito.getAltenartivas();
        List<Alternativa> map = entry.getValue().stream().filter(i -> i.getProva().equals(prova_))
            .map(AlunoResposta::getAlternativa).distinct().collect(Collectors.toList());

        map.stream().filter(i -> altenartivasCertas.contains(i)).forEach(i -> questoesCertas.add(i.getQuestao()));
        mapAlunoAlternativasCertas.put(entry.getKey(), questoesCertas);
      }
    }
    return mapAlunoAlternativasCertas;
  }

  public LinkedHashMap<Aluno, Long> calcularNotaPorAluno(
      LinkedHashMap<Aluno, List<Questao>> mapAlunosQuestoesAcertadas) {

    LinkedHashMap<Aluno, Long> notasPorAluno = new LinkedHashMap<>();
    for (Map.Entry<Aluno, List<Questao>> entry : mapAlunosQuestoesAcertadas.entrySet()) {
      Long nota = calcularNota(entry.getValue());
      notasPorAluno.put(entry.getKey(), nota);
    }
    return notasPorAluno;
  }

  private Long calcularNota(List<Questao> questoes) {

    Long qtdeFacil = 0L;
    Long qtdeMedia = 0L;
    Long qtdeDificil = 0L;

    for (Questao questao : questoes) {
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
    Long valorFacil = qtdeFacil == 0 ? 0 : qtdeFacil * DificuldadeQuestao.FACIL.getValor();
    Long valorMedia = qtdeMedia == 0 ? 0 : qtdeMedia * DificuldadeQuestao.MEDIA.getValor();
    Long valorDificil = qtdeDificil == 0 ? 0 : qtdeDificil * DificuldadeQuestao.DIFICIL.getValor();
    return (valorFacil + valorMedia + valorDificil + 600);
  }

  public List<RankingDTO> computarRanking(LinkedHashMap<Aluno, Long> mapAlunosNotas) {
    List<RankingDTO> ranking = new ArrayList<>();

    for (Map.Entry<Aluno, Long> entry : mapAlunosNotas.entrySet()) {

      RankingDTO dto = new RankingDTO();
      dto.setAlunoId(entry.getKey().getId());
      dto.setAlunoNome(entry.getKey().getNome());
      dto.setNota(entry.getValue());
      ranking.add(dto);

    }

    if(!ranking.isEmpty()){
      ranking = ranking.stream().sorted().collect(Collectors.toList());
      RankingDTO ultimaPosicao = null;
      for (Long i = 0L ; i<= ranking.size()-1 ; i++) {
        Long j = i + 1;
        RankingDTO dto = ranking.get(i.intValue());
        if(ultimaPosicao != null){
          if(ultimaPosicao.getNota().equals(dto.getNota())){
            dto.setRanking(i);    
          }
        }
        if(dto.getRanking() == null){
          dto.setRanking(j);
        }
        ultimaPosicao = dto;
      }
    }
    return ranking;
  }

}