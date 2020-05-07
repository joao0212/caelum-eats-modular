package br.com.caelum.eats.pedido.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Avaliacao {

	public Avaliacao(Long id, @NotNull @PositiveOrZero @Max(5) Integer nota, @Size(max = 255) String comentario,
			Pedido pedido) {
		this.id = id;
		this.nota = nota;
		this.comentario = comentario;
		this.pedido = pedido;
	}

	public Avaliacao() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@PositiveOrZero
	@Max(5)
	private Integer nota;

	@Size(max = 255)
	private String comentario;

	@OneToOne(optional = false)
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public Integer getNota() {
		return nota;
	}

	public String getComentario() {
		return comentario;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
