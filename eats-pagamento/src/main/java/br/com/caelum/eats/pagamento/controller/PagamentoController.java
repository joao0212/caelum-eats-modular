package br.com.caelum.eats.pagamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.eats.pagamento.dto.PagamentoDto;
import br.com.caelum.eats.pagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	private PagamentoService pagamentoService;

	public PagamentoController(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	@GetMapping("/{id}")
	PagamentoDto detalhar(@PathVariable("id") Long id) {
		return pagamentoService.detalhar(id);
	}

	@PostMapping
	ResponseEntity<PagamentoDto> criar(@RequestBody PagamentoDto pagamentoDto, UriComponentsBuilder uriBuilder) {
		return pagamentoService.criar(pagamentoDto, uriBuilder);
	}

	@PutMapping("/{id}")
	PagamentoDto confirmar(@PathVariable("id") Long id) {
		return pagamentoService.confirmar(id);
	}

	@DeleteMapping("/{id}")
	PagamentoDto cancelar(@PathVariable("id") Long id) {
		return pagamentoService.cancelar(id);
	}
}