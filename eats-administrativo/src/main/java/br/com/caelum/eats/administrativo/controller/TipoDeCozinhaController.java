package br.com.caelum.eats.administrativo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.administrativo.dto.TipoDeCozinhaDto;
import br.com.caelum.eats.administrativo.service.TipoDeCozinhaService;

@RestController
public class TipoDeCozinhaController {

	private TipoDeCozinhaService tipoDeCozinhaService;

	public TipoDeCozinhaController(TipoDeCozinhaService tipoDeCozinhaService) {
		this.tipoDeCozinhaService = tipoDeCozinhaService;
	}

	@GetMapping("/tipos-de-cozinha")
	List<TipoDeCozinhaDto> listar() {
		return tipoDeCozinhaService.listar();
	}

	@PostMapping("/admin/tipos-de-cozinha")
	TipoDeCozinhaDto adicionar(@RequestBody TipoDeCozinhaDto tipoDeCozinhaDto) {
		return tipoDeCozinhaService.adicionar(tipoDeCozinhaDto);
	}

	@PutMapping("/admin/tipos-de-cozinha/{id}")
	TipoDeCozinhaDto atualizar(@PathVariable("id") Long id, @RequestBody TipoDeCozinhaDto tipoDeCozinhaDto) {
		return tipoDeCozinhaService.atualizar(id, tipoDeCozinhaDto);
	}

	@DeleteMapping("/admin/tipos-de-cozinha/{id}")
	void remover(@PathVariable("id") Long id) {
		tipoDeCozinhaService.remover(id);
	}
}
