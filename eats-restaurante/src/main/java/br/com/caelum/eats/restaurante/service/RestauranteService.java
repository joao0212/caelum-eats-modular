package br.com.caelum.eats.restaurante.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.caelum.eats.administrativo.dto.TipoDeCozinhaDto;
import br.com.caelum.eats.administrativo.service.TipoDeCozinhaService;
import br.com.caelum.eats.restaurante.dto.RestauranteDto;
import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CardapioRepository;
import br.com.caelum.eats.restaurante.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CardapioRepository cardapioRepository;

	@Autowired
	private TipoDeCozinhaService tipoDeCozinhaService;

	@Autowired
	private ModelMapper modelMapper;

	public Page<RestauranteDto> findAllByAprovado(boolean aprovado, Pageable limit) {
		List<RestauranteDto> listaDeRestaurantesDto = restauranteRepository.findAllByAprovado(aprovado, limit)
				.getContent().stream().map(restaurante -> this.transformarParaDto(restaurante))
				.collect(Collectors.toList());
		Page<RestauranteDto> restauranteDtoPage = new PageImpl<RestauranteDto>(listaDeRestaurantesDto);
		return restauranteDtoPage;
	}

	public Page<RestauranteDto> findAllByAprovadoAndTipoDeCozinha(boolean aprovado, Long tipoDeCozinhaId,
			Pageable limit) {
		List<RestauranteDto> listaDeRestaurantesDto = restauranteRepository
				.findAllByAprovadoAndTipoDeCozinha(aprovado, tipoDeCozinhaId, limit).getContent().stream()
				.map(restaurante -> this.transformarParaDto(restaurante)).collect(Collectors.toList());
		Page<RestauranteDto> restauranteDtoPage = new PageImpl<RestauranteDto>(listaDeRestaurantesDto);
		return restauranteDtoPage;
	}

	public RestauranteDto findById(Long id) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		if (!restaurante.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(restaurante.get());
	}

	public RestauranteDto detalhar(Long id) {
		RestauranteDto restauranteDto = this.findById(id);
		TipoDeCozinhaDto tipoDeCozinhaDto = this.tipoDeCozinhaService
				.buscarPorId(restauranteDto.getTipoDeCozinha().getId());
		restauranteDto.setTipoDeCozinha(tipoDeCozinhaDto);
		return restauranteDto;
	}

	public RestauranteDto detalharParceiro(String username) {
		RestauranteDto restauranteDto = this.transformarParaDto(restauranteRepository.findByUsername(username));
		TipoDeCozinhaDto tipoDeCozinhaDto = this.tipoDeCozinhaService
				.buscarPorId(restauranteDto.getTipoDeCozinha().getId());
		restauranteDto.setTipoDeCozinha(tipoDeCozinhaDto);
		return restauranteDto;
	}

	public List<RestauranteDto> detalharPorIds(List<Long> ids) {
		return restauranteRepository.findAllById(ids).stream().map(restaurante -> this.transformarParaDto(restaurante))
				.collect(Collectors.toList());
	}

	public RestauranteDto detalharParceiro(Long id) {
		RestauranteDto restauranteDto = this.findById(id);
		TipoDeCozinhaDto tipoDeCozinhaDto = this.tipoDeCozinhaService
				.buscarPorId(restauranteDto.getTipoDeCozinha().getId());
		restauranteDto.setTipoDeCozinha(tipoDeCozinhaDto);
		return restauranteDto;
	}

	public RestauranteDto adicionar(RestauranteDto restauranteDto) {
		Restaurante restaurante = this.transformarParaObjeto(restauranteDto);
		restaurante.setAprovado(false);
		Restaurante restauranteSalvo = restauranteRepository.save(restaurante);
		Cardapio cardapio = new Cardapio();
		cardapio.setRestaurante(restauranteSalvo);
		cardapioRepository.save(cardapio);
		return this.transformarParaDto(restauranteSalvo);
	}

	public RestauranteDto atualizar(RestauranteDto restauranteDto) {
		Restaurante doBD = restauranteRepository.getOne(restauranteDto.getId());
		// restauranteDto.populaRestaurante(doBD);
		RestauranteDto restauranteSalvo = this.transformarParaDto(restauranteRepository.save(doBD));
		TipoDeCozinhaDto tipoDeCozinhaDto = this.tipoDeCozinhaService
				.buscarPorId(restauranteSalvo.getTipoDeCozinha().getId());
		restauranteSalvo.setTipoDeCozinha(tipoDeCozinhaDto);
		return restauranteSalvo;
	}

	public List<RestauranteDto> listarPoremAprovacao() {
		return restauranteRepository.findAllByAprovado(false).stream()
				.map(restaurante -> this.transformarParaDto(restaurante)).collect(Collectors.toList());
	}

	public void aprovar(@PathVariable("id") Long id) {
		restauranteRepository.aprovarPorId(id);
	}

	private RestauranteDto transformarParaDto(Restaurante restaurante) {
		RestauranteDto restauranteDto = modelMapper.map(restaurante, RestauranteDto.class);
		restauranteDto.setTipoDeCozinha(tipoDeCozinhaService.buscarPorId(restaurante.getTipoDeCozinhaId()));
		return restauranteDto;
	}

	private Restaurante transformarParaObjeto(RestauranteDto restauranteDto) {
		return modelMapper.map(restauranteDto, Restaurante.class);
	}
}
