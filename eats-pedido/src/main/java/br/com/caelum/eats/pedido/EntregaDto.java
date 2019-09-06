package br.com.caelum.eats.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class EntregaDto {

	private Long id;
	private ClienteDto cliente;
	private String cep;
	private String endereco;
	private String complemento;

	EntregaDto(Entrega entrega) {
		this(entrega.getId(), new ClienteDto(entrega.getCliente()), entrega.getCep(), entrega.getEndereco(), entrega.getComplemento());
	}

}
