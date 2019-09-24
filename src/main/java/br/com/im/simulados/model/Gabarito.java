package br.com.im.simulados.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Audited
@Table(name = "gabarito")
public class Gabarito {

	@Id
	@SequenceGenerator(name = "gabarito_seq", sequenceName = "gabarito_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gabarito_seq")
	@ApiModelProperty(notes = "Identificador único da gabarito", required = true)
	private Long id;

	@Column
	private Date desativacao;

	@ManyToOne
	@JoinColumn(name = "prova_id", nullable = false, foreignKey = @ForeignKey(name = "gabrito_prova_id"))
	@JsonBackReference
	private Prova prova;

	private List<AlternativaCorreta> alternativasCorretas;

	public Gabarito() {
	}

	public Gabarito(Long id, Date desativacao, Prova prova) {
		this.id = id;
		this.desativacao = desativacao;
		this.prova = prova;
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

	public Prova getProva() {
		return this.prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public List<AlternativaCorreta> getAlternativasCorretas() {
		return this.alternativasCorretas;
	}

	public void setAlternativasCorretas(List<AlternativaCorreta> alternativasCorretas) {
		this.alternativasCorretas = alternativasCorretas;
	}

	public List<Alternativa> getAlternativas(){
		if(alternativasCorretas != null){
			return alternativasCorretas
				.stream()
				.filter(i -> i.getAlternativa() != null)
				.map(AlternativaCorreta::getAlternativa)
				.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Gabarito)) {
						return false;
				}
				Gabarito gabarito = (Gabarito) o;
				return Objects.equals(id, gabarito.id) && Objects.equals(desativacao, gabarito.desativacao) && Objects.equals(prova, gabarito.prova);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, desativacao, prova);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", desativacao='" + getDesativacao() + "'" +
			", prova='" + getProva() + "'" +
			"}";
	}

}
