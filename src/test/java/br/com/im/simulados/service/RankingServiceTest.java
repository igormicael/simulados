package br.com.im.simulados.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.im.simulados.dto.RankingDTO;
import br.com.im.simulados.fixtures.Alunos;
import br.com.im.simulados.fixtures.Provas;
import br.com.im.simulados.fixtures.Questoes;
import br.com.im.simulados.fixtures.Rankings;
import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.Prova;
import br.com.im.simulados.model.Questao;

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
    List<RankingDTO> computarRanking = rankingService.computarRanking(new HashMap<>());

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComValueDoMapNulo(){
    Map<Aluno, Long> mapAlunosNotas = new HashMap<>();
    mapAlunosNotas.put(Alunos.getAlunoVazio(), null);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComAlunoSemDadosPreenchidos(){
    Map<Aluno, Long> mapAlunosNotas = new HashMap<>();
    mapAlunosNotas.put(Alunos.getAlunoVazio(), 600L);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( Collections.emptyList() , computarRanking);
  }

  @Test
  public void computarRankingComAlunoComDadosPreenchidos(){
    Map<Aluno, Long> mapAlunosNotas = new HashMap<>();
    Aluno igor = Alunos.getIgor();
    mapAlunosNotas.put(igor, 600L);

    List<RankingDTO> computarRanking = rankingService.computarRanking(mapAlunosNotas);

    List<RankingDTO> esperado = new ArrayList<>();
    esperado.add( Rankings.getRankingIgorPontuacaoMinima(igor) );

    Assert.assertNotNull(computarRanking);
    Assert.assertEquals( esperado , computarRanking);
  }
  
  @Test
  public void calcularNotaComListaNula(){
    Long nota = rankingService.calcularNota(null);
    Assert.assertEquals( Long.valueOf(600) , nota);
  }

  @Test
  public void calcularNotaComNenhumaQuestaoResolvida(){
    Long nota = rankingService.calcularNota(new ArrayList<>());
    Assert.assertEquals( Long.valueOf(600) , nota);
  }

  @Test
  public void calcularNotaComListaDeQuestoesVazias(){

    ArrayList<Questao> questoes = new ArrayList<>();
    questoes.add(Questoes.getQuestaoVazia());
    questoes.add(Questoes.getQuestaoVazia());
    questoes.add(Questoes.getQuestaoVazia());

    Long nota = rankingService.calcularNota(questoes);
    Assert.assertEquals( Long.valueOf(600) , nota);
  }

  @Test
  public void calcularNotaComTresQuestoesFaceis(){

    ArrayList<Questao> questoes = new ArrayList<>();
    questoes.add(Questoes.getQuestaoFacil());
    questoes.add(Questoes.getQuestaoFacil());
    questoes.add(Questoes.getQuestaoFacil());

    Long nota = rankingService.calcularNota(questoes);
    Assert.assertEquals( Long.valueOf(645) , nota);
  }

  @Test
  public void calcularNotaComQuatroQuestoesMedias(){

    ArrayList<Questao> questoes = new ArrayList<>();
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());

    Long nota = rankingService.calcularNota(questoes);
    Assert.assertEquals( Long.valueOf(648) , nota);
  }

  @Test
  public void calcularNotaComTresQuestoesDificeis(){

    ArrayList<Questao> questoes = new ArrayList<>();
    questoes.add(Questoes.getQuestaoDificil());
    questoes.add(Questoes.getQuestaoDificil());
    questoes.add(Questoes.getQuestaoDificil());

    Long nota = rankingService.calcularNota(questoes);
    Assert.assertEquals( Long.valueOf(624) , nota);
  }

  @Test
  public void calcularMaiorNota(){

    ArrayList<Questao> questoes = new ArrayList<>();
    questoes.add(Questoes.getQuestaoFacil());
    questoes.add(Questoes.getQuestaoFacil());
    questoes.add(Questoes.getQuestaoFacil());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoMedia());
    questoes.add(Questoes.getQuestaoDificil());
    questoes.add(Questoes.getQuestaoDificil());
    questoes.add(Questoes.getQuestaoDificil());

    Long nota = rankingService.calcularNota(questoes);
    Assert.assertEquals( Long.valueOf(717) , nota);
  }

  @Test
  public void calcularMediaSemProvas(){
    List<Long> notas = null;
    Long nota = rankingService.calcularMediaProvas(notas);
    Assert.assertEquals( Long.valueOf(0) , nota);
  }

  @Test
  public void calcularMediaProvas(){
    List<Long> notas = new ArrayList<>();

    notas.add(600L);
    notas.add(615L);
    notas.add(624L);

    Long nota = rankingService.calcularMediaProvas(notas);
    Assert.assertEquals( Long.valueOf(613) , nota);
  }

  @Test
  public void testarCalculoComMapVazio(){
    Map<Aluno, Map<Prova, List<Questao>>> mapAlunosQuestoesAcertadas = null;
    Map<Aluno, Long> calcularNotaPorAluno = rankingService.calcularNotaPorAluno(mapAlunosQuestoesAcertadas);
    
    Assert.assertNotNull(calcularNotaPorAluno);
    Assert.assertEquals(Collections.emptyMap() ,calcularNotaPorAluno);

  }

  @Test
  public void testarCalculoComMapProvaQuestaoVazia(){
    Map<Aluno, Map<Prova, List<Questao>>> mapAlunosQuestoesAcertadas = 
    new HashMap<>();

    mapAlunosQuestoesAcertadas.put(Alunos.getAlunoVazio(), null);

    Map<Aluno, Long> calcularNotaPorAluno = rankingService.calcularNotaPorAluno(mapAlunosQuestoesAcertadas);
    
    Assert.assertNotNull(calcularNotaPorAluno);
    Assert.assertEquals(Collections.emptyMap() ,calcularNotaPorAluno);

  }

  @Test
  public void testarCalculoComMapProvaQuestaoValidas(){
    Map<Aluno, Map<Prova, List<Questao>>> mapAlunosQuestoesAcertadas = 
    new HashMap<>();

    Map<Prova, List<Questao>> questoesProva = new HashMap<>();

    Prova prova = Provas.getProvaComTresQuestoesFaceis();
    questoesProva.put(prova, prova.getQuestoes());

    mapAlunosQuestoesAcertadas.put(Alunos.getIgor(), questoesProva);

    Map<Aluno, Long> calcularNotaPorAluno = rankingService.calcularNotaPorAluno(mapAlunosQuestoesAcertadas);
    
    Assert.assertNotNull(calcularNotaPorAluno);

    Map<Aluno, Long> esperado = new HashMap<>();

    esperado.put(Alunos.getIgor(), Long.valueOf(645));
    
    Assert.assertEquals(esperado ,calcularNotaPorAluno);

  }

}