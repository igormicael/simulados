package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.model.Questao;
import br.com.im.simulados.repositoy.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repository;

	@Autowired
	private AlternativaService alternativaService;

	public Questao findById(Long id) {
		Questao questao = this.repository.findById(id).get();
		questao.setAlternativas(alternativaService.findAllByQuestaoId(id));
		return questao;
	}

	public List<Questao> findAll() {
		return (List<Questao>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Questao disciplina) {
		this.repository.save(disciplina);
	}

	public void update(Questao disciplina) {
		this.repository.save(disciplina);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public List<Alternativa> findAlternativasById(Long id) {
		return alternativaService.findAllByQuestaoId(id);
	}

}
