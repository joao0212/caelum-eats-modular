package br.com.caelum.eats.restaurante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.HorarioDeFuncionamentoDto;
import br.com.caelum.eats.restaurante.service.HorarioDeFuncionamentoService;

@RestController
public class HorarioDeFuncionamentoController {

	private HorarioDeFuncionamentoService horarioDeFuncionamentoService;

	public HorarioDeFuncionamentoController(HorarioDeFuncionamentoService horarioDeFuncionamentoService) {
		this.horarioDeFuncionamentoService = horarioDeFuncionamentoService;
	}

	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public HorarioDeFuncionamentoDto detalhar(@PathVariable("id") Long id) {
		return horarioDeFuncionamentoService.detalhar(id);
	}

	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	public List<HorarioDeFuncionamentoDto> listar(@PathVariable("idRestaurante") Long idRestaurante) {
		return horarioDeFuncionamentoService.listar(idRestaurante);
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	public HorarioDeFuncionamentoDto adicionar(@RequestBody HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return horarioDeFuncionamentoService.adicionar(horarioDeFuncionamentoDto);
	}

	@PutMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public HorarioDeFuncionamentoDto atualizar(@PathVariable("id") Long id,
			@RequestBody HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return horarioDeFuncionamentoService.atualizar(id, horarioDeFuncionamentoDto);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public void remover(@PathVariable("id") Long id) {
		horarioDeFuncionamentoService.remover(id);
	}
}
