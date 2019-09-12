package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.repositoy.AlternativaRepository;

@Service
public class AlternativaService {

	@Autowired
	private AlternativaRepository repository;

	public Alternativa findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Alternativa> findAll() {
		return (List<Alternativa>) this.repository.findAll();
	}

	public List<Alternativa> findAllByQuestaoId(Long idQuestao) {
		return this.repository.findAllByQuestaoId(idQuestao);
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Alternativa disciplina) {
		this.repository.save(disciplina);
	}

	public void update(Alternativa disciplina) {
		this.repository.save(disciplina);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
