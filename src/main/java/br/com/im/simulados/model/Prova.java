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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Audited
@Table(name = "prova")
public class Prova {

	@Id
	@SequenceGenerator(name = "prova_seq", sequenceName = "prova_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prova_seq")
	@ApiModelProperty(notes = "Identificador único da disciplina", required = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "disciplina_id", nullable = true, foreignKey = @ForeignKey(name = "prova_disciplina_id"))
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "gabarito_id", nullable = true, foreignKey = @ForeignKey(name = "prova_gabarito_id"))
	private Gabarito gabarito;

	@ManyToOne
	@JoinColumn(name = "simulado_id", nullable = false, foreignKey = @ForeignKey(name = "prova_simulado_id"))
	@JsonBackReference
	private Simulado simulado;

	@OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@ApiModelProperty(notes = "questões contidas na prova")
	private List<Questao> questoes;

	public Prova(Long provaId) {
		this.id = provaId;
	}

}
