package br.com.caelum.eats.pedido.entidade;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Entrega {

	public Entrega(Long id, Cliente cliente, @NotBlank @Size(max = 9) String cep,
			@NotBlank @Size(max = 255) String endereco, @Size(max = 255) String complemento, Pedido pedido) {
		this.id = id;
		this.cliente = cliente;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.pedido = pedido;
	}

	public Entrega() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Cliente cliente;

	@NotBlank
	@Size(max = 9)
	private String cep;

	@NotBlank
	@Size(max = 255)
	private String endereco;

	@Size(max = 255)
	private String complemento;

	@OneToOne(optional = false)
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
