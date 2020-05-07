package br.com.caelum.eats.pagamento.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.pagamento.entidade.Pagamento;
import br.com.caelum.eats.pagamento.entidade.Pagamento.Status;
import br.com.caelum.eats.pedido.dto.PedidoDto;

public class PagamentoDto {

	public PagamentoDto(Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo,
			Status status, FormaDePagamentoDto formaDePagamento, PedidoDto pedido) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.numero = numero;
		this.expiracao = expiracao;
		this.codigo = codigo;
		this.status = status;
		this.formaDePagamento = formaDePagamento;
		this.pedido = pedido;
	}

	public PagamentoDto() {
		super();
	}

	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Pagamento.Status status;
	private FormaDePagamentoDto formaDePagamento;
	private PedidoDto pedido;

	public PagamentoDto(Pagamento p) {
		this(p.getId(), p.getValor(), p.getNome(), p.getNumero(), p.getExpiracao(), p.getCodigo(), p.getStatus(),
				new FormaDePagamentoDto(p.getFormaDePagamento()), new PedidoDto(p.getPedido()));
	}

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

	public Pagamento.Status getStatus() {
		return status;
	}

	public FormaDePagamentoDto getFormaDePagamento() {
		return formaDePagamento;
	}

	public PedidoDto getPedido() {
		return pedido;
	}
}
