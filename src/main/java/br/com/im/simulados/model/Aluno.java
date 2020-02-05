package br.com.im.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Audited
@Table(name = "aluno")
public class Aluno {

	@Id
	@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
	@ApiModelProperty(notes = "Identificador único do aluno", required = true)
	private Long id;

	@NotNull
	@Column
	@ApiModelProperty(notes = "nome do aluno")
	private String nome;

	@NotNull
	@Column
	@ApiModelProperty(notes = "cpf do aluno")
	private String cpf;

	
	public Aluno(Long alunoId) {
		this.id = alunoId;
	}

}