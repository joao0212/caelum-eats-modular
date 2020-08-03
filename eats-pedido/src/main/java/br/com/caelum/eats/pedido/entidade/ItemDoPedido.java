package br.com.caelum.eats.pedido.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class ItemDoPedido {

	public ItemDoPedido() {

	}

	public ItemDoPedido(Long id, @NotNull @Positive Integer quantidade, String observacao, Pedido pedido,
			Long itemDoCardapioId) {
		this.id = id;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.pedido = pedido;
		this.itemDoCardapioId = itemDoCardapioId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Positive
	private Integer quantidade;

	private String observacao;

	@ManyToOne(optional = false)
	private Pedido pedido;

	@Column(name = "item_do_cardapio_id")
	private Long itemDoCardapioId;

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Long getItemDoCardapioId() {
		return itemDoCardapioId;
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
		ItemDoPedido other = (ItemDoPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
