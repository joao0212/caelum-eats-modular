package br.com.caelum.eats.restaurante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.restaurante.service.RestauranteFormaDePagamentoService;

@RestController
public class RestauranteFormaDePagamentoController {

	private RestauranteFormaDePagamentoService restauranteFormaDePagamentoService;

	public RestauranteFormaDePagamentoController(
			RestauranteFormaDePagamentoService restauranteFormaDePagamentoService) {
		this.restauranteFormaDePagamentoService = restauranteFormaDePagamentoService;
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/formas-de-pagamento")
	void adicionar(@PathVariable("idRestaurante") Long idRestaurante, @RequestParam Long idFormaDePagamento) {
		restauranteFormaDePagamentoService.adicionar(idRestaurante, idFormaDePagamento);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/formas-de-pagamento/{idFormaDePagamento}")
	void removerDoRestaurante(@PathVariable("idRestaurante") Long idRestaurante,
			@PathVariable("idFormaDePagamento") Long idFormaDePagamento) {
		restauranteFormaDePagamentoService.removerDoRestaurante(idRestaurante, idFormaDePagamento);
	}

	@GetMapping("/restaurantes/{idRestaurante}/formas-de-pagamento")
	List<FormaDePagamentoDto> listar(@PathVariable("idRestaurante") Long idRestaurante) {
		return restauranteFormaDePagamentoService.listar(idRestaurante);
	}
}
