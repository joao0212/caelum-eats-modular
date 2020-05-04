package br.com.caelum.eats.distancia.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteComDistanciaDto {

	private Long restauranteId;

	private BigDecimal distancia;

}
