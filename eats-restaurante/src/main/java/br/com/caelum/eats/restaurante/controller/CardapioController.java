package br.com.caelum.eats.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.CardapioDto;
import br.com.caelum.eats.restaurante.service.CardapioService;

@RestController
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;

	@GetMapping("/restaurantes/{idRestaurante}/cardapio")
	CardapioDto cardapioDoRestaurante(@PathVariable("idRestaurante") Long idRestaurante) {
		return cardapioService.cardapioDoRestaurante(idRestaurante);
	}

	@GetMapping("/restaurantes/{idRestaurante}/cardapio/{idCardapio}")
	CardapioDto porId(@PathVariable("idCardapio") Long idCardapio) {
		return cardapioService.porId(idCardapio);
	}
}
