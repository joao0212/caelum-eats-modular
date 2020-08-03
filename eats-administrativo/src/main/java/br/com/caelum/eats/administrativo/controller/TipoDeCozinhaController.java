package br.com.caelum.eats.administrativo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private TipoDeCozinhaService tipoDeCozinhaService;

	@GetMapping("/tipos-de-cozinha")
	List<TipoDeCozinhaDto> lista() {
		return tipoDeCozinhaService.lista();
	}

	@PostMapping("/admin/tipos-de-cozinha")
	TipoDeCozinhaDto adiciona(@RequestBody TipoDeCozinhaDto tipoDeCozinhaDto) {
		return tipoDeCozinhaService.adiciona(tipoDeCozinhaDto);
	}

	@PutMapping("/admin/tipos-de-cozinha/{id}")
	TipoDeCozinhaDto atualiza(@RequestBody TipoDeCozinhaDto tipoDeCozinhaDto) {
		return tipoDeCozinhaService.atualiza(tipoDeCozinhaDto);
	}

	@DeleteMapping("/admin/tipos-de-cozinha/{id}")
	void remove(@PathVariable("id") Long id) {
		tipoDeCozinhaService.remove(id);
	}
}
