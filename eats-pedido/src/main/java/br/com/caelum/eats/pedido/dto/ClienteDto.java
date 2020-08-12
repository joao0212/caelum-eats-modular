package br.com.caelum.eats.pedido.dto;

import br.com.caelum.eats.pedido.entidade.Cliente;

public class ClienteDto {

	public ClienteDto() {
		super();
	}

	public ClienteDto(String nome, String cpf, String email, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	ClienteDto(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
	}

	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
