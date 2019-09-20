package br.com.im.simulados.model;

import java.util.Objects;

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

import br.com.im.simulados.dto.RespostaDTO;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Audited
@Table(name = "aluno_resposta")
public class AlunoResposta {

	@Id
	@SequenceGenerator(name = "aluno_resposta_seq", sequenceName = "aluno_resposta_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_resposta_seq")
	@ApiModelProperty(notes = "Identificador único do vinculo entre aluno e a sua resposta", required = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "ar_aluno_id"))
	@JsonBackReference
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "simulado_id", nullable = false, foreignKey = @ForeignKey(name = "ar_simulado_id"))
	@JsonBackReference
	private Simulado simulado;

	@ManyToOne
	@JoinColumn(name = "prova_id", nullable = false, foreignKey = @ForeignKey(name = "ar_prova_id"))
	@JsonBackReference
	private Prova prova;

	@ManyToOne
	@JoinColumn(name = "questao_id", nullable = false, foreignKey = @ForeignKey(name = "ar_questao_id"))
	@JsonBackReference
	private Questao questao;

	@ManyToOne
	@JoinColumn(name = "alternativa_id", nullable = false, foreignKey = @ForeignKey(name = "ar_alternativa_id"))
	@JsonBackReference
	private Alternativa alternativa;

	public AlunoResposta(RespostaDTO resposta) {
		this.aluno = new Aluno(resposta.getAlunoId());
		this.simulado = new Simulado(resposta.getSimuladoId());
		this.prova = new Prova(resposta.getProvaId());
		this.questao = new Questao(resposta.getQuestaoId());
		this.alternativa = new Alternativa(resposta.getAlternativaId());
	}

	public AlunoResposta() {
	}

	public AlunoResposta(Long id, Aluno aluno, Simulado simulado, Prova prova, Questao questao, Alternativa alternativa) {
		this.id = id;
		this.aluno = aluno;
		this.simulado = simulado;
		this.prova = prova;
		this.questao = questao;
		this.alternativa = alternativa;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Simulado getSimulado() {
		return this.simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public Prova getProva() {
		return this.prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Alternativa getAlternativa() {
		return this.alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof AlunoResposta)) {
						return false;
				}
				AlunoResposta alunoResposta = (AlunoResposta) o;
				return Objects.equals(id, alunoResposta.id) && Objects.equals(aluno, alunoResposta.aluno) && Objects.equals(simulado, alunoResposta.simulado) && Objects.equals(prova, alunoResposta.prova) && Objects.equals(questao, alunoResposta.questao) && Objects.equals(alternativa, alunoResposta.alternativa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, aluno, simulado, prova, questao, alternativa);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", aluno='" + getAluno() + "'" +
			", simulado='" + getSimulado() + "'" +
			", prova='" + getProva() + "'" +
			", questao='" + getQuestao() + "'" +
			", alternativa='" + getAlternativa() + "'" +
			"}";
	}

}
