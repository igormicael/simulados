package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Gabarito;
import br.com.im.simulados.repositoy.GabaritoRepository;

@Service
public class GabaritoService {

	@Autowired
	private GabaritoRepository repository;

	public Gabarito findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Gabarito> findAll() {
		return (List<Gabarito>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Gabarito gabarito) {
		this.repository.save(gabarito);
	}

	public void update(Gabarito gabarito) {
		this.repository.save(gabarito);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public Gabarito findByProvaId(Long id) {
		return this.repository.findByProvaId(id);
	}

}
