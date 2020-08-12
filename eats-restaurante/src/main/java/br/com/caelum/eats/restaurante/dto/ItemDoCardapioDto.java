package br.com.caelum.eats.restaurante.dto;

import java.math.BigDecimal;

public class ItemDoCardapioDto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private CategoriaDoCardapioDto categoriaDoCardapioDto;

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

	public CategoriaDoCardapioDto getCategoriaDoCardapioDto() {
		return categoriaDoCardapioDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public void setCategoriaDoCardapioDto(CategoriaDoCardapioDto categoriaDoCardapioDto) {
		this.categoriaDoCardapioDto = categoriaDoCardapioDto;
	}
}
