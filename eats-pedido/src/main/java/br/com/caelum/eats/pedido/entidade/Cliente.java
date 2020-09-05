package br.com.caelum.eats.pedido.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Cliente {

	@NotBlank
	@Size(max = 100)
	@Column(name = "nome_do_cliente")
	private String nome;

	@NotBlank
	@Size(max = 14)
	@Column(name = "cpf_do_cliente")
	private String cpf;

	@NotBlank
	@Size(max = 100)
	@Column(name = "email_do_cliente")
	private String email;

	@NotBlank
	@Size(max = 16)
	@Column(name = "telefone_do_cliente")
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
