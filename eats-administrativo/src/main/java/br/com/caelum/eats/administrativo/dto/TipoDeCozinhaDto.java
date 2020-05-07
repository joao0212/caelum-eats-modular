package br.com.caelum.eats.administrativo.dto;

import br.com.caelum.eats.administrativo.entidade.TipoDeCozinha;

public class TipoDeCozinhaDto {

	private Long id;
	private String nome;

	public TipoDeCozinhaDto() {
	}

	public TipoDeCozinhaDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public TipoDeCozinhaDto(TipoDeCozinha tipo) {
		this(tipo.getId(), tipo.getNome());
	}

	public TipoDeCozinha toTipoDeCozinha() {
		return new TipoDeCozinha(id, nome);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
