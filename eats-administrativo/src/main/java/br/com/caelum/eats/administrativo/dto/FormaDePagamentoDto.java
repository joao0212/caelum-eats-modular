package br.com.caelum.eats.administrativo.dto;

import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;
import br.com.caelum.eats.administrativo.entidade.FormaDePagamento.Tipo;

public class FormaDePagamentoDto {

	private Long id;
	private Tipo tipo;
	private String nome;

	public FormaDePagamentoDto(FormaDePagamento forma) {
		this(forma.getId(), forma.getTipo(), forma.getNome());
	}

	public FormaDePagamentoDto() {
	}

	public FormaDePagamentoDto(Long id, Tipo tipo, String nome) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}
}
