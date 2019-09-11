package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Resposta;
import br.com.im.simulados.repositoy.RespostaRepository;

@Service
public class RespostaService {

	@Autowired
	private RespostaRepository repository;

	public Resposta findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Resposta> findAll() {
		return (List<Resposta>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Resposta Resposta) {
		this.repository.save(Resposta);
	}

	public void update(Resposta Resposta) {
		this.repository.save(Resposta);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
