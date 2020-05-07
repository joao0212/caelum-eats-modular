package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;

public class CardapioDto {

	private Long id;
	private List<CategoriaDoCardapioDto> categorias = new ArrayList<>();

	public CardapioDto(Long id, List<CategoriaDoCardapioDto> categorias) {
		super();
		this.id = id;
		this.categorias = categorias;
	}

	public CardapioDto(Cardapio cardapio) {
		this(cardapio.getId(), trataCategorias(cardapio.getCategorias()));
	}

	public CardapioDto() {
		super();
	}

	private static List<CategoriaDoCardapioDto> trataCategorias(List<CategoriaDoCardapio> categorias) {
		return categorias.stream().map(CategoriaDoCardapioDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public List<CategoriaDoCardapioDto> getCategorias() {
		return categorias;
	}
}
