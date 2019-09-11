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
@Table(name="resposta")
public class Resposta {
	
	@Id
	@SequenceGenerator(name = "resposta_seq", sequenceName = "resposta_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resposta_seq")
	@ApiModelProperty(notes="Identificador único da resposta", required = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="questao_id", nullable = false, foreignKey=@ForeignKey(name="resposta_questao_id"))
	@JsonBackReference
	private Questao questao;
	
	@ManyToOne
	@JoinColumn(name="alternativa_id", nullable = false, foreignKey=@ForeignKey(name="resposta_alternativa_id"))
	@JsonBackReference
	private Alternativa alternativa;
	
	@ManyToOne
	@JoinColumn(name="gabarito_id", nullable = false, foreignKey=@ForeignKey(name="resposta_gabarito_id"))
	@JsonBackReference
	private Gabarito gabarito;

}