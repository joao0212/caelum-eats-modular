package br.com.caelum.eats.restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.CardapioDto;
import br.com.caelum.eats.restaurante.service.CardapioService;

@RestController
public class CardapioController {

	private CardapioService cardapioService;

	public CardapioController(CardapioService cardapioService) {
		this.cardapioService = cardapioService;
	}

	@GetMapping("/restaurantes/{idRestaurante}/cardapio")
	CardapioDto buscarCardapioDoRestaurante(@PathVariable("idRestaurante") Long idRestaurante) {
		return cardapioService.buscarCardapioDoRestaurante(idRestaurante);
	}

	@GetMapping("/restaurantes/{idRestaurante}/cardapio/{idCardapio}")
	CardapioDto porId(@PathVariable("idCardapio") Long idCardapio) {
		return cardapioService.porId(idCardapio);
	}
}
