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
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
	@ApiModelProperty(notes = "Identificador único da disciplina", required = true)
	private Long id;

	@Column
	@ApiModelProperty(notes = "nome da disciplina")
	private String nome;

	@Column(name = "nome_professor")
	@ApiModelProperty(notes = "nome do professor responsável pela disciplina")
	private String nomeProfessor;


	public Disciplina() {
	}

	public Disciplina(Long id, String nome, String nomeProfessor) {
		this.id = id;
		this.nome = nome;
		this.nomeProfessor = nomeProfessor;
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

	public String getNomeProfessor() {
		return this.nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Disciplina)) {
						return false;
				}
				Disciplina disciplina = (Disciplina) o;
				return Objects.equals(id, disciplina.id) && Objects.equals(nome, disciplina.nome) && Objects.equals(nomeProfessor, disciplina.nomeProfessor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, nomeProfessor);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nome='" + getNome() + "'" +
			", nomeProfessor='" + getNomeProfessor() + "'" +
			"}";
	}
}
