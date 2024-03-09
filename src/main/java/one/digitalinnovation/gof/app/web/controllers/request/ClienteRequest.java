package one.digitalinnovation.gof.app.web.controllers.request;


import one.digitalinnovation.gof.domain.models.Endereco;

public class ClienteRequest {

	private Long id;
	private String nome;
	private EnderecoRequest endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}
}
