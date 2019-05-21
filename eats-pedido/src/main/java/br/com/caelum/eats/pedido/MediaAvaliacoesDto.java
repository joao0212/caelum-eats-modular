package br.com.caelum.eats.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class MediaAvaliacoesDto {

	private Long restauranteId;
	private Double media;

}
