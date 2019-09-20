package br.com.im.simulados.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Audited
@Table(name = "prova")
public class Prova {

	@Id
	@SequenceGenerator(name = "prova_seq", sequenceName = "prova_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prova_seq")
	@ApiModelProperty(notes = "Identificador único da disciplina", required = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "disciplina_id", nullable = true, foreignKey = @ForeignKey(name = "prova_disciplina_id"))
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "gabarito_id", nullable = true, foreignKey = @ForeignKey(name = "prova_gabarito_id"))
	private Gabarito gabarito;

	@ManyToOne
	@JoinColumn(name = "simulado_id", nullable = false, foreignKey = @ForeignKey(name = "prova_simulado_id"))
	@JsonBackReference
	private Simulado simulado;

	@OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes = "questões contidas na prova")
	private List<Questao> questoes;

	public Prova(Long provaId) {
		this.id = provaId;
	}

	public Prova() {
	}

	public Prova(Long id, Disciplina disciplina, Gabarito gabarito, Simulado simulado, List<Questao> questoes) {
		this.id = id;
		this.disciplina = disciplina;
		this.gabarito = gabarito;
		this.simulado = simulado;
		this.questoes = questoes;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Gabarito getGabarito() {
		return this.gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}

	public Simulado getSimulado() {
		return this.simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public List<Questao> getQuestoes() {
		return this.questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Prova)) {
						return false;
				}
				Prova prova = (Prova) o;
				return Objects.equals(id, prova.id) && Objects.equals(disciplina, prova.disciplina) && Objects.equals(gabarito, prova.gabarito) && Objects.equals(simulado, prova.simulado) && Objects.equals(questoes, prova.questoes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, disciplina, gabarito, simulado, questoes);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", disciplina='" + getDisciplina() + "'" +
			", gabarito='" + getGabarito() + "'" +
			", simulado='" + getSimulado() + "'" +
			", questoes='" + getQuestoes() + "'" +
			"}";
	}

}
