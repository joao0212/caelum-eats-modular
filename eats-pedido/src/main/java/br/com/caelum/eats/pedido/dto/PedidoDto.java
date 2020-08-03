package br.com.caelum.eats.pedido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.eats.pedido.enums.Status;
import br.com.caelum.eats.restaurante.dto.RestauranteDto;

public class PedidoDto {

	public PedidoDto() {

	}

	public PedidoDto(Long id, LocalDateTime dataHora, Status status, RestauranteDto restaurante, EntregaDto entrega,
			List<ItemDoPedidoDto> itens) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.restaurante = restaurante;
		this.entrega = entrega;
		this.itens = itens;
	}

	private Long id;
	private LocalDateTime dataHora;
	private Status status;
	private RestauranteDto restaurante;
	private EntregaDto entrega;
	private List<ItemDoPedidoDto> itens = new ArrayList<>();

	public BigDecimal getTotal() {
		BigDecimal total = restaurante.getTaxaDeEntregaEmReais() != null ? restaurante.getTaxaDeEntregaEmReais()
				: BigDecimal.ZERO;
		for (ItemDoPedidoDto item : itens) {
			BigDecimal preco = item.getItemDoCardapioDto().getPrecoPromocional() != null
					? item.getItemDoCardapioDto().getPrecoPromocional()
					: item.getItemDoCardapioDto().getPreco();
			total = total.add(preco.multiply(new BigDecimal(item.getQuantidade())));
		}
		return total;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public Status getStatus() {
		return status;
	}

	public RestauranteDto getRestaurante() {
		return restaurante;
	}

	public EntregaDto getEntrega() {
		return entrega;
	}

	public List<ItemDoPedidoDto> getItens() {
		return itens;
	}
}
