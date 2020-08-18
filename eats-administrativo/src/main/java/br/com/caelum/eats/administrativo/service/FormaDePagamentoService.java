package br.com.caelum.eats.administrativo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;
import br.com.caelum.eats.administrativo.repository.FormaDePagamentoRepository;

@Service
public class FormaDePagamentoService {

	@Autowired
	private FormaDePagamentoRepository formaDePagamentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<FormaDePagamentoDto> listar() {
		return formaDePagamentoRepository.findAll().stream()
				.map(formaDePagamento -> this.transformarParaDto(formaDePagamento)).collect(Collectors.toList());
	}

	public FormaDePagamentoDto adicionar(FormaDePagamentoDto formaDePagamentoDto) {
		FormaDePagamento formaDePagamento = formaDePagamentoRepository
				.save(this.transformarParaObjeto(formaDePagamentoDto));
		return this.transformarParaDto(formaDePagamento);
	}

	public FormaDePagamentoDto atualizar(Long id, FormaDePagamentoDto formaDePagamentoDto) {
		FormaDePagamentoDto formaDePagamentoDtoSalvo = buscarPorId(id);

		formaDePagamentoDtoSalvo.setNome(formaDePagamentoDto.getNome());
		formaDePagamentoDtoSalvo.setTipo(formaDePagamentoDto.getTipo());

		FormaDePagamento formaDePagamento = formaDePagamentoRepository
				.save(this.transformarParaObjeto(formaDePagamentoDtoSalvo));

		return this.transformarParaDto(formaDePagamento);
	}

	public FormaDePagamentoDto buscarPorId(Long id) {
		Optional<FormaDePagamento> formaDePagamento = formaDePagamentoRepository.findById(id);
		if (!formaDePagamento.isPresent()) {
			throw new RuntimeException("Não existe o tipo informado.");
		}
		return transformarParaDto(formaDePagamento.get());
	}

	public List<FormaDePagamentoDto> buscarPorIds(List<Long> ids) {
		return formaDePagamentoRepository.buscarPorIds(ids).stream()
				.map(formaDePagamento -> this.transformarParaDto(formaDePagamento)).collect(Collectors.toList());
	}

	public void remover(Long id) {
		formaDePagamentoRepository.deleteById(id);
	}

	private FormaDePagamento transformarParaObjeto(FormaDePagamentoDto formaDePagamentoDto) {
		return modelMapper.map(formaDePagamentoDto, FormaDePagamento.class);
	}

	private FormaDePagamentoDto transformarParaDto(FormaDePagamento formaDePagamento) {
		return modelMapper.map(formaDePagamento, FormaDePagamentoDto.class);
	}
}
