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
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.im.simulados.dto.RespostaDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Audited
@Table(name = "aluno_resposta")
public class AlunoResposta {

	@Id
	@SequenceGenerator(name = "aluno_resposta_seq", sequenceName = "aluno_resposta_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_resposta_seq")
	@ApiModelProperty(notes = "Identificador único do vinculo entre aluno e a sua resposta", required = true)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "ar_aluno_id"))
	@JsonBackReference
	private Aluno aluno;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "simulado_id", nullable = false, foreignKey = @ForeignKey(name = "ar_simulado_id"))
	@JsonBackReference
	private Simulado simulado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "prova_id", nullable = false, foreignKey = @ForeignKey(name = "ar_prova_id"))
	@JsonBackReference
	private Prova prova;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "questao_id", nullable = false, foreignKey = @ForeignKey(name = "ar_questao_id"))
	@JsonBackReference
	private Questao questao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "alternativa_id", nullable = false, foreignKey = @ForeignKey(name = "ar_alternativa_id"))
	@JsonBackReference
	private Alternativa alternativa;

	//TODO: Contruir melhor solução para o parse entre entidade e dto
	public AlunoResposta(RespostaDTO resposta) {
		this.aluno = new Aluno(resposta.getAlunoId());
		this.simulado = new Simulado(resposta.getSimuladoId());
		this.prova = new Prova(resposta.getProvaId());
		this.questao = new Questao(resposta.getQuestaoId());
		this.alternativa = new Alternativa(resposta.getAlternativaId());
	}

}
