package br.com.im.simulados.dto;

import lombok.Data;

@Data
public class RankingDTO implements Comparable<RankingDTO> {
  private Long alunoId;
  private String alunoNome;
  private Long nota;
  private Long ranking;

  @Override
  public int compareTo(RankingDTO other) {
    return other.nota.compareTo(this.nota);
  }
}