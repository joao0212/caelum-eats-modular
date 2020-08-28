package br.com.caelum.eats.pedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.pedido.dto.PedidoDto;
import br.com.caelum.eats.pedido.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/pedidos")
	List<PedidoDto> listar() {
		return pedidoService.listar();
	}

	@GetMapping("/pedidos/{id}")
	PedidoDto porId(@PathVariable("id") Long id) {
		return pedidoService.buscarPorId(id);
	}

	@PostMapping("/pedidos")
	PedidoDto adicionar(@RequestBody PedidoDto pedidoDto) {
		return pedidoService.adicionar(pedidoDto);
	}

	@PutMapping("/pedidos/{id}/status")
	void atualizarStatus(@PathVariable("id") Long id, @RequestBody PedidoDto pedidoDto) {
		pedidoService.atualizarStatus(id, pedidoDto);
	}

	@GetMapping("/parceiros/restaurantes/{restauranteId}/pedidos/pendentes")
	List<PedidoDto> listarPendentes(@PathVariable("restauranteId") Long restauranteId) {
		return pedidoService.listarPendentes(restauranteId);
	}
}
