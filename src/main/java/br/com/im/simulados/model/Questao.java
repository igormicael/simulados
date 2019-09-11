package br.com.im.simulados.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Audited
@Data
@Table(name="prova")
public class Questao {

	@Id
	@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
	@ApiModelProperty(notes="Identificador único da disciplina", required = true)
	private Long id;
	
	@Column
	@ApiModelProperty(notes="enunciado da questão")
	private String enunciado;
	
	@Column(name="dificuldade_questao")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes="dificuldade da questão")
	private DificuldadeQuestao dificuldadeQuestao;
	
	@Column(name="tipo_questao")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes="tipo da questão")
	private TipoQuestao tipoQuestao;
	
	@ManyToOne
	@JoinColumn(name="prova_id", nullable = false, foreignKey=@ForeignKey(name="resposta_gabarito_id"))
	@JsonBackReference
	private Prova prova;

}
