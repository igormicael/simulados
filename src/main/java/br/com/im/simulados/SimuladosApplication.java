package br.com.im.simulados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SimuladosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimuladosApplication.class, args);
	}

}
