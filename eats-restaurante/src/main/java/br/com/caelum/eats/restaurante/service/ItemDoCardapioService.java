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
	private ModelMapper modelMapper;

	public ItemDoCardapioDto adicionaItem(ItemDoCardapioDto item) {
		ItemDoCardapio itemDoCardapio = itemDoCardapioRepository.save(this.transformarParaObjeto(item));
		return this.transformarParaDto(itemDoCardapio);
	}

	public ItemDoCardapioDto atualizaItem(ItemDoCardapioDto item) {
		ItemDoCardapio itemDoCardapio = itemDoCardapioRepository.save(this.transformarParaObjeto(item));
		return this.transformarParaDto(itemDoCardapio);
	}

	public ItemDoCardapioDto itemPorId(Long idItem) {
		Optional<ItemDoCardapio> item = itemDoCardapioRepository.findById(idItem);
		if (!item.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(item.get());
	}

	public void removeItem(Long idItem) {
		itemDoCardapioRepository.deleteById(idItem);
	}

	private ItemDoCardapio transformarParaObjeto(ItemDoCardapioDto itemDoCardapioDto) {
		return modelMapper.map(itemDoCardapioDto, ItemDoCardapio.class);
	}

	private ItemDoCardapioDto transformarParaDto(ItemDoCardapio itemDoCardapio) {
		return modelMapper.map(itemDoCardapio, ItemDoCardapioDto.class);
	}
}
