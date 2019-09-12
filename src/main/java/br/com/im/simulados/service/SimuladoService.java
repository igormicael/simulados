package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.Simulado;
import br.com.im.simulados.repositoy.SimuladoRepository;

@Service
public class SimuladoService {

	@Autowired
	private SimuladoRepository repository;

	public Simulado findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Simulado> findAll() {
		return (List<Simulado>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Simulado simulado) {
		this.repository.save(simulado);
	}

	public void update(Simulado simulado) {
		this.repository.save(simulado);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public List<Simulado> ranking(Long id) {
		return null;
	}

}
