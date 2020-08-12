package br.com.caelum.eats.pedido.dto;

import br.com.caelum.eats.restaurante.dto.ItemDoCardapioDto;

public class ItemDoPedidoDto {

	public ItemDoPedidoDto() {
		super();
	}

	public ItemDoPedidoDto(Long id, Integer quantidade, String observacao, ItemDoCardapioDto itemDoCardapioDto) {
		this.id = id;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.itemDoCardapioDto = itemDoCardapioDto;
	}

	private Long id;
	private Integer quantidade;
	private String observacao;
	private ItemDoCardapioDto itemDoCardapioDto;

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public ItemDoCardapioDto getItemDoCardapioDto() {
		return itemDoCardapioDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setItemDoCardapioDto(ItemDoCardapioDto itemDoCardapioDto) {
		this.itemDoCardapioDto = itemDoCardapioDto;
	}
}
