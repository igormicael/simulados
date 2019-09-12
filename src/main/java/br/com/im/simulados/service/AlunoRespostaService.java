package br.com.im.simulados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.model.AlunoResposta;
import br.com.im.simulados.repositoy.AlunoRespostaRepository;

@Service
public class AlunoRespostaService {

	@Autowired
	private AlunoRespostaRepository repository;

	public AlunoResposta findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<AlunoResposta> findAll() {
		return (List<AlunoResposta>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(AlunoResposta alunoResposta) {
		this.repository.save(alunoResposta);
	}

	public void update(AlunoResposta alunoResposta) {
		this.repository.save(alunoResposta);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
