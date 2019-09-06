package br.com.caelum.eats.administrativo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class TipoDeCozinhaDto {

	private Long id;
	private String nome;
	
	TipoDeCozinhaDto(TipoDeCozinha tipo) {
		this(tipo.getId(), tipo.getNome());
	}

}
