package br.com.im.simulados.repositoy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.simulados.model.Gabarito;

@Repository
public interface GabaritoRepository extends CrudRepository<Gabarito, Long> {

  Gabarito findByProvaId(Long provaId);
  List<Gabarito> findAllByProvaId(Long provaId);
}
