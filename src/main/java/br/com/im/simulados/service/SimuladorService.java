package br.com.im.simulados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.simulados.repositoy.SimuladorRepository;

@Service
public class SimuladorService {
	
	@Autowired
	private SimuladorRepository repository;

}
