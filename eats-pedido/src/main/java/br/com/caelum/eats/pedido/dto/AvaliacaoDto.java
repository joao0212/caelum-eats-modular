package br.com.caelum.eats.pedido.dto;

import br.com.caelum.eats.pedido.entidade.Avaliacao;

public class AvaliacaoDto {

	public AvaliacaoDto(Long id, Integer nota, String comentario) {
		this.id = id;
		this.nota = nota;
		this.comentario = comentario;
	}

	public AvaliacaoDto() {
	}

	private Long id;
	private Integer nota;
	private String comentario;

	public AvaliacaoDto(Avaliacao avaliacao) {
		this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario());
	}

	public Long getId() {
		return id;
	}

	public Integer getNota() {
		return nota;
	}

	public String getComentario() {
		return comentario;
	}
}
