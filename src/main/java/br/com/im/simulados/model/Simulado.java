package br.com.im.simulados.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Audited
@Table(name = "simulado")
public class Simulado {

	@Id
	@SequenceGenerator(name = "simulado_seq", sequenceName = "simulado_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simulado_seq")
	@ApiModelProperty(notes = "Identificador único do simulado", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "data que ocorrerá o simulado")
	private Date data;

	@Column
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "categoria do simulado")
	private CategoriaSimulado tipo;

	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes = "provas contidas no simulado")
	private List<Prova> provas;

	public Simulado(Long simuladoId) {
		this.id = simuladoId;
	}

	public Simulado() {
	}

	public Simulado(Long id, Date data, CategoriaSimulado tipo, List<Prova> provas) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.provas = provas;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public CategoriaSimulado getTipo() {
		return this.tipo;
	}

	public void setTipo(CategoriaSimulado tipo) {
		this.tipo = tipo;
	}

	public List<Prova> getProvas() {
		return this.provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Simulado)) {
						return false;
				}
				Simulado simulado = (Simulado) o;
				return Objects.equals(id, simulado.id) && Objects.equals(data, simulado.data) && Objects.equals(tipo, simulado.tipo) && Objects.equals(provas, simulado.provas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, data, tipo, provas);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", data='" + getData() + "'" +
			", tipo='" + getTipo() + "'" +
			", provas='" + getProvas() + "'" +
			"}";
	}

}
