package br.com.caelum.eats.pedido.dto;

import br.com.caelum.eats.pedido.entidade.Entrega;

public class EntregaDto {

	public EntregaDto(Long id, ClienteDto cliente, String cep, String endereco, String complemento) {
		this.id = id;
		this.cliente = cliente;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
	}

	public EntregaDto() {
		super();
	}

	private Long id;
	private ClienteDto cliente;
	private String cep;
	private String endereco;
	private String complemento;

	EntregaDto(Entrega entrega) {
		this(entrega.getId(), new ClienteDto(entrega.getCliente()), entrega.getCep(), entrega.getEndereco(),
				entrega.getComplemento());
	}

	public Long getId() {
		return id;
	}

	public ClienteDto getCliente() {
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
}
