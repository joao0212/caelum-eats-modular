package br.com.caelum.eats.restaurante.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;

public class ItemDoCardapioDto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private BigDecimal precoPromocional;

	public ItemDoCardapioDto(ItemDoCardapio item) {
		this(item.getId(), item.getNome(), item.getDescricao(), item.getPreco(), item.getPrecoPromocional());
	}

	public ItemDoCardapioDto(Long id, String nome, String descricao, BigDecimal preco, BigDecimal precoPromocional) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.precoPromocional = precoPromocional;
	}

	public ItemDoCardapioDto() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}
}
