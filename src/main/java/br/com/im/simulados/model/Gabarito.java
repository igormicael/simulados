package br.com.im.simulados.model;

import javax.persistence.Entity;
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
public class Gabarito {

	@Id
	@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
	@ApiModelProperty(notes="Identificador único da disciplina", required = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="prova_id", nullable = false, foreignKey=@ForeignKey(name="gabrito_prova_id"))
	@JsonBackReference
	private Prova prova;
	
	@ManyToOne
	@JoinColumn(name="questao_id", nullable = false, foreignKey=@ForeignKey(name="gabarito_questao_id"))
	@JsonBackReference
	private Questao questao;
	
	@ManyToOne
	@JoinColumn(name="alternativa_id", nullable = false, foreignKey=@ForeignKey(name="gabarito_alternativa_id"))
	@JsonBackReference
	private Alternativa alternativa;
}