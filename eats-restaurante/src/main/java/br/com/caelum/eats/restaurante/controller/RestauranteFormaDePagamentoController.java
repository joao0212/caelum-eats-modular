package br.com.caelum.eats.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.restaurante.service.RestauranteFormaDePagamentoService;

@RestController
public class RestauranteFormaDePagamentoController {

	@Autowired
	private RestauranteFormaDePagamentoService restauranteFormaDePagamentoService;

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/formas-de-pagamento")
	void adiciona(@PathVariable("idRestaurante") Long idRestaurante, @RequestBody Long idFormaDePagamento) {
		restauranteFormaDePagamentoService.adiciona(idRestaurante, idFormaDePagamento);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/formas-de-pagamento/{idFormaDePagamento}")
	void removeDoRestaurante(@PathVariable("idRestaurante") Long idRestaurante,
			@PathVariable("idFormaDePagamento") Long idFormaDePagamento) {
		restauranteFormaDePagamentoService.removeDoRestaurante(idRestaurante, idFormaDePagamento);
	}

	@GetMapping("/restaurantes/{idRestaurante}/formas-de-pagamento")
	List<FormaDePagamentoDto> lista(@PathVariable("idRestaurante") Long idRestaurante) {
		return restauranteFormaDePagamentoService.lista(idRestaurante);
	}
}
