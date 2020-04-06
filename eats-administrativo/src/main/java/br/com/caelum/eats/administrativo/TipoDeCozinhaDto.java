package br.com.caelum.eats.administrativo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDeCozinhaDto {

	private Long id;
	private String nome;

	public TipoDeCozinhaDto(TipoDeCozinha tipo) {
		this(tipo.getId(), tipo.getNome());
	}

	public TipoDeCozinha toTipoDeCozinha() {
    return new TipoDeCozinha(id, nome);
	}
}
