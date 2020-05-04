package br.com.caelum.eats.administrativo.dto;

import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;
import br.com.caelum.eats.administrativo.entidade.FormaDePagamento.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaDePagamentoDto {

	private Long id;
	private Tipo tipo;
	private String nome;

	public FormaDePagamentoDto(FormaDePagamento forma) {
		this(forma.getId(), forma.getTipo(), forma.getNome());
	}

}
