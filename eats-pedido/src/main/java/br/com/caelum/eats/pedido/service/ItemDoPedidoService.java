package br.com.caelum.eats.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pedido.dto.ItemDoPedidoDto;
import br.com.caelum.eats.restaurante.dto.ItemDoCardapioDto;
import br.com.caelum.eats.restaurante.service.ItemDoCardapioService;

@Service
public class ItemDoPedidoService {

	@Autowired
	private ItemDoCardapioService itemDoCardapioService;

	public ItemDoPedidoDto buscar(Long id, Integer quantidade, String observacao, Long itemDoCardapioDtoId) {
		ItemDoCardapioDto itemDoCardapioDto = itemDoCardapioService.buscarPorId(itemDoCardapioDtoId);
		return new ItemDoPedidoDto(id, quantidade, observacao, itemDoCardapioDto);
	}
}
