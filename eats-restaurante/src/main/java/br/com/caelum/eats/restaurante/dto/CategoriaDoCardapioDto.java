package br.com.caelum.eats.restaurante.dto;

import java.util.List;

public class CategoriaDoCardapioDto {

	private Long id;
	private String nome;

	public CategoriaDoCardapioDto(Long id, String nome, List<ItemDoCardapioDto> itens) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public CategoriaDoCardapioDto() {
		super();
	}

	public Long getId() {
		return id;
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
}
