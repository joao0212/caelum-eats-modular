package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDoCardapioDto {

	private Long id;
	private String nome;
	private Long cardapioId;
	private List<ItemDoCardapioDto> itens = new ArrayList<>();

	public CategoriaDoCardapioDto(Long id, String nome, List<ItemDoCardapioDto> itens) {
		super();
		this.id = id;
		this.nome = nome;
		this.itens = itens;
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

	public Long getCardapioId() {
		return cardapioId;
	}

	public List<ItemDoCardapioDto> getItens() {
		return itens;
	}
}
