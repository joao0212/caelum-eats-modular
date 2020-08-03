package br.com.caelum.eats.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.ItemDoCardapioDto;
import br.com.caelum.eats.restaurante.service.ItemDoCardapioService;

@RestController
public class ItemDoCardapioController {

	@Autowired
	private ItemDoCardapioService itemDoCardapioService;

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item")
	public ItemDoCardapioDto adicionaItem(@RequestBody ItemDoCardapioDto item) {
		return itemDoCardapioService.adicionaItem(item);
	}

	@PutMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public ItemDoCardapioDto atualizaItem(@RequestBody ItemDoCardapioDto item) {
		return itemDoCardapioService.atualizaItem(item);
	}

	@GetMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public ItemDoCardapioDto itemPorId(@PathVariable("idItem") Long idItem) {
		return itemDoCardapioService.itemPorId(idItem);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public void removeItem(@PathVariable("idItem") Long idItem) {
		itemDoCardapioService.removeItem(idItem);
	}
}
