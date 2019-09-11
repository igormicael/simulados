package br.com.im.simulados.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuladorRepository extends CrudRepository<SimuladorRepository, Long>{}
