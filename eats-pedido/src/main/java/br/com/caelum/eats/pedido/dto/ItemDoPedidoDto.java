package br.com.caelum.eats.pedido.dto;

import br.com.caelum.eats.pedido.entidade.ItemDoPedido;
import br.com.caelum.eats.restaurante.dto.ItemDoCardapioDto;

public class ItemDoPedidoDto {

	public ItemDoPedidoDto(Long id, Integer quantidade, String observacao, ItemDoCardapioDto itemDoCardapio) {
		this.id = id;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.itemDoCardapio = itemDoCardapio;
	}

	public ItemDoPedidoDto() {
		super();
	}

	private Long id;
	private Integer quantidade;
	private String observacao;
	private ItemDoCardapioDto itemDoCardapio;

	public ItemDoPedidoDto(ItemDoPedido item) {
		this(item.getId(), item.getQuantidade(), item.getObservacao(), new ItemDoCardapioDto(item.getItemDoCardapio()));
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public ItemDoCardapioDto getItemDoCardapio() {
		return itemDoCardapio;
	}
}
