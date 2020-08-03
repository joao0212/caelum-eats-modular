package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;

public class CardapioDto {

	private Long id;
	private List<CategoriaDoCardapioDto> categorias = new ArrayList<>();

	public CardapioDto(Long id, List<CategoriaDoCardapioDto> categorias) {
		super();
		this.id = id;
		this.categorias = categorias;
	}

	public CardapioDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public List<CategoriaDoCardapioDto> getCategorias() {
		return categorias;
	}
}
