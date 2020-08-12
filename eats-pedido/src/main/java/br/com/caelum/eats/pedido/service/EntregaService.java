package br.com.caelum.eats.pedido.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pedido.dto.ClienteDto;
import br.com.caelum.eats.pedido.dto.EntregaDto;
import br.com.caelum.eats.pedido.entidade.Entrega;
import br.com.caelum.eats.pedido.exception.ResourceNotFoundException;
import br.com.caelum.eats.pedido.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public EntregaDto buscarPorId(Long id) {
		Optional<Entrega> entrega = entregaRepository.findById(id);
		if (!entrega.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(entrega.get());
	}

	private EntregaDto transformarParaDto(Entrega entrega) {
		EntregaDto entregaDto = modelMapper.map(entrega, EntregaDto.class);
		entregaDto.setClienteDto(new ClienteDto(entrega.getCliente().getNome(), entrega.getCliente().getCpf(),
				entrega.getCliente().getEmail(), entrega.getCliente().getTelefone()));
		return entregaDto;
	}
}
