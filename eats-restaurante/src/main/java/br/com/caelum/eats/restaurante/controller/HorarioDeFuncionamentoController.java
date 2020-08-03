package br.com.caelum.eats.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private HorarioDeFuncionamentoService horarioDeFuncionamentoService;

	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public HorarioDeFuncionamentoDto detalha(@PathVariable("id") Long id) {
		return horarioDeFuncionamentoService.detalha(id);
	}

	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	public List<HorarioDeFuncionamentoDto> lista(@PathVariable("idRestaurante") Long idRestaurante) {
		return horarioDeFuncionamentoService.lista(idRestaurante);
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	public HorarioDeFuncionamentoDto adiciona(@RequestBody HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return horarioDeFuncionamentoService.adiciona(horarioDeFuncionamentoDto);
	}

	@PutMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public HorarioDeFuncionamentoDto atualiza(@RequestBody HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return horarioDeFuncionamentoService.atualiza(horarioDeFuncionamentoDto);
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	public void remove(@PathVariable("id") Long id) {
		horarioDeFuncionamentoService.remove(id);
	}
}
