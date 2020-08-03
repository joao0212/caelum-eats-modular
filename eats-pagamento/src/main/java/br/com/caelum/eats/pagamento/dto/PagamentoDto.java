package br.com.caelum.eats.pagamento.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.pagamento.entidade.Pagamento;
import br.com.caelum.eats.pagamento.enums.Status;
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

	public PagamentoDto(Pagamento p, FormaDePagamentoDto formaDePagamentoDto, PedidoDto pedidoDto) {
		this(p.getId(), p.getValor(), p.getNome(), p.getNumero(), p.getExpiracao(), p.getCodigo(), p.getStatus(),
				formaDePagamentoDto, pedidoDto);
	}

	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private FormaDePagamentoDto formaDePagamento;
	private PedidoDto pedido;

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

	public FormaDePagamentoDto getFormaDePagamento() {
		return formaDePagamento;
	}

	public PedidoDto getPedido() {
		return pedido;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setFormaDePagamento(FormaDePagamentoDto formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}
}
