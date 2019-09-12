package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Prova;
import br.com.im.simulados.repositoy.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repository;

	public Prova findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Prova> findAll() {
		return (List<Prova>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Prova prova) {
		this.repository.save(prova);
	}

	public void update(Prova prova) {
		this.repository.save(prova);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public Prova findGabaritoById(Long id) {
		return null;
	}

}
