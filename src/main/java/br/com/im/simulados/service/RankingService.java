package br.com.im.simulados.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.dto.RankingDTO;
import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.AlunoResposta;
import br.com.im.simulados.model.Questao;


@Service
public class RankingService {

  @Autowired
  private AlunoRespostaService alunoRespostaService;

  public List<RankingDTO> buscarRakingPorSimulado(Long id) {
    List<AlunoResposta> alunosResposta = alunoRespostaService.findAllBySimuladoId(id);

    LinkedHashMap<Aluno, List<AlunoResposta>> mapAlunosRespostas = listaToMap(alunosResposta);
    LinkedHashMap<Aluno, List<Questao>> mapAlunosQuestoesAcertadas = verificarQuestoesCorretas(mapAlunosRespostas);
    LinkedHashMap<Aluno, Long> mapAlunosNotas = calcularNota(mapAlunosQuestoesAcertadas);
    return computarRanking(mapAlunosNotas);

  }

  public LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap(List<AlunoResposta> alunosResposta) {

    LinkedHashMap<Aluno, List<AlunoResposta>> map = new LinkedHashMap<Aluno, List<AlunoResposta>>();
    if(alunosResposta != null && !alunosResposta.isEmpty()){

      List<Aluno> alunos = alunosResposta.stream().map(AlunoResposta::getAluno).collect(Collectors.toList());
      if(alunos != null && !alunos.isEmpty()){
        for(Aluno aluno : alunos){
          List<AlunoResposta> lista = alunosResposta.stream().filter(i -> i.getAluno().equals(aluno)).collect(Collectors.toList());
          map.put(aluno, lista);
        }
      }
    }
    return map;
  }

  private LinkedHashMap<Aluno, List<Questao>> verificarQuestoesCorretas(
      LinkedHashMap<Aluno, List<AlunoResposta>> mapAlunosRespostas) {
    return null;
  }

  private LinkedHashMap<Aluno, Long> calcularNota(LinkedHashMap<Aluno, List<Questao>> mapAlunosQuestoesAcertadas) {
    return null;
  }

  private List<RankingDTO> computarRanking(LinkedHashMap<Aluno, Long> mapAlunosNotas) {
    return null;
  }

}