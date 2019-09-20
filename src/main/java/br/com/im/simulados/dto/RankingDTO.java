package br.com.im.simulados.dto;

import java.util.Objects;

public class RankingDTO implements Comparable<RankingDTO> {
  private Long alunoId;
  private String alunoNome;
  private Long nota;
  private Long ranking;


  public RankingDTO() {
  }

  public RankingDTO(Long alunoId, String alunoNome, Long nota, Long ranking) {
    this.alunoId = alunoId;
    this.alunoNome = alunoNome;
    this.nota = nota;
    this.ranking = ranking;
  }

  public Long getAlunoId() {
    return this.alunoId;
  }

  public void setAlunoId(Long alunoId) {
    this.alunoId = alunoId;
  }

  public String getAlunoNome() {
    return this.alunoNome;
  }

  public void setAlunoNome(String alunoNome) {
    this.alunoNome = alunoNome;
  }

  public Long getNota() {
    return this.nota;
  }

  public void setNota(Long nota) {
    this.nota = nota;
  }

  public Long getRanking() {
    return this.ranking;
  }

  public void setRanking(Long ranking) {
    this.ranking = ranking;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RankingDTO)) {
            return false;
        }
        RankingDTO rankingDTO = (RankingDTO) o;
        return Objects.equals(alunoId, rankingDTO.alunoId) && Objects.equals(alunoNome, rankingDTO.alunoNome) && Objects.equals(nota, rankingDTO.nota) && Objects.equals(ranking, rankingDTO.ranking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alunoId, alunoNome, nota, ranking);
  }

  @Override
  public String toString() {
    return "{" +
      " alunoId='" + getAlunoId() + "'" +
      ", alunoNome='" + getAlunoNome() + "'" +
      ", nota='" + getNota() + "'" +
      ", ranking='" + getRanking() + "'" +
      "}";
  }


  @Override
  public int compareTo(RankingDTO other) {
    return other.nota.compareTo(this.nota);
  }
}