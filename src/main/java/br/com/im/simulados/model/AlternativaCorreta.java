package br.com.im.simulados.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "alternativa-correta")
public class AlternativaCorreta {

  private Long id;
  private Date desativacao;
  private Alternativa alternativa;
  private Gabarito gabarito;


  public AlternativaCorreta() {
  }

  public AlternativaCorreta(Long id, Date desativacao, Alternativa alternativa, Gabarito gabarito) {
    this.id = id;
    this.desativacao = desativacao;
    this.alternativa = alternativa;
    this.gabarito = gabarito;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDesativacao() {
    return this.desativacao;
  }

  public void setDesativacao(Date desativacao) {
    this.desativacao = desativacao;
  }

  public Alternativa getAlternativa() {
    return this.alternativa;
  }

  public void setAlternativa(Alternativa alternativa) {
    this.alternativa = alternativa;
  }

  public Gabarito getGabarito() {
    return this.gabarito;
  }

  public void setGabarito(Gabarito gabarito) {
    this.gabarito = gabarito;
  }

  public AlternativaCorreta id(Long id) {
    this.id = id;
    return this;
  }

  public AlternativaCorreta desativacao(Date desativacao) {
    this.desativacao = desativacao;
    return this;
  }

  public AlternativaCorreta alternativa(Alternativa alternativa) {
    this.alternativa = alternativa;
    return this;
  }

  public AlternativaCorreta gabarito(Gabarito gabarito) {
    this.gabarito = gabarito;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AlternativaCorreta)) {
            return false;
        }
        AlternativaCorreta alternativaCorreta = (AlternativaCorreta) o;
        return Objects.equals(id, alternativaCorreta.id) && Objects.equals(desativacao, alternativaCorreta.desativacao) && Objects.equals(alternativa, alternativaCorreta.alternativa) && Objects.equals(gabarito, alternativaCorreta.gabarito);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, desativacao, alternativa, gabarito);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", desativacao='" + getDesativacao() + "'" +
      ", alternativa='" + getAlternativa() + "'" +
      ", gabarito='" + getGabarito() + "'" +
      "}";
  }

}