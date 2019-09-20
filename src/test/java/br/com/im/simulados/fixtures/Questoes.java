package br.com.im.simulados.fixtures;

import br.com.im.simulados.model.DificuldadeQuestao;
import br.com.im.simulados.model.Questao;

public class Questoes {

  public static Questao getQuestaoVazia(){
    return new Questao();
  }

  public static Questao getQuestaoFacil(){
    Questao questao = new Questao();
    questao.setDificuldadeQuestao(DificuldadeQuestao.FACIL);
    return questao;
  }

  public static Questao getQuestaoMedia(){
    Questao questao = new Questao();
    questao.setDificuldadeQuestao(DificuldadeQuestao.MEDIA);
    return questao;
  }

  public static Questao getQuestaoDificil(){
    Questao questao = new Questao();
    questao.setDificuldadeQuestao(DificuldadeQuestao.DIFICIL);
    return questao;
  }

}