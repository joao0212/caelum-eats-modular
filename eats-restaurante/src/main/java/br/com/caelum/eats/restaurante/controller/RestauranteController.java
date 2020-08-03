package br.com.caelum.eats.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.restaurante.dto.RestauranteDto;
import br.com.caelum.eats.restaurante.service.RestauranteService;

@RestController
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping("/restaurantes/{id}")
	RestauranteDto detalha(@PathVariable("id") Long id) {
		return restauranteService.detalha(id);
	}

	@GetMapping("/parceiros/restaurantes/do-usuario/{username}")
	public RestauranteDto detalhaParceiro(@PathVariable("username") String username) {
		return restauranteService.detalhaParceiro(username);
	}

	@GetMapping("/restaurantes")
	List<RestauranteDto> detalhePorIds(@RequestParam("ids") List<Long> ids) {
		return restauranteService.detalhePorIds(ids);
	}

	@GetMapping("/parceiros/restaurantes/{id}")
	RestauranteDto detalhaParceiro(@PathVariable("id") Long id) {
		return restauranteService.detalhaParceiro(id);
	}

	@PostMapping("/parceiros/restaurantes")
	RestauranteDto adiciona(@RequestBody RestauranteDto restaurante) {
		return restauranteService.adiciona(restaurante);
	}

	@PutMapping("/parceiros/restaurantes/{id}")
	public RestauranteDto atualiza(@RequestBody RestauranteDto restaurante) {
		return restauranteService.atualiza(restaurante);
	}

	@GetMapping("/admin/restaurantes/em-aprovacao")
	List<RestauranteDto> emAprovacao() {
		return restauranteService.emAprovacao();
	}

	@Transactional
	@PatchMapping("/admin/restaurantes/{id}")
	public void aprova(@PathVariable("id") Long id) {
		restauranteService.aprova(id);
	}
}
