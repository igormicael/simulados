package br.com.im.simulados.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.im.simulados.dto.RankingDTO;
import br.com.im.simulados.fixtures.Alunos;
import br.com.im.simulados.model.Aluno;

public class RankingServiceTest {

  private RankingService rankingService = new RankingService();

  @Test
  public void computarRankingComMapNulo(){
    List<RankingDTO> computarRanking = rankingService.computarRanking(null);

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComMapVazio(){
    List<RankingDTO> computarRanking = rankingService.computarRanking(new LinkedHashMap<>());

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComValueDoMapNulo(){
    LinkedHashMap<Aluno, Long> mapAlunosNotas = new LinkedHashMap<>();
    mapAlunosNotas.put(Alunos.getAlunoVazio(), null);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComAlunoSemDadosPreenchidos(){
    LinkedHashMap<Aluno, Long> mapAlunosNotas = new LinkedHashMap<>();
    mapAlunosNotas.put(Alunos.getAlunoVazio(), 600L);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComAlunoComDadosPreenchidos(){
    LinkedHashMap<Aluno, Long> mapAlunosNotas = new LinkedHashMap<>();
    mapAlunosNotas.put(Alunos.getIgor(), 600L);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    List<RankingDTO> esperado = new ArrayList<>();
    esperado.add( new RankingDTO(1L, "igor", 600L, 1L) );

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( esperado , computarRanking);
  }

}