package br.com.im.simulados.dto;

import lombok.Data;

@Data
public class RankingDTO {
  private Long alunoId;
  private String alunoNome;
  private Long nota;
  private Long ranking;
}