package br.com.caelum.eats.restaurante.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;

@Entity
public class RestauranteFormaDePagamento {

	public RestauranteFormaDePagamento(RestauranteFormaDePagamentoId id, Restaurante restaurante,
			FormaDePagamento formaDePagamento) {
		this.id = id;
		this.restaurante = restaurante;
		this.formaDePagamento = formaDePagamento;
	}

	public RestauranteFormaDePagamento() {
	}

	@EmbeddedId
	private RestauranteFormaDePagamentoId id;

	@ManyToOne
	@MapsId("restauranteId")
	private Restaurante restaurante;

	@ManyToOne
	@MapsId("formaDePagamentoId")
	private FormaDePagamento formaDePagamento;

	public RestauranteFormaDePagamentoId getId() {
		return id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	@Embeddable
	public static class RestauranteFormaDePagamentoId implements Serializable {
		private static final long serialVersionUID = 1L;

		public RestauranteFormaDePagamentoId(Long restauranteId, Long formaDePagamentoId) {
			this.restauranteId = restauranteId;
			this.formaDePagamentoId = formaDePagamentoId;
		}

		public RestauranteFormaDePagamentoId() {
			super();
		}

		@Column(name = "restaurante_id")
		private Long restauranteId;

		@Column(name = "forma_de_pagamento_id")
		private Long formaDePagamentoId;

		public Long getRestauranteId() {
			return restauranteId;
		}

		public Long getFormaDePagamentoId() {
			return formaDePagamentoId;
		}
	}
}
