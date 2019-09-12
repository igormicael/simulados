package br.com.im.simulados.repositoy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.simulados.model.Alternativa;

@Repository
public interface AlternativaRepository extends CrudRepository<Alternativa, Long> {

  List<Alternativa> findAllByQuestaoId(Long id);
}
