package br.com.im.simulados.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.im.simulados.fixtures.AlunosRespostas;
import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.AlunoResposta;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankingServiceTest {

  @MockBean
  private RankingService rankingService;

  @Autowired
  private AlunoRespostaService alunoRespostaService;

  @Test
  public void testePassandoListaNula(){
    LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap = rankingService.listaToMap(null);
    LinkedHashMap<Aluno, List<AlunoResposta>> expected = new LinkedHashMap<Aluno, List<AlunoResposta>>();

    Assert.assertEquals(expected, listaToMap);
  }

  @Test
  public void testePassandoListaPreencida(){
    Mockito.when(alunoRespostaService.findAllBySimuladoId(1L)).thenReturn(AlunosRespostas.getAlunosRespostaDoSimulado1());
    LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap = rankingService.listaToMap(null);
    LinkedHashMap<Aluno, List<AlunoResposta>> expected = new LinkedHashMap<Aluno, List<AlunoResposta>>();

    Assert.assertEquals(expected, listaToMap);
  }

}