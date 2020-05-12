package br.com.caelum.eats.pedido.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.pedido.dto.PedidoDto;
import br.com.caelum.eats.pedido.entidade.Pedido;
import br.com.caelum.eats.pedido.repository.PedidoRepository;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;

@RestController
public class PedidoController {

	@Autowired
	private PedidoRepository repo;

	public PedidoController() {
	}

	@GetMapping("/pedidos")
	List<PedidoDto> lista() {
		return repo.findAll().stream().map(pedido -> new PedidoDto(pedido)).collect(Collectors.toList());
	}

	@GetMapping("/pedidos/{id}")
	PedidoDto porId(@PathVariable("id") Long id) {
		Pedido pedido = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new PedidoDto(pedido);
	}

	@PostMapping("/pedidos")
	PedidoDto adiciona(@RequestBody Pedido pedido) {
		pedido.setDataHora(LocalDateTime.now());
		pedido.setStatus(Pedido.Status.REALIZADO);
		pedido.getItens().forEach(item -> item.setPedido(pedido));
		pedido.getEntrega().setPedido(pedido);
		Pedido salvo = repo.save(pedido);
		return new PedidoDto(salvo);
	}

	@PutMapping("/pedidos/{id}/status")
	PedidoDto atualizaStatus(@RequestBody Pedido pedido) {
		repo.atualizaStatus(pedido.getStatus(), pedido);
		return new PedidoDto(pedido);
	}

	@GetMapping("/parceiros/restaurantes/{restauranteId}/pedidos/pendentes")
	List<PedidoDto> pendentes(@PathVariable("restauranteId") Long restauranteId) {
		return repo
				.doRestauranteSemOsStatus(restauranteId, Arrays.asList(Pedido.Status.REALIZADO, Pedido.Status.ENTREGUE))
				.stream().map(pedido -> new PedidoDto(pedido)).collect(Collectors.toList());
	}

}
