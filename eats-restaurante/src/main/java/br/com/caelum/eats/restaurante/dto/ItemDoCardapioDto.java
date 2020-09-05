package br.com.caelum.eats.restaurante.dto;

import java.math.BigDecimal;

public class ItemDoCardapioDto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private Long categoriaDoCardapioId;

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

	public Long getCategoriaDoCardapioId() {
		return categoriaDoCardapioId;
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

	public void setCategoriaDoCardapioId(Long categoriaDoCardapioId) {
		this.categoriaDoCardapioId = categoriaDoCardapioId;
	}
}
