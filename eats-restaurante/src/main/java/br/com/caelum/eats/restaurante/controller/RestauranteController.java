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
	RestauranteDto detalhar(@PathVariable("id") Long id) {
		return restauranteService.detalhar(id);
	}

	@GetMapping("/parceiros/restaurantes/do-usuario/{username}")
	public RestauranteDto detalharParceiro(@PathVariable("username") String username) {
		return restauranteService.detalharParceiro(username);
	}

	@GetMapping("/restaurantes")
	List<RestauranteDto> detalharPorIds(@RequestParam("ids") List<Long> ids) {
		return restauranteService.detalharPorIds(ids);
	}

	@GetMapping("/parceiros/restaurantes/{id}")
	RestauranteDto detalharParceiro(@PathVariable("id") Long id) {
		return restauranteService.detalharParceiro(id);
	}

	@PostMapping("/parceiros/restaurantes")
	RestauranteDto adicionar(@RequestBody RestauranteDto restaurante) {
		return restauranteService.adicionar(restaurante);
	}

	@PutMapping("/parceiros/restaurantes/{id}")
	public RestauranteDto atualizar(@RequestBody RestauranteDto restaurante) {
		return restauranteService.atualizar(restaurante);
	}

	@GetMapping("/admin/restaurantes/em-aprovacao")
	List<RestauranteDto> listarPorEmAprovacao() {
		return restauranteService.listarPoremAprovacao();
	}

	@Transactional
	@PatchMapping("/admin/restaurantes/{id}")
	public void aprovar(@PathVariable("id") Long id) {
		restauranteService.aprovar(id);
	}
}
