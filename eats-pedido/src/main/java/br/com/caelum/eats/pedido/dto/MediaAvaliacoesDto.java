package br.com.caelum.eats.pedido.dto;

public class MediaAvaliacoesDto {

	public MediaAvaliacoesDto(Long restauranteId, Double media) {
		this.restauranteId = restauranteId;
		this.media = media;
	}

	public MediaAvaliacoesDto() {
		super();
	}

	private Long restauranteId;
	private Double media;

	public Long getRestauranteId() {
		return restauranteId;
	}

	public Double getMedia() {
		return media;
	}
}
