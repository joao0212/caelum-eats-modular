package br.com.caelum.eats.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class EntregaDto {

	private Long id;
	private Cliente cliente;
	private String cep;
	private String endereco;
	private String complemento;

	public EntregaDto(Entrega entrega) {
		this(entrega.getId(), entrega.getCliente(), entrega.getCep(), entrega.getEndereco(), entrega.getComplemento());
	}

}
