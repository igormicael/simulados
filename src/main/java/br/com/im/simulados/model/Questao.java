package br.com.im.simulados.model;

import java.util.List;

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
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Audited
@Table(name = "questao")
public class Questao {

	@Id
	@SequenceGenerator(name = "questao_seq", sequenceName = "questao_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao_seq")
	@ApiModelProperty(notes = "Identificador único da questao", required = true)
	private Long id;

	@NotNull
	@Column
	@ApiModelProperty(notes = "enunciado da questão")
	private String enunciado;

	@NotNull
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

}
