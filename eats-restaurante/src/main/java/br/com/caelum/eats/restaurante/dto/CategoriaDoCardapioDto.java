package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;

public class CategoriaDoCardapioDto {

	private Long id;
	private String nome;
	private List<ItemDoCardapioDto> itens = new ArrayList<>();

	public CategoriaDoCardapioDto(Long id, String nome, List<ItemDoCardapioDto> itens) {
		super();
		this.id = id;
		this.nome = nome;
		this.itens = itens;
	}

	public CategoriaDoCardapioDto(CategoriaDoCardapio categoria) {
		this(categoria.getId(), categoria.getNome(), trataItens(categoria.getItens()));
	}

	public CategoriaDoCardapioDto() {
		super();
	}

	private static List<ItemDoCardapioDto> trataItens(List<ItemDoCardapio> itens) {
		return itens.stream().map(ItemDoCardapioDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<ItemDoCardapioDto> getItens() {
		return itens;
	}
}
