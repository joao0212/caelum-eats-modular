package br.com.caelum.eats.pagamento.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.pagamento.entidade.Pagamento;
import br.com.caelum.eats.pedido.dto.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDto {

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

}
