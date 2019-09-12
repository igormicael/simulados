package br.com.im.simulados.repositoy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.simulados.model.AlunoResposta;

@Repository
public interface AlunoRespostaRepository extends CrudRepository<AlunoResposta, Long> {
}
