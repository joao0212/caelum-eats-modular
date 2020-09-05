package br.com.caelum.eats.restaurante.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.restaurante.dto.CategoriaDoCardapioDto;
import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CategoriaDoCardapioRepository;

@Service
public class CategoriaDoCardapioService {

	@Autowired
	private CategoriaDoCardapioRepository categoriaDoCardapioRepository;

	@Autowired
	private CardapioService cardapioService;

	@Autowired
	private ModelMapper modelMapper;

	public CategoriaDoCardapioDto buscarCategoriaPorId(Long idCategoria) {
		Optional<CategoriaDoCardapio> categoriaDoCardapio = categoriaDoCardapioRepository.findById(idCategoria);
		if (!categoriaDoCardapio.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(categoriaDoCardapio.get());
	}

	public CategoriaDoCardapioDto salvarCardapioDoRestaurantePorCategoria(
			CategoriaDoCardapioDto categoriaDoCardapioDto) {
		CategoriaDoCardapio categoriaDoCardapio = this.transformarParaObjeto(categoriaDoCardapioDto);
		categoriaDoCardapioRepository.save(categoriaDoCardapio);
		return this.transformarParaDto(categoriaDoCardapio);
	}

	private CategoriaDoCardapioDto transformarParaDto(CategoriaDoCardapio categoriaDoCardapio) {
		CategoriaDoCardapioDto categoriaDoCardapioDto = modelMapper.map(categoriaDoCardapio,
				CategoriaDoCardapioDto.class);
		categoriaDoCardapioDto.setCardapioDto(this.cardapioService.porId(categoriaDoCardapio.getCardapioId()));
		return categoriaDoCardapioDto;
	}

	private CategoriaDoCardapio transformarParaObjeto(CategoriaDoCardapioDto categoriaDoCardapioDto) {
		return modelMapper.map(categoriaDoCardapioDto, CategoriaDoCardapio.class);
	}
}
