package br.com.im.simulados.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Audited
@Data
@Table(name="gabarito")
public class Gabarito {

	@Id
	@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
	@ApiModelProperty(notes="Identificador único da disciplina", required = true)
	private Long id;
	
	@OneToMany(mappedBy = "gabarito", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes="respostas das questões da prova")
	private List<Resposta> respostas;
	
	@ManyToOne
	@JoinColumn(name="prova_id", nullable = false, foreignKey=@ForeignKey(name="gabrito_prova_id"))
	@JsonBackReference
	private Prova prova;
}
