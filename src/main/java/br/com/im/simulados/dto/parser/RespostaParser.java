package br.com.im.simulados.dto.parser;

import br.com.im.simulados.dto.RespostaDTO;
import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.model.Aluno;
import br.com.im.simulados.model.AlunoResposta;
import br.com.im.simulados.model.Prova;
import br.com.im.simulados.model.Questao;
import br.com.im.simulados.model.Simulado;

public class RespostaParser {
	
	public AlunoResposta getFromDTO(RespostaDTO dto) {
		return new AlunoResposta(dto.getId(), new Aluno(dto.getAlunoId()) , new Simulado(dto.getSimuladoId()), new Prova(dto.getProvaId()), new Questao(dto.getQuestaoId()), new Alternativa(dto.getAlternativaId()) );
	}
	
	public RespostaDTO getFromEntidade(AlunoResposta entidade) {
		RespostaDTO respostaDTO = new RespostaDTO();
		
		if(entidade != null) {
			
			respostaDTO.setId(entidade.getId());
			
			if(entidade.getAluno() != null && entidade.getAluno().getId() != null) {
				respostaDTO.setAlunoId(entidade.getAluno().getId());
			}
			
			if(entidade.getAlternativa() != null && entidade.getAlternativa().getId() != null) {
				respostaDTO.setAlternativaId(entidade.getAlternativa().getId());
			}
			
			if(entidade.getProva() != null && entidade.getProva().getId() != null) {
				respostaDTO.setProvaId(entidade.getProva().getId());
			}
			
			if(entidade.getQuestao() != null && entidade.getQuestao().getId() != null) {
				respostaDTO.setQuestaoId(entidade.getQuestao().getId());
			}
		}
		
		return respostaDTO;
	}

}
