package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Disciplina;
import br.com.im.simulados.repositoy.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	public Disciplina findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Disciplina> findAll() {
		return (List<Disciplina>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Disciplina disciplina) {
		this.repository.save(disciplina);
	}

	public void update(Disciplina disciplina) {
		this.repository.save(disciplina);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
