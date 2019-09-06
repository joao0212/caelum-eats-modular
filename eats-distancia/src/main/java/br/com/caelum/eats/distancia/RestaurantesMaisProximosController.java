package br.com.caelum.eats.distancia;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class RestaurantesMaisProximosController {

	private DistanciaService distanciaService;

	@GetMapping("/restaurantes/mais-proximos/{cep}")
	List<RestauranteComDistanciaDto> maisProximos(@PathVariable("cep") String cep) {
		return distanciaService.restaurantesMaisProximosAoCep(cep);
	}

	@GetMapping("/restaurantes/mais-proximos/{cep}/tipos-de-cozinha/{tipoDeCozinhaId}")
	List<RestauranteComDistanciaDto> maisProximos(@PathVariable("cep") String cep,
			@PathVariable("tipoDeCozinhaId") Long tipoDeCozinhaId) {
		return distanciaService.restaurantesDoTipoDeCozinhaMaisProximosAoCep(tipoDeCozinhaId, cep);
	}

	@GetMapping("/restaurantes/{cep}/restaurante/{restauranteId}")
	RestauranteComDistanciaDto comDistanciaPorId(@PathVariable("cep") String cep,
			@PathVariable("restauranteId") Long restauranteId) {
		return distanciaService.restauranteComDistanciaDoCep(restauranteId, cep);
	}

}
