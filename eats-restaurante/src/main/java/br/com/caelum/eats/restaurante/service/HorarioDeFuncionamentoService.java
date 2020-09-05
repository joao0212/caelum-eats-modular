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

	public HorarioDeFuncionamentoDto detalhar(Long id) {
		Optional<HorarioDeFuncionamento> horarioDeFuncionamento = horarioDeFuncionamentoRepository.findById(id);
		if (!horarioDeFuncionamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarEmDto(horarioDeFuncionamento.get());
	}

	public List<HorarioDeFuncionamentoDto> listar(Long idRestaurante) {
		List<HorarioDeFuncionamento> horariosDoRestaurante = horarioDeFuncionamentoRepository
				.findAllByRestauranteId(idRestaurante);
		return horariosDoRestaurante.stream().map(h -> this.transformarEmDto(h)).collect(Collectors.toList());
	}

	public HorarioDeFuncionamentoDto adicionar(HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		HorarioDeFuncionamento horarioDeFuncionamento = horarioDeFuncionamentoRepository
				.save(this.transformarEmObjeto(horarioDeFuncionamentoDto));
		return this.transformarEmDto(horarioDeFuncionamento);
	}

	public HorarioDeFuncionamentoDto atualizar(Long id, HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		HorarioDeFuncionamentoDto horarioDeFuncionamentoDtoSalvo = this.buscarPorId(id);

		horarioDeFuncionamentoDtoSalvo.setDiaDaSemana(horarioDeFuncionamentoDto.getDiaDaSemana());
		horarioDeFuncionamentoDtoSalvo.setHorarioDeAbertura(horarioDeFuncionamentoDto.getHorarioDeAbertura());
		horarioDeFuncionamentoDtoSalvo.setHorarioDeFechamento(horarioDeFuncionamentoDto.getHorarioDeFechamento());

		HorarioDeFuncionamento horarioDeFuncionamento = horarioDeFuncionamentoRepository
				.save(this.transformarEmObjeto(horarioDeFuncionamentoDtoSalvo));
		return this.transformarEmDto(horarioDeFuncionamento);
	}

	public HorarioDeFuncionamentoDto buscarPorId(Long id) {
		Optional<HorarioDeFuncionamento> horarioDeFuncionamento = horarioDeFuncionamentoRepository.findById(id);
		if (!horarioDeFuncionamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return transformarEmDto(horarioDeFuncionamento.get());
	}

	public void remover(Long id) {
		horarioDeFuncionamentoRepository.deleteById(id);
	}

	private HorarioDeFuncionamentoDto transformarEmDto(HorarioDeFuncionamento horarioDeFuncionamento) {
		return modelMapper.map(horarioDeFuncionamento, HorarioDeFuncionamentoDto.class);
	}

	private HorarioDeFuncionamento transformarEmObjeto(HorarioDeFuncionamentoDto horarioDeFuncionamentoDto) {
		return modelMapper.map(horarioDeFuncionamentoDto, HorarioDeFuncionamento.class);
	}
}
