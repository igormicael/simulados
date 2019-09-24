package br.com.im.simulados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Gabarito;
import br.com.im.simulados.model.Prova;
import br.com.im.simulados.repositoy.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repository;

	@Autowired
	private GabaritoService gabaritoService;

	public Prova findById(Long id) {
		Optional<Prova> findById = this.repository.findById(id);
		return findById.get();
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

	public Prova findByIdWithGabarito(Long id) {
		Prova prova = findById(id);
		List<Gabarito> gabaritos = gabaritoService.findAllByProvaId(id);
		prova.setGabaritos(gabaritos);
		return prova;
	}

	public List<Prova> findAllBySimuladoId(Long id) {
		return this.repository.findAllBySimuladoId(id);
	}

}
