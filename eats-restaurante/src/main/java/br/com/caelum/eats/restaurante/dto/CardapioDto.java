package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;

public class CardapioDto {

	private Long id;
	private List<CategoriaDoCardapioDto> categoriasDoCardapioDto = new ArrayList<>();

	public CardapioDto(Long id, List<CategoriaDoCardapioDto> categoriasDoCardapioDto) {
		super();
		this.id = id;
		this.categoriasDoCardapioDto = categoriasDoCardapioDto;
	}

	public CardapioDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public List<CategoriaDoCardapioDto> getCategoriasDoCardapioDto() {
		return categoriasDoCardapioDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategoriasDoCardapioDto(List<CategoriaDoCardapioDto> categoriasDoCardapioDto) {
		this.categoriasDoCardapioDto = categoriasDoCardapioDto;
	}
}
