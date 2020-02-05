package br.com.im.simulados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RespostaDTO {

  private Long id;
  private Long alunoId;
  private Long simuladoId;
  private Long provaId;
  private Long questaoId;
  private Long alternativaId;

}