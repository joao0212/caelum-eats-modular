package br.com.caelum.eats.restaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.administrativo.service.FormaDePagamentoService;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.entidade.RestauranteFormaDePagamento;
import br.com.caelum.eats.restaurante.entidade.RestauranteFormaDePagamento.RestauranteFormaDePagamentoId;
import br.com.caelum.eats.restaurante.repository.RestauranteFormaDePagamentoRepository;

@Service
public class RestauranteFormaDePagamentoService {

	@Autowired
	private RestauranteFormaDePagamentoRepository restauranteFormaDePagamentoRepository;

	@Autowired
	private FormaDePagamentoService formaDePagamentoService;

	public void adicionar(Long idRestaurante, Long idFormaDePagamento) {
		RestauranteFormaDePagamentoId id = new RestauranteFormaDePagamentoId(idRestaurante, idFormaDePagamento);
		Restaurante restaurante = new Restaurante();
		restaurante.setId(idRestaurante);
		RestauranteFormaDePagamento restauranteFormaDePagamento = new RestauranteFormaDePagamento(id, restaurante,
				idFormaDePagamento);
		restauranteFormaDePagamentoRepository.save(restauranteFormaDePagamento);
	}

	public void removerDoRestaurante(Long idRestaurante, Long idFormaDePagamento) {
		RestauranteFormaDePagamentoId id = new RestauranteFormaDePagamentoId(idRestaurante, idFormaDePagamento);
		restauranteFormaDePagamentoRepository.deleteById(id);
	}

	public List<FormaDePagamentoDto> listar(Long idRestaurante) {
		List<RestauranteFormaDePagamento> listaRestauranteFormaDePagamentos = restauranteFormaDePagamentoRepository
				.findAllByRestauranteOrderByNomeAsc(idRestaurante);
		List<Long> ids = new ArrayList<Long>();
		listaRestauranteFormaDePagamentos.forEach(lfp -> ids.add(lfp.getIdFormaDePagamento()));
		List<FormaDePagamentoDto> formasDePagamentoDto = formaDePagamentoService.buscarPorIds(ids);
		return formasDePagamentoDto;
	}
}
