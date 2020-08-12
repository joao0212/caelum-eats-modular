package br.com.caelum.eats.administrativo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.administrativo.enums.Tipo;
import br.com.caelum.eats.administrativo.service.FormaDePagamentoService;

@RestController
public class FormaDePagamentoController {

	@Autowired
	private FormaDePagamentoService formaDePagamentoService;

	@GetMapping("/formas-de-pagamento")
	List<FormaDePagamentoDto> listar() {
		return formaDePagamentoService.listar();
	}

	@GetMapping("/admin/formas-de-pagamento/tipos")
	List<Tipo> listarTipos() {
		return Arrays.asList(Tipo.values());
	}

	@PostMapping("/admin/formas-de-pagamento")
	FormaDePagamentoDto adicionar(@RequestBody FormaDePagamentoDto formaDePagamentoDto) {
		return formaDePagamentoService.adicionar(formaDePagamentoDto);
	}

	@PutMapping("/admin/formas-de-pagamento/{id}")
	FormaDePagamentoDto atualizar(@RequestBody FormaDePagamentoDto formaDePagamentoDto) {
		return formaDePagamentoService.atualizar(formaDePagamentoDto);
	}

	@DeleteMapping("/admin/formas-de-pagamento/{id}")
	void remover(@PathVariable("id") Long id) {
		formaDePagamentoService.remover(id);
	}
}
