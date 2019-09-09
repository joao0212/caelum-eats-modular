package br.com.caelum.eats.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.eats.restaurante.RestauranteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

	private Long id;
	private LocalDateTime dataHora;
	private Pedido.Status status;
	private RestauranteDto restaurante;
	private EntregaDto entrega;
	private List<ItemDoPedidoDto> itens = new ArrayList<>();
	
	public PedidoDto(Pedido pedido) {
		this(pedido.getId(), pedido.getDataHora(), pedido.getStatus(), new RestauranteDto(pedido.getRestaurante()), new EntregaDto(pedido.getEntrega()), trataItens(pedido.getItens()));
	}

	private static List<ItemDoPedidoDto> trataItens(List<ItemDoPedido> itens) {
		return itens.stream().map(ItemDoPedidoDto::new).collect(Collectors.toList());
	}

	public BigDecimal getTotal() {
		BigDecimal total = restaurante.getTaxaDeEntregaEmReais() != null ? restaurante.getTaxaDeEntregaEmReais() : BigDecimal.ZERO;
		for (ItemDoPedidoDto item : itens) {
			BigDecimal preco = item.getItemDoCardapio().getPrecoPromocional() != null ? item.getItemDoCardapio().getPrecoPromocional() : item.getItemDoCardapio().getPreco() ;
			total = total.add(preco.multiply(new BigDecimal(item.getQuantidade())));
		}
		return total;
	}
}
