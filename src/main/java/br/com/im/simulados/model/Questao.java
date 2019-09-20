package br.com.im.simulados.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "questao")
public class Questao {

	@Id
	@SequenceGenerator(name = "questao_seq", sequenceName = "questao_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao_seq")
	@ApiModelProperty(notes = "Identificador único da questao", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "enunciado da questão")
	private String enunciado;

	@Column(name = "dificuldade_questao")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "dificuldade da questão")
	private DificuldadeQuestao dificuldadeQuestao;

	@OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes = "alternatvas contidas na questão")
	private List<Alternativa> alternativas;

	@ManyToOne
	@JoinColumn(name = "prova_id", nullable = false, foreignKey = @ForeignKey(name = "resposta_gabarito_id"))
	@JsonBackReference
	private Prova prova;

	public Questao(Long questaoId) {
		this.id = questaoId;
	}


	public Questao() {
	}

	public Questao(Long id, String enunciado, DificuldadeQuestao dificuldadeQuestao, List<Alternativa> alternativas, Prova prova) {
		this.id = id;
		this.enunciado = enunciado;
		this.dificuldadeQuestao = dificuldadeQuestao;
		this.alternativas = alternativas;
		this.prova = prova;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public DificuldadeQuestao getDificuldadeQuestao() {
		return this.dificuldadeQuestao;
	}

	public void setDificuldadeQuestao(DificuldadeQuestao dificuldadeQuestao) {
		this.dificuldadeQuestao = dificuldadeQuestao;
	}

	public List<Alternativa> getAlternativas() {
		return this.alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Prova getProva() {
		return this.prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Questao)) {
						return false;
				}
				Questao questao = (Questao) o;
				return Objects.equals(id, questao.id) && Objects.equals(enunciado, questao.enunciado) && Objects.equals(dificuldadeQuestao, questao.dificuldadeQuestao) && Objects.equals(alternativas, questao.alternativas) && Objects.equals(prova, questao.prova);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, enunciado, dificuldadeQuestao, alternativas, prova);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", enunciado='" + getEnunciado() + "'" +
			", dificuldadeQuestao='" + getDificuldadeQuestao() + "'" +
			", alternativas='" + getAlternativas() + "'" +
			", prova='" + getProva() + "'" +
			"}";
	}

}
