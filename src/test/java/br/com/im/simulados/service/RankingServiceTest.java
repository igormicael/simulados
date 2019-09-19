package br.com.im.simulados.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.AlunoResposta;

@SpringBootTest
public class RankingServiceTest {

  private RankingService rankingService = new RankingService();

  @Test
  public void testePassandoListaNula(){
    LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap = rankingService.listaToMap(null);
    LinkedHashMap<Aluno, List<AlunoResposta>> expected = new LinkedHashMap<Aluno, List<AlunoResposta>>();

    Assert.assertEquals(expected, listaToMap);
  }

  @Test
  public void testePassandoListaPreencida(){
    LinkedHashMap<Aluno, List<AlunoResposta>> listaToMap = rankingService.listaToMap(null);
    LinkedHashMap<Aluno, List<AlunoResposta>> expected = new LinkedHashMap<Aluno, List<AlunoResposta>>();

    Assert.assertEquals(expected, listaToMap);
  }

}