package br.com.caelum.eats.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class AvaliacaoDto {

	private Long id;
	private Integer nota;
	private String comentario;

	AvaliacaoDto(Avaliacao avaliacao) {
		this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario());
	}
}
