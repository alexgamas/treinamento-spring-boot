package br.com.gamas.treinamento;


public class Request {
	public Long id;
	public String descricao;
	
	public Request() {}
	
	public Request(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
}