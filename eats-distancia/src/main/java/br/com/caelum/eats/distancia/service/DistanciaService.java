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

	public List<RestauranteComDistanciaDto> restaurantesMaisProximosAoCep(String cep) {
		List<RestauranteDto> aprovados = restauranteService.findAllByAprovado(true, LIMIT).getContent();
		return calculaDistanciaParaOsRestaurantes(aprovados, cep);
	}

	public List<RestauranteComDistanciaDto> restaurantesDoTipoDeCozinhaMaisProximosAoCep(Long tipoDeCozinhaId,
			String cep) {
		List<RestauranteDto> aprovadosDoTipoDeCozinha = restauranteService
				.findAllByAprovadoAndTipoDeCozinha(true, tipoDeCozinhaId, LIMIT).getContent();
		return calculaDistanciaParaOsRestaurantes(aprovadosDoTipoDeCozinha, cep);
	}

	public RestauranteComDistanciaDto restauranteComDistanciaDoCep(Long restauranteId, String cep) {
		RestauranteDto restaurante = restauranteService.findById(restauranteId);
		String cepDoRestaurante = restaurante.getCep();
		BigDecimal distancia = distanciaDoCep(cepDoRestaurante, cep);
		return new RestauranteComDistanciaDto(restauranteId, distancia);
	}

	private List<RestauranteComDistanciaDto> calculaDistanciaParaOsRestaurantes(List<RestauranteDto> restaurantes,
			String cep) {
		return restaurantes.stream().map(restaurante -> {
			String cepDoRestaurante = restaurante.getCep();
			BigDecimal distancia = distanciaDoCep(cepDoRestaurante, cep);
			Long restauranteId = restaurante.getId();
			return new RestauranteComDistanciaDto(restauranteId, distancia);
		}).collect(Collectors.toList());
	}

	private BigDecimal distanciaDoCep(String cepDoRestaurante, String cep) {
		return calculaDistancia();
	}

	private BigDecimal calculaDistancia() {
		// simulaDemora();
		return new BigDecimal(Math.random() * 15);
	}

	@SuppressWarnings("unused")
	private void simulaDemora() {
		// simula demora de 10s a 20s
		long demora = (long) (Math.random() * 10000 + 10000);
		try {
			Thread.sleep(demora);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
