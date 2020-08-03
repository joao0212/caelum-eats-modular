package br.com.caelum.eats.pedido.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pedido.dto.PedidoDto;
import br.com.caelum.eats.pedido.entidade.Pedido;
import br.com.caelum.eats.pedido.enums.Status;
import br.com.caelum.eats.pedido.exception.ResourceNotFoundException;
import br.com.caelum.eats.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<PedidoDto> lista() {
		return pedidoRepository.findAll().stream().map(pedido -> this.transformarParaDto(pedido))
				.collect(Collectors.toList());
	}

	public PedidoDto buscarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return this.transformarParaDto(pedido.get());
	}

	public PedidoDto adiciona(PedidoDto pedidoDto) {
		Pedido pedido = this.transformarParaObjeto(pedidoDto);
		pedido.setDataHora(LocalDateTime.now());
		pedido.setStatus(Status.REALIZADO);
		pedido.getItens().forEach(item -> item.setPedido(pedido));
		pedido.getEntrega().setPedido(pedido);
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		return this.transformarParaDto(pedidoSalvo);
	}

	public void atualizaStatus(PedidoDto pedidoDto) {
		pedidoRepository.atualizaStatus(pedidoDto.getStatus(), pedidoDto.getId());
	}

	public List<PedidoDto> pendentes(Long restauranteId) {
		return pedidoRepository
				.doRestauranteSemOsStatus(restauranteId, Arrays.asList(Status.REALIZADO, Status.ENTREGUE)).stream()
				.map(pedido -> this.transformarParaDto(pedido)).collect(Collectors.toList());
	}

	public PedidoDto buscarPorIdComItens(Long pedidoId) {
		return this.transformarParaDto(this.pedidoRepository.porIdComItens(pedidoId));
	}

	private Pedido transformarParaObjeto(PedidoDto pedidoDto) {
		return modelMapper.map(pedidoDto, Pedido.class);
	}

	private PedidoDto transformarParaDto(Pedido pedido) {
		return modelMapper.map(pedido, PedidoDto.class);
	}
}
