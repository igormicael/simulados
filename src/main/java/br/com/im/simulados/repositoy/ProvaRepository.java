package br.com.im.simulados.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.simulados.model.Prova;

@Repository
public interface ProvaRepository extends CrudRepository<Prova, Long> {
}
