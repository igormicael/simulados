package br.com.im.simulados.fixtures;

import br.com.im.simulados.model.Aluno;

public class Alunos {

  public static Aluno getAlunoVazio(){
    return new Aluno();
  }

  public static Aluno getIgor(){
    return new Aluno(1L, "igor", "111.111.111-11");
  }

}