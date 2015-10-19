package br.com.gamas.treinamento.model;

public enum Situacao {
	
	PENDENTE(1, "Pendente de avaliação"), 
	APROVADO(2, "Aprovado"), 
	REPROVADO(3, "Reprovado");
 
	private int codigo;
	private String descricao;

	Situacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
