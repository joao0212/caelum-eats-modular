package br.com.caelum.eats.administrativo;

import br.com.caelum.eats.administrativo.FormaDePagamento.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class FormaDePagamentoDto {

	private Long id;
	private Tipo tipo;
	private String nome;

	FormaDePagamentoDto(FormaDePagamento forma) {
		this(forma.getId(), forma.getTipo(), forma.getNome());
	}
	
}
