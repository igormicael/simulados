package br.com.im.simulados.dto;

import javax.validation.constraints.NotNull;

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

  @NotNull
  private Long id;
  
  @NotNull
  private Long alunoId;
  
  @NotNull
  private Long simuladoId;
  
  @NotNull
  private Long provaId;
  
  @NotNull
  private Long questaoId;
  
  @NotNull
  private Long alternativaId;

}