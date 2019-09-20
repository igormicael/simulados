package br.com.im.simulados.dto;

import java.util.Objects;

public class RespostaDTO {

  private Long alunoId;
  private Long simuladoId;
  private Long provaId;
  private Long questaoId;
  private Long alternativaId;


  public RespostaDTO() {
  }

  public RespostaDTO(Long alunoId, Long simuladoId, Long provaId, Long questaoId, Long alternativaId) {
    this.alunoId = alunoId;
    this.simuladoId = simuladoId;
    this.provaId = provaId;
    this.questaoId = questaoId;
    this.alternativaId = alternativaId;
  }

  public Long getAlunoId() {
    return this.alunoId;
  }

  public void setAlunoId(Long alunoId) {
    this.alunoId = alunoId;
  }

  public Long getSimuladoId() {
    return this.simuladoId;
  }

  public void setSimuladoId(Long simuladoId) {
    this.simuladoId = simuladoId;
  }

  public Long getProvaId() {
    return this.provaId;
  }

  public void setProvaId(Long provaId) {
    this.provaId = provaId;
  }

  public Long getQuestaoId() {
    return this.questaoId;
  }

  public void setQuestaoId(Long questaoId) {
    this.questaoId = questaoId;
  }

  public Long getAlternativaId() {
    return this.alternativaId;
  }

  public void setAlternativaId(Long alternativaId) {
    this.alternativaId = alternativaId;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RespostaDTO)) {
            return false;
        }
        RespostaDTO respostaDTO = (RespostaDTO) o;
        return Objects.equals(alunoId, respostaDTO.alunoId) && Objects.equals(simuladoId, respostaDTO.simuladoId) && Objects.equals(provaId, respostaDTO.provaId) && Objects.equals(questaoId, respostaDTO.questaoId) && Objects.equals(alternativaId, respostaDTO.alternativaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alunoId, simuladoId, provaId, questaoId, alternativaId);
  }

  @Override
  public String toString() {
    return "{" +
      " alunoId='" + getAlunoId() + "'" +
      ", simuladoId='" + getSimuladoId() + "'" +
      ", provaId='" + getProvaId() + "'" +
      ", questaoId='" + getQuestaoId() + "'" +
      ", alternativaId='" + getAlternativaId() + "'" +
      "}";
  }


}