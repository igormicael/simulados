package br.com.im.simulados.model;

public enum DificuldadeQuestao {

	FACIL("Facil", 15L), MEDIA("Media", 12L), DIFICIL("Dificil", 8L);

	private String descricao;
	private Long valor;

	private DificuldadeQuestao(String descricao, Long valor){
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public Long getValor(){
		return this.valor;
	}

}
