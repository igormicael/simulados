package br.com.im.simulados.fixtures;

import br.com.im.simulados.dto.RankingDTO;
import br.com.im.simulados.model.Aluno;

public class Rankings {

  public static RankingDTO getRankingIgorPontuacaoMinima(Aluno aluno){
    return new RankingDTO(aluno.getId(), aluno.getNome(), 600L, 1L);
  }

}