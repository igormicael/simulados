package br.com.im.simulados.model;

import java.util.Objects;

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
@Table(name = "alternativa")
public class Alternativa {

	@Id
	@SequenceGenerator(name = "alternativa_seq", sequenceName = "alternativa_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternativa_seq")
	@ApiModelProperty(notes = "Identificador único da alternativa", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "descricao da alternativa")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "questao_id", nullable = false, foreignKey = @ForeignKey(name = "alternativa_questao_id"))
	@JsonBackReference
	private Questao questao;

	public Alternativa() {
	}

	public Alternativa(Long alternativaId) {
		this.id = alternativaId;
	}

	public Alternativa(Long id, String descricao, Questao questao) {
		this.id = id;
		this.descricao = descricao;
		this.questao = questao;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Alternativa)) {
						return false;
				}
				Alternativa alternativa = (Alternativa) o;
				return Objects.equals(id, alternativa.id) && Objects.equals(descricao, alternativa.descricao) && Objects.equals(questao, alternativa.questao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descricao, questao);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", descricao='" + getDescricao() + "'" +
			", questao='" + getQuestao() + "'" +
			"}";
	}

}
