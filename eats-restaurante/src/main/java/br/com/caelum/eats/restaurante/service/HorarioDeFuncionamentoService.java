package br.com.caelum.eats.restaurante.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.restaurante.dto.HorarioDeFuncionamentoDto;
import br.com.caelum.eats.restaurante.entidade.HorarioDeFuncionamento;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.HorarioDeFuncionamentoRepository;

@Service
public class HorarioDeFuncionamentoService {

	@Autowired
	private HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public HorarioDeFuncionamentoDto detalha(Long id) {
		Optional<HorarioDeFuncionamento> horarioDeFuncionamento = horarioDeFuncionamentoRepository.findById(id);
		if (!horarioDeFuncionamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarEmDto(horarioDeFuncionamento.get());
	}

	public List<HorarioDeFuncionamentoDto> lista(Long idRestaurante) {
		List<HorarioDeFuncionamento> horariosDoRestaurante = horarioDeFuncionamentoRepository
				.findAllByRestauranteId(idRestaurante);
		return horariosDoRestaurante.stream().map(h -> this.transformarEmDto(h)).collect(Collectors.toList());
	}

	public HorarioDeFuncionamentoDto adiciona(HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		HorarioDeFuncionamento horarioDeFuncionamento = horarioDeFuncionamentoRepository
				.save(this.transformarEmObjeto(horarioDeFuncionamentoDto));
		return this.transformarEmDto(horarioDeFuncionamento);
	}

	public HorarioDeFuncionamentoDto atualiza(HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		HorarioDeFuncionamento horarioDeFuncionamento = horarioDeFuncionamentoRepository
				.save(this.transformarEmObjeto(horarioDeFuncionamentoDto));
		return this.transformarEmDto(horarioDeFuncionamento);
	}

	public void remove(Long id) {
		horarioDeFuncionamentoRepository.deleteById(id);
	}

	private HorarioDeFuncionamentoDto transformarEmDto(HorarioDeFuncionamento horarioDeFuncionamento) {
		return modelMapper.map(horarioDeFuncionamento, HorarioDeFuncionamentoDto.class);
	}

	private HorarioDeFuncionamento transformarEmObjeto(HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return modelMapper.map(horarioDeFuncionamentoDto, HorarioDeFuncionamento.class);
	}
}
