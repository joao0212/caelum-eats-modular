package br.com.caelum.eats.restaurante.dto;

import java.util.List;

public class CategoriaDoCardapioDto {

	private Long id;
	private String nome;
	private CardapioDto cardapioDto;
	private List<ItemDoCardapioDto> itens;

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

	public CardapioDto getCardapioDto() {
		return cardapioDto;
	}

	public void setCardapioDto(CardapioDto cardapioDto) {
		this.cardapioDto = cardapioDto;
	}

	public List<ItemDoCardapioDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoCardapioDto> itens) {
		this.itens = itens;
	}
}
