package br.com.caelum.eats.restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.CategoriaDoCardapioDto;
import br.com.caelum.eats.restaurante.service.CategoriaDoCardapioService;

@RestController
public class CategoriaDoCardapioController {

	private CategoriaDoCardapioService categoriaDoCardapioService;

	public CategoriaDoCardapioController(CategoriaDoCardapioService categoriaDoCardapioService) {
		this.categoriaDoCardapioService = categoriaDoCardapioService;
	}

	@GetMapping("/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}")
	CategoriaDoCardapioDto buscarCategoriaPorId(@PathVariable("idCategoria") Long idCategoria) {
		return categoriaDoCardapioService.buscarCategoriaPorId(idCategoria);
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria")
	CategoriaDoCardapioDto salvarCardapioDoRestaurantePorCategoria(
			@RequestBody CategoriaDoCardapioDto categoriaDoCardapioDto) {
		return categoriaDoCardapioService.salvarCardapioDoRestaurantePorCategoria(categoriaDoCardapioDto);
	}
}
