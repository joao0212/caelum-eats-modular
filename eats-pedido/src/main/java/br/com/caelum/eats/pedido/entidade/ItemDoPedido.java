package br.com.caelum.eats.pedido.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;

@Entity
public class ItemDoPedido {

	public ItemDoPedido() {
	}

	public ItemDoPedido(Long id, @NotNull @Positive Integer quantidade, String observacao, Pedido pedido,
			ItemDoCardapio itemDoCardapio) {
		this.id = id;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.pedido = pedido;
		this.itemDoCardapio = itemDoCardapio;
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

	@ManyToOne(optional = false)
	private ItemDoCardapio itemDoCardapio;

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

	public ItemDoCardapio getItemDoCardapio() {
		return itemDoCardapio;
	}
}
