package br.com.im.simulados.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.simulados.model.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
}
