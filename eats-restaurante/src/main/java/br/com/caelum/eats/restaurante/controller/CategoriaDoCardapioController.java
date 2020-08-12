package br.com.caelum.eats.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.CategoriaDoCardapioDto;
import br.com.caelum.eats.restaurante.service.CategoriaDoCardapioService;

@RestController
public class CategoriaDoCardapioController {

	@Autowired
	private CategoriaDoCardapioService categoriaDoCardapioService;

	@GetMapping("/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}")
	CategoriaDoCardapioDto buscarCategoriaPorId(@PathVariable("idCategoria") Long idCategoria) {
		return categoriaDoCardapioService.buscarCategoriaPorId(idCategoria);
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria")
	CategoriaDoCardapioDto buscarCardapioDoRestaurante(@PathVariable("idCardapio") Long idCardapio,
			@RequestBody CategoriaDoCardapioDto categoriaDoCardapioDto) {
		return categoriaDoCardapioService.buscarCardapioDoRestaurante(idCardapio, categoriaDoCardapioDto);
	}
}
