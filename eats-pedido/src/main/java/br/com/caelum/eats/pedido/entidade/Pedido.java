package br.com.caelum.eats.pedido.entidade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.caelum.eats.pedido.enums.Status;

@Entity
public class Pedido {

	public Pedido(Long id, @NotNull LocalDateTime dataHora, @NotNull Status status, Long restauranteId, Entrega entrega,
			List<ItemDoPedido> itensDoPedido) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.restauranteId = restauranteId;
		this.entrega = entrega;
		this.itensDoPedido = itensDoPedido;
	}

	public Pedido() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDateTime dataHora;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "restaurante_id")
	private Long restauranteId;

	@OneToOne(cascade = CascadeType.PERSIST, optional = false, mappedBy = "pedido")
	private Entrega entrega;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pedido")
	private List<ItemDoPedido> itensDoPedido = new ArrayList<>();

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

	public Long getRestauranteId() {
		return restauranteId;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public List<ItemDoPedido> getItensDoPedido() {
		return itensDoPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
