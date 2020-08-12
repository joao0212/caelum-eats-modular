package br.com.caelum.eats.restaurante.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.restaurante.dto.CardapioDto;
import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CardapioRepository;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository cardapioRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CardapioDto buscarCardapioDoRestaurante(Long idRestaurante) {
		return this.transformarParaDto(cardapioRepository.buscarPorIdRestaurante(idRestaurante));
	}

	public CardapioDto porId(Long idCardapio) {
		Optional<Cardapio> cardapio = cardapioRepository.findById(idCardapio);
		if (!cardapio.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(cardapio.get());
	}

	private CardapioDto transformarParaDto(Cardapio cardapio) {
		return modelMapper.map(cardapio, CardapioDto.class);
	}
}
