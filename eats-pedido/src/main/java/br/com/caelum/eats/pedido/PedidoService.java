package br.com.caelum.eats.pedido;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@Service
@AllArgsConstructor
public class PedidoService {

	@Delegate
	private PedidoRepository repo;

}
