package br.com.caelum.eats.distancia.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.distancia.dto.RestauranteComDistanciaDto;
import br.com.caelum.eats.restaurante.dto.RestauranteDto;
import br.com.caelum.eats.restaurante.service.RestauranteService;

/*
 * Serviço que simula a obtenção dos restaurantes mais próximos a um dado CEP.
 * Deve evoluir para uma solução que utiliza geolocalização.
 * 
 */
@Service
public class DistanciaService {

	private static final Pageable LIMIT = PageRequest.of(0, 5);

	@Autowired
	private RestauranteService restauranteService;

	public List<RestauranteComDistanciaDto> listarRestaurantesMaisProximosAoCep(String cep) {
		List<RestauranteDto> aprovados = restauranteService.findAllByAprovado(true, LIMIT).getContent();
		return calcularDistanciaParaOsRestaurantes(aprovados, cep);
	}

	public List<RestauranteComDistanciaDto> listarRestaurantesDoTipoDeCozinhaMaisProximosAoCep(Long tipoDeCozinhaId,
			String cep) {
		List<RestauranteDto> aprovadosDoTipoDeCozinha = restauranteService
				.findAllByAprovadoAndTipoDeCozinha(true, tipoDeCozinhaId, LIMIT).getContent();
		return calcularDistanciaParaOsRestaurantes(aprovadosDoTipoDeCozinha, cep);
	}

	public RestauranteComDistanciaDto buscarRestauranteComDistanciaDoCep(Long restauranteId, String cep) {
		RestauranteDto restaurante = restauranteService.findById(restauranteId);
		String cepDoRestaurante = restaurante.getCep();
		BigDecimal distancia = verificarDistanciaDoCep(cepDoRestaurante, cep);
		return new RestauranteComDistanciaDto(restauranteId, distancia);
	}

	private List<RestauranteComDistanciaDto> calcularDistanciaParaOsRestaurantes(List<RestauranteDto> restaurantes,
			String cep) {
		return restaurantes.stream().map(restaurante -> {
			String cepDoRestaurante = restaurante.getCep();
			BigDecimal distancia = verificarDistanciaDoCep(cepDoRestaurante, cep);
			Long restauranteId = restaurante.getId();
			return new RestauranteComDistanciaDto(restauranteId, distancia);
		}).collect(Collectors.toList());
	}

	private BigDecimal verificarDistanciaDoCep(String cepDoRestaurante, String cep) {
		return calcularDistancia();
	}

	private BigDecimal calcularDistancia() {
		// simulaDemora();
		return new BigDecimal(Math.random() * 15);
	}

	@SuppressWarnings("unused")
	private void simularDemora() {
		// simula demora de 10s a 20s
		long demora = (long) (Math.random() * 10000 + 10000);
		try {
			Thread.sleep(demora);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
