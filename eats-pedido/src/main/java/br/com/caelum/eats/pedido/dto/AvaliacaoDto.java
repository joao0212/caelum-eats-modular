package br.com.caelum.eats.pedido.dto;

public class AvaliacaoDto {

	public AvaliacaoDto() {

	}

	public AvaliacaoDto(Long id, Integer nota, String comentario) {
		this.id = id;
		this.nota = nota;
		this.comentario = comentario;
	}

	private Long id;
	private Integer nota;
	private String comentario;

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
