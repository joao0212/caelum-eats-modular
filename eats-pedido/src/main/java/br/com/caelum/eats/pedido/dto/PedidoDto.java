package br.com.caelum.eats.pedido.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.eats.pedido.enums.Status;
import br.com.caelum.eats.restaurante.dto.RestauranteDto;

public class PedidoDto {

	private Long id;
	private LocalDateTime dataHora;
	private Status status;
	private RestauranteDto restauranteDto;
	private EntregaDto entregaDto;
	private List<ItemDoPedidoDto> itensDoPedidoDto = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public Status getStatus() {
		return status;
	}

	public RestauranteDto getRestauranteDto() {
		return restauranteDto;
	}

	public EntregaDto getEntregaDto() {
		return entregaDto;
	}

	public List<ItemDoPedidoDto> getItensDoPedidoDto() {
		return itensDoPedidoDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setRestauranteDto(RestauranteDto restauranteDto) {
		this.restauranteDto = restauranteDto;
	}

	public void setEntregaDto(EntregaDto entregaDto) {
		this.entregaDto = entregaDto;
	}

	public void setItensDoPedidoDto(List<ItemDoPedidoDto> itensDoPedidoDto) {
		this.itensDoPedidoDto = itensDoPedidoDto;
	}
}
