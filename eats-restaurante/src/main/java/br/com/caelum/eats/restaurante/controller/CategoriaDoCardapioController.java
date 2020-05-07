package br.com.caelum.eats.restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.CategoriaDoCardapioDto;
import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CategoriaDoCardapioRepository;

@RestController
class CategoriaDoCardapioController {

	private CategoriaDoCardapioRepository repo;

	@GetMapping("/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}")
	CategoriaDoCardapioDto categoriaPorId(@PathVariable("idCategoria") Long idCategoria) {
		CategoriaDoCardapio categoria = repo.findById(idCategoria).orElseThrow(() -> new ResourceNotFoundException());
		return new CategoriaDoCardapioDto(categoria);
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria")
	CategoriaDoCardapioDto cardapioDoRestaurante(@PathVariable("idCardapio") Long idCardapio,
			@RequestBody CategoriaDoCardapio categoria) {
		return new CategoriaDoCardapioDto(repo.save(categoria));
	}

}
