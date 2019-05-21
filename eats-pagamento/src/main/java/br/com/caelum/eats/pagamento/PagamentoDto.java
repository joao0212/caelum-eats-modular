package br.com.caelum.eats.pagamento;

import java.math.BigDecimal;

import br.com.caelum.eats.admin.FormaDePagamento;
import br.com.caelum.eats.pedido.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class PagamentoDto {

	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Pagamento.Status status;
	private FormaDePagamento formaDePagamento;
	private PedidoDto pedido;

	public PagamentoDto(Pagamento p) {
		this(p.getId(), p.getValor(), p.getNome(), p.getNumero(), p.getExpiracao(), p.getCodigo(), p.getStatus(), p.getFormaDePagamento(), new PedidoDto(p.getPedido()));
	}

}
