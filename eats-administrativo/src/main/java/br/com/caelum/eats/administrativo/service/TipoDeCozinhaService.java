package br.com.caelum.eats.administrativo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.administrativo.dto.TipoDeCozinhaDto;
import br.com.caelum.eats.administrativo.entidade.TipoDeCozinha;
import br.com.caelum.eats.administrativo.repository.TipoDeCozinhaRepository;

@Service
public class TipoDeCozinhaService {

	@Autowired
	private TipoDeCozinhaRepository tipoDeCozinhaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<TipoDeCozinhaDto> listar() {
		return tipoDeCozinhaRepository.findAll().stream().map(tipoDeCozinha -> this.transformarParaDto(tipoDeCozinha))
				.collect(Collectors.toList());
	}

	public TipoDeCozinhaDto adicionar(TipoDeCozinhaDto tipoDeCozinhaDto) {
		TipoDeCozinha tipoDeCozinha = tipoDeCozinhaRepository.save(this.transformarParaObjeto(tipoDeCozinhaDto));
		return this.transformarParaDto(tipoDeCozinha);
	}

	public TipoDeCozinhaDto atualizar(TipoDeCozinhaDto tipoDeCozinhaDto) {
		TipoDeCozinha tipoDeCozinha = tipoDeCozinhaRepository.save(this.transformarParaObjeto(tipoDeCozinhaDto));
		return this.transformarParaDto(tipoDeCozinha);
	}

	public TipoDeCozinhaDto buscarPorId(Long id) {
		Optional<TipoDeCozinha> tipoDeCozinha = tipoDeCozinhaRepository.findById(id);
		if (!tipoDeCozinha.isPresent()) {
			throw new RuntimeException("Não existe o tipo informado.");
		}
		return transformarParaDto(tipoDeCozinha.get());
	}

	public void remover(Long id) {
		tipoDeCozinhaRepository.deleteById(id);
	}

	private TipoDeCozinha transformarParaObjeto(TipoDeCozinhaDto tipoDeCozinhaDto) {
		return modelMapper.map(tipoDeCozinhaDto, TipoDeCozinha.class);
	}

	private TipoDeCozinhaDto transformarParaDto(TipoDeCozinha tipoDeCozinha) {
		return modelMapper.map(tipoDeCozinha, TipoDeCozinhaDto.class);
	}
}
