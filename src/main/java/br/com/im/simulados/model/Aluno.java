package br.com.im.simulados.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Audited
@Table(name = "aluno")
public class Aluno {

	@Id
	@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
	@ApiModelProperty(notes = "Identificador único do aluno", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "nome do aluno")
	private String nome;

	@Column
	@ApiModelProperty(notes = "cpf do aluno")
	private String cpf;

	public Aluno() {
	}
	
	public Aluno(Long alunoId) {
		this.id = alunoId;
	}

	public Aluno(Long id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Aluno)) {
						return false;
				}
				Aluno aluno = (Aluno) o;
				return Objects.equals(id, aluno.id) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nome='" + getNome() + "'" +
			", cpf='" + getCpf() + "'" +
			"}";
	}
}