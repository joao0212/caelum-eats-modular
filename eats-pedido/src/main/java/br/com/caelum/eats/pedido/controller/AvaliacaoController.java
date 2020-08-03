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
	List<AvaliacaoDto> listaDoRestaurante(@PathVariable("restauranteId") Long restauranteId) {
		return avaliacaoService.listaDoRestaurante(restauranteId);
	}

	@PostMapping("/restaurantes/{restauranteId}/avaliacoes")
	AvaliacaoDto adiciona(@RequestBody AvaliacaoDto avaliacaoDto) {
		return avaliacaoService.adiciona(avaliacaoDto);
	}

	@GetMapping("/restaurantes/media-avaliacoes")
	List<MediaAvaliacoesDto> mediaDasAvaliacoesDosRestaurantes(
			@RequestParam("idsDosRestaurantes") List<Long> idsDosRestaurantes) {
		return avaliacaoService.mediaDasAvaliacoesDosRestaurantes(idsDosRestaurantes);
	}
}
