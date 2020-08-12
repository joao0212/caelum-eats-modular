package br.com.caelum.eats.pagamento.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.pagamento.enums.Status;
import br.com.caelum.eats.pedido.dto.PedidoDto;

public class PagamentoDto {

	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private FormaDePagamentoDto formaDePagamentoDto;
	private PedidoDto pedidoDto;

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

	public FormaDePagamentoDto getFormaDePagamentoDto() {
		return formaDePagamentoDto;
	}

	public PedidoDto getPedidoDto() {
		return pedidoDto;
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

	public void setFormaDePagamentoDto(FormaDePagamentoDto formaDePagamentoDto) {
		this.formaDePagamentoDto = formaDePagamentoDto;
	}

	public void setPedidoDto(PedidoDto pedidoDto) {
		this.pedidoDto = pedidoDto;
	}
}
