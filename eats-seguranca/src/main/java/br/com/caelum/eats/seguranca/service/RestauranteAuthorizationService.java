package br.com.caelum.eats.seguranca.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.restaurante.dto.RestauranteDto;
import br.com.caelum.eats.restaurante.service.RestauranteService;
import br.com.caelum.eats.seguranca.entidade.Role;
import br.com.caelum.eats.seguranca.entidade.User;

@Service
public class RestauranteAuthorizationService {

	private RestauranteService restauranteService;

	public RestauranteAuthorizationService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}

	public boolean checaId(Authentication authentication, long id) {
		User user = (User) authentication.getPrincipal();
		if (user.isInRole(Role.ROLES.PARCEIRO)) {
			RestauranteDto restauranteDto = restauranteService.buscarPorIdUsuario(user.getId());
			if (restauranteDto != null) {
				return id == restauranteDto.getId();
			}
		}
		return false;
	}

	public boolean checaUsername(Authentication authentication, String username) {
		User user = (User) authentication.getPrincipal();
		return user.isInRole(Role.ROLES.PARCEIRO) && user.getName().equals(username);
	}
}
