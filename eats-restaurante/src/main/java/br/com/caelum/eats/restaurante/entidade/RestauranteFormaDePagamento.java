package br.com.caelum.eats.restaurante.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class RestauranteFormaDePagamento {

	public RestauranteFormaDePagamento(RestauranteFormaDePagamentoId id, Restaurante restaurante,
			Long idFormaDePagamento) {
		this.id = id;
		this.restaurante = restaurante;
		this.idFormaDePagamento = idFormaDePagamento;
	}

	public RestauranteFormaDePagamento() {

	}

	@EmbeddedId
	private RestauranteFormaDePagamentoId id;

	@ManyToOne
	@MapsId("restauranteId")
	private Restaurante restaurante;

	@Column(name = "forma_de_pagamento_id")
	private Long idFormaDePagamento;

	public RestauranteFormaDePagamentoId getId() {
		return id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public Long getIdFormaDePagamento() {
		return idFormaDePagamento;
	}

	@Embeddable
	public static class RestauranteFormaDePagamentoId implements Serializable {
		private static final long serialVersionUID = 1L;

		public RestauranteFormaDePagamentoId(Long restauranteId, Long formaDePagamentoId) {
			this.restauranteId = restauranteId;
		}

		public RestauranteFormaDePagamentoId() {
			super();
		}

		@Column(name = "restaurante_id")
		private Long restauranteId;

		public Long getRestauranteId() {
			return restauranteId;
		}
	}
}
