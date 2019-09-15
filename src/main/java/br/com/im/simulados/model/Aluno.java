package br.com.im.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Audited
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "aluno")
public class Aluno {

	@Id
	@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
	@ApiModelProperty(notes = "Identificador único do aluno", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "nome do aluno")
	@EqualsAndHashCode.Exclude
	private String nome;

	@Column
	@ApiModelProperty(notes = "cpf do aluno")
	@EqualsAndHashCode.Exclude
	private String cpf;

	public Aluno(Long alunoId) {
		this.id = alunoId;
	}

}
