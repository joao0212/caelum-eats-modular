package br.com.caelum.eats.administrativo.dto;

import br.com.caelum.eats.administrativo.enums.Tipo;

public class FormaDePagamentoDto {

	private Long id;
	private Tipo tipo;
	private String nome;

	public Long getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
