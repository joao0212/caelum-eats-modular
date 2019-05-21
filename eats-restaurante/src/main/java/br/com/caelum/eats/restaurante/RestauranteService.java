package br.com.caelum.eats.restaurante;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@Service
@AllArgsConstructor
public class RestauranteService {

	@Delegate
	private RestauranteRepository repo;

}
