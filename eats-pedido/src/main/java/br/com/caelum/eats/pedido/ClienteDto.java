package br.com.caelum.eats.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	ClienteDto(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
	}

}
