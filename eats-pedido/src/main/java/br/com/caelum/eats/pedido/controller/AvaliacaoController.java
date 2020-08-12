package br.com.caelum.eats.pedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.pedido.dto.AvaliacaoDto;
import br.com.caelum.eats.pedido.dto.MediaAvaliacoesDto;
import br.com.caelum.eats.pedido.service.AvaliacaoService;

@RestController
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping("/restaurantes/{restauranteId}/avaliacoes")
	List<AvaliacaoDto> listarAvaliacaoDoRestaurante(@PathVariable("restauranteId") Long restauranteId) {
		return avaliacaoService.listarAvaliacaoDoRestaurante(restauranteId);
	}

	@PostMapping("/restaurantes/{restauranteId}/avaliacoes")
	AvaliacaoDto adicionar(@RequestBody AvaliacaoDto avaliacaoDto) {
		return avaliacaoService.adicionar(avaliacaoDto);
	}

	@GetMapping("/restaurantes/media-avaliacoes")
	List<MediaAvaliacoesDto> listarMediaDasAvaliacoesDosRestaurantes(
			@RequestParam("idsDosRestaurantes") List<Long> idsDosRestaurantes) {
		return avaliacaoService.listarMediaDasAvaliacoesDosRestaurantes(idsDosRestaurantes);
	}
}
