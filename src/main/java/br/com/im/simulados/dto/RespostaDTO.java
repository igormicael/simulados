package br.com.im.simulados.dto;

import lombok.Data;

@Data
public class RespostaDTO {

  private Long alunoId;
  private Long simuladoId;
  private Long provaId;
  private Long questaoId;
  private Long alternativaId;

}