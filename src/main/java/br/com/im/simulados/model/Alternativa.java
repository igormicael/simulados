package br.com.im.simulados.model;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Audited
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@ManyToOne
	@JoinColumn(name = "gabarito_id", nullable = true, foreignKey = @ForeignKey(name = "alternativa_gabrito_id"))
	@JsonBackReference
	private Gabarito gabarito;

	public Alternativa(Long alternativaId) {
		this.id = alternativaId;
	}
}
