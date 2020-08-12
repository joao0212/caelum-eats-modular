package br.com.caelum.eats.distancia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.distancia.dto.RestauranteComDistanciaDto;
import br.com.caelum.eats.distancia.service.DistanciaService;

@RestController
public class RestaurantesMaisProximosController {

	@Autowired
	private DistanciaService distanciaService;

	@GetMapping("/restaurantes/mais-proximos/{cep}")
	List<RestauranteComDistanciaDto> listarMaisProximos(@PathVariable("cep") String cep) {
		return distanciaService.listarRestaurantesMaisProximosAoCep(cep);
	}

	@GetMapping("/restaurantes/mais-proximos/{cep}/tipos-de-cozinha/{tipoDeCozinhaId}")
	List<RestauranteComDistanciaDto> listarMaisProximos(@PathVariable("cep") String cep,
			@PathVariable("tipoDeCozinhaId") Long tipoDeCozinhaId) {
		return distanciaService.listarRestaurantesDoTipoDeCozinhaMaisProximosAoCep(tipoDeCozinhaId, cep);
	}

	@GetMapping("/restaurantes/{cep}/restaurante/{restauranteId}")
	RestauranteComDistanciaDto buscarComDistanciaPorId(@PathVariable("cep") String cep,
			@PathVariable("restauranteId") Long restauranteId) {
		return distanciaService.buscarRestauranteComDistanciaDoCep(restauranteId, cep);
	}
}
