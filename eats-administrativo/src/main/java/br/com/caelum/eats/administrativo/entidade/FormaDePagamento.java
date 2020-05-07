package br.com.caelum.eats.administrativo.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class FormaDePagamento {

	public FormaDePagamento() {

	}

	public FormaDePagamento(Long id, @NotNull Tipo tipo, @NotBlank @Size(max = 100) String nome) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
	}

	public static enum Tipo {
		CARTAO_CREDITO, CARTAO_DEBITO, VALE_REFEICAO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@NotBlank
	@Size(max = 100)
	private String nome;

	public Long getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}
}
