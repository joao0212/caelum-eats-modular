package br.com.caelum.eats.restaurante.controller;

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

	private ItemDoCardapioService itemDoCardapioService;

	public ItemDoCardapioController(ItemDoCardapioService itemDoCardapioService) {
		this.itemDoCardapioService = itemDoCardapioService;
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item")
	public ItemDoCardapioDto adicionarItem(@RequestBody ItemDoCardapioDto item) {
		return itemDoCardapioService.adicionarItem(item);
	}

	@PutMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public ItemDoCardapioDto atualizarItem(@PathVariable("idItem") Long id, @RequestBody ItemDoCardapioDto item) {
		return itemDoCardapioService.atualizarItem(id, item);
	}

	@GetMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public ItemDoCardapioDto buscarItemPorId(@PathVariable("idItem") Long idItem) {
		return itemDoCardapioService.buscarItemPorId(idItem);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/cardapio/{idCardapio}/categoria/{idCategoria}/item/{idItem}")
	public void removerItem(@PathVariable("idItem") Long idItem) {
		itemDoCardapioService.removerItem(idItem);
	}
}
