package br.com.im.simulados.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Audited
@Data
@Table(name="simulado")
public class Simulado {
	
	@Id
	@SequenceGenerator(name = "simulado_seq", sequenceName = "simulado_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simulado_seq")
	@ApiModelProperty(notes="Identificador único do simulado", required = true)
	private Long id;
	
	@Column
	@ApiModelProperty(notes="data que ocorrerá o simulado")
	private Date data;
	
	@Column
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes="categoria do simulado")
	private CategoriaSimulado tipo;
	
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes="provas contidas no simulado")
	private List<Prova> provas;

}
