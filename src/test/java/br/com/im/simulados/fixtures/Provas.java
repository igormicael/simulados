package br.com.im.simulados.fixtures;

import java.util.ArrayList;
import java.util.List;

import br.com.im.simulados.model.Prova;
import br.com.im.simulados.model.Questao;

public class Provas {

  public static Prova getProvaComTresQuestoesFaceis(){
    Prova prova = new Prova();
    prova.setId(1L);
    List<Questao> questoes = new ArrayList<>();
    questoes.add( Questoes.getQuestaoFacil() );
    questoes.add( Questoes.getQuestaoFacil() );
    questoes.add( Questoes.getQuestaoFacil() );
    prova.setQuestoes(questoes);
    return prova;
  }

}