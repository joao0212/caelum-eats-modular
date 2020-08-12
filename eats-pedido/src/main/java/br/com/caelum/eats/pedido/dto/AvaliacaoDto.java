package br.com.caelum.eats.pedido.dto;

public class AvaliacaoDto {

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

	public void setId(Long id) {
		this.id = id;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
