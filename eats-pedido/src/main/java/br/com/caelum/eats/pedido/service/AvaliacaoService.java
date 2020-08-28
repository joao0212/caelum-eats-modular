package br.com.caelum.eats.pedido.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pedido.dto.AvaliacaoDto;
import br.com.caelum.eats.pedido.dto.MediaAvaliacoesDto;
import br.com.caelum.eats.pedido.entidade.Avaliacao;
import br.com.caelum.eats.pedido.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<AvaliacaoDto> listarAvaliacaoDoRestaurante(Long restauranteId) {
		return avaliacaoRepository.findAllByRestauranteId(restauranteId).stream()
				.map(avaliacao -> this.transformarParaDto(avaliacao)).collect(Collectors.toList());
	}

	public AvaliacaoDto adicionar(AvaliacaoDto avaliacaoDto) {
		Avaliacao avaliacao = avaliacaoRepository.save(this.transformarParaObjeto(avaliacaoDto));
		return this.transformarParaDto(avaliacao);
	}

	public List<MediaAvaliacoesDto> listarMediaDasAvaliacoesDosRestaurantes(List<Long> idsDosRestaurantes) {
		List<MediaAvaliacoesDto> medias = new ArrayList<>();
		for (Long restauranteId : idsDosRestaurantes) {
			Double media = avaliacaoRepository.buscarMediaDoRestaurantePeloId(restauranteId);
			medias.add(new MediaAvaliacoesDto(restauranteId, media));
		}
		return medias;
	}

	private AvaliacaoDto transformarParaDto(Avaliacao avaliacao) {
		return modelMapper.map(avaliacao, AvaliacaoDto.class);
	}

	private Avaliacao transformarParaObjeto(AvaliacaoDto avaliacaoDto) {
		return modelMapper.map(avaliacaoDto, Avaliacao.class);
	}
}
