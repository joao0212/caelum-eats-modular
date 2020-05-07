package br.com.caelum.eats.pagamento.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;
import br.com.caelum.eats.pedido.entidade.Pedido;

@Entity
public class Pagamento {

	public Pagamento() {
	}

	public Pagamento(Long id, @NotNull @Positive BigDecimal valor, @NotBlank @Size(max = 100) String nome,
			@NotBlank @Size(max = 19) String numero, @NotBlank @Size(max = 7) String expiracao,
			@NotBlank @Size(min = 3, max = 3) String codigo, @NotNull Status status, Pedido pedido,
			FormaDePagamento formaDePagamento) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.numero = numero;
		this.expiracao = expiracao;
		this.codigo = codigo;
		this.status = status;
		this.pedido = pedido;
		this.formaDePagamento = formaDePagamento;
	}

	public static enum Status {
		CRIADO, CONFIRMADO, CANCELADO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotBlank
	@Size(max = 100)
	private String nome;

	@NotBlank
	@Size(max = 19)
	private String numero;

	@NotBlank
	@Size(max = 7)
	private String expiracao;

	@NotBlank
	@Size(min = 3, max = 3)
	private String codigo;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(optional = false)
	private Pedido pedido;

	@ManyToOne(optional = false)
	private FormaDePagamento formaDePagamento;

	public Long getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public String getCodigo() {
		return codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
}
