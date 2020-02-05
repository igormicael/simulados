package br.com.im.simulados.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DificuldadeQuestao {

	FACIL("Facil", 15L), MEDIA("Media", 12L), DIFICIL("Dificil", 8L);

	private String descricao;
	private Long valor;

}
