package br.com.caelum.eats.restaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.administrativo.entidade.TipoDeCozinha;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.repository.RestauranteRepository;

@Service
public class RestauranteService {

	private RestauranteRepository repo;

	public Page<Restaurante> findAllByAprovado(boolean aprovado, Pageable limit) {
		return repo.findAllByAprovado(aprovado, limit);
	}

	public Page<Restaurante> findAllByAprovadoAndTipoDeCozinha(boolean aprovado, TipoDeCozinha tipo, Pageable limit) {
		return repo.findAllByAprovadoAndTipoDeCozinha(aprovado, tipo, limit);
	}

	public Optional<Restaurante> findById(Long id) {
		return repo.findById(id);
	}
}
