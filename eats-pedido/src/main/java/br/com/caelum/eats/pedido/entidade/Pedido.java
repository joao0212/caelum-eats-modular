package br.com.caelum.eats.pedido.entidade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.caelum.eats.restaurante.entidade.Restaurante;

@Entity
public class Pedido {

	public Pedido(Long id, @NotNull LocalDateTime dataHora, @NotNull Status status, Restaurante restaurante,
			Entrega entrega, List<ItemDoPedido> itens) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.restaurante = restaurante;
		this.entrega = entrega;
		this.itens = itens;
	}

	public Pedido() {
		super();
	}

	public static enum Status {
		REALIZADO, PAGO, CONFIRMADO, PRONTO, SAIU_PARA_ENTREGA, ENTREGUE;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDateTime dataHora;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(optional = false)
	private Restaurante restaurante;

	@OneToOne(cascade = CascadeType.PERSIST, optional = false, mappedBy = "pedido")
	private Entrega entrega;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pedido")
	private List<ItemDoPedido> itens = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public List<ItemDoPedido> getItens() {
		return itens;
	}
}
