package br.com.caelum.eats.distancia.dto;

import java.math.BigDecimal;

public class RestauranteComDistanciaDto {

	public RestauranteComDistanciaDto() {

	}

	public RestauranteComDistanciaDto(Long restauranteId, BigDecimal distancia) {
		super();
		this.restauranteId = restauranteId;
		this.distancia = distancia;
	}

	private Long restauranteId;
	private BigDecimal distancia;

	public Long getRestauranteId() {
		return restauranteId;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setRestauranteId(Long restauranteId) {
		this.restauranteId = restauranteId;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}
}
