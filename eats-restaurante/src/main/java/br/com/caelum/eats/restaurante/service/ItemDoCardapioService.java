package br.com.caelum.eats.restaurante.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.restaurante.dto.ItemDoCardapioDto;
import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.ItemDoCardapioRepository;

@Service
public class ItemDoCardapioService {

	@Autowired
	private ItemDoCardapioRepository itemDoCardapioRepository;

	@Autowired
	private CategoriaDoCardapioService categoriaDoCardapioService;

	@Autowired
	private ModelMapper modelMapper;

	public ItemDoCardapioDto adicionarItem(ItemDoCardapioDto item) {
		ItemDoCardapio itemDoCardapio = itemDoCardapioRepository.save(this.transformarParaObjeto(item));
		return this.transformarParaDto(itemDoCardapio);
	}

	public ItemDoCardapioDto buscarPorId(Long id) {
		Optional<ItemDoCardapio> itemDoCardapio = itemDoCardapioRepository.findById(id);
		if (!itemDoCardapio.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(itemDoCardapio.get());
	}

	public ItemDoCardapioDto atualizarItem(ItemDoCardapioDto item) {
		ItemDoCardapio itemDoCardapio = itemDoCardapioRepository.save(this.transformarParaObjeto(item));
		return this.transformarParaDto(itemDoCardapio);
	}

	public ItemDoCardapioDto buscarItemPorId(Long idItem) {
		Optional<ItemDoCardapio> item = itemDoCardapioRepository.findById(idItem);
		if (!item.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(item.get());
	}

	public void removerItem(Long idItem) {
		itemDoCardapioRepository.deleteById(idItem);
	}

	private ItemDoCardapio transformarParaObjeto(ItemDoCardapioDto itemDoCardapioDto) {
		return modelMapper.map(itemDoCardapioDto, ItemDoCardapio.class);
	}

	private ItemDoCardapioDto transformarParaDto(ItemDoCardapio itemDoCardapio) {
		ItemDoCardapioDto itemDoCardapioDto = modelMapper.map(itemDoCardapio, ItemDoCardapioDto.class);
		itemDoCardapioDto.setCategoriaDoCardapioDto(
				categoriaDoCardapioService.buscarCategoriaPorId(itemDoCardapio.getCategoriaDoCardapio().getId()));
		return itemDoCardapioDto;
	}
}
