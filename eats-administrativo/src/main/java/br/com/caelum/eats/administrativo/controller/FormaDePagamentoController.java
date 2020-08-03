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
	List<FormaDePagamentoDto> lista() {
		return formaDePagamentoService.lista();
	}

	@GetMapping("/admin/formas-de-pagamento/tipos")
	List<Tipo> tipos() {
		return Arrays.asList(Tipo.values());
	}

	@PostMapping("/admin/formas-de-pagamento")
	FormaDePagamentoDto adiciona(@RequestBody FormaDePagamentoDto formaDePagamentoDto) {
		return formaDePagamentoService.adiciona(formaDePagamentoDto);
	}

	@PutMapping("/admin/formas-de-pagamento/{id}")
	FormaDePagamentoDto atualiza(@RequestBody FormaDePagamentoDto formaDePagamentoDto) {
		return formaDePagamentoService.atualiza(formaDePagamentoDto);
	}

	@DeleteMapping("/admin/formas-de-pagamento/{id}")
	void remove(@PathVariable("id") Long id) {
		formaDePagamentoService.remove(id);
	}
}
