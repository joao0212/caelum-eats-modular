package br.com.caelum.eats.pedido;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Cliente {

	@NotBlank
	@Size(max = 100)
	@Column(name = "nome_do_cliente")
	private String nome;

	@NotBlank
	@Size(max = 14)
	@Column(name = "cpf_do_cliente")
	private String cpf;

	@NotBlank
	@Size(max = 100)
	@Column(name = "email_do_cliente")
	private String email;

	@NotBlank
	@Size(max = 16)
	@Column(name = "telefone_do_cliente")
	private String telefone;

}
