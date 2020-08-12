package br.com.caelum.eats.pedido.dto;

public class MediaAvaliacoesDto {

	public MediaAvaliacoesDto() {
		super();
	}

	public MediaAvaliacoesDto(Long restauranteId, Double media) {
		this.restauranteId = restauranteId;
		this.media = media;
	}

	private Long restauranteId;
	private Double media;

	public Long getRestauranteId() {
		return restauranteId;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public void setRestauranteId(Long restauranteId) {
		this.restauranteId = restauranteId;
	}
}
