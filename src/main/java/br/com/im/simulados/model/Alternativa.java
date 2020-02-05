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
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Audited
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "alternativa")
public class Alternativa {

	@Id
	@SequenceGenerator(name = "alternativa_seq", sequenceName = "alternativa_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternativa_seq")
	@ApiModelProperty(notes = "Identificador único da alternativa", required = true)
	private Long id;

	@Column
	@NotNull
	@ApiModelProperty(notes = "descricao da alternativa")
	private String descricao;

	@NotNull
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
