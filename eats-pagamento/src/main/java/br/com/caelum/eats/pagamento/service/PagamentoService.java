package br.com.caelum.eats.pagamento.service;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.eats.administrativo.service.FormaDePagamentoService;
import br.com.caelum.eats.pagamento.dto.PagamentoDto;
import br.com.caelum.eats.pagamento.entidade.Pagamento;
import br.com.caelum.eats.pagamento.enums.Status;
import br.com.caelum.eats.pagamento.exception.ResourceNotFoundException;
import br.com.caelum.eats.pagamento.repository.PagamentoRepository;
import br.com.caelum.eats.pedido.dto.PedidoDto;
import br.com.caelum.eats.pedido.service.PedidoService;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private FormaDePagamentoService formaDePagamentoService;

	@Autowired
	private ModelMapper modelMapper;

	public PagamentoDto detalhar(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		if (!pagamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return transformarParaDto(pagamento.get());
	}

	public ResponseEntity<PagamentoDto> criar(PagamentoDto pagamentoDto, UriComponentsBuilder uriBuilder) {
		Pagamento pagamento = this.transformarParaObjeto(pagamentoDto);
		pagamento.setStatus(Status.CRIADO);
		Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
		URI path = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamentoSalvo.getId()).toUri();
		return ResponseEntity.created(path).body(this.transformarParaDto(pagamentoSalvo));
	}

	// TODO Entender esse método e refatorar. Muita responsabilidade.
	public PagamentoDto confirmar(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		if (!pagamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		pagamento.get().setStatus(Status.CONFIRMADO);
		pagamentoRepository.save(pagamento.get());
		Long pedidoId = pagamento.get().getPedidoId();
		PedidoDto pedidoDtoPorIdComItens = pedidoService.buscarPorIdComItens(pedidoId);
		pedidoService.atualizarStatus(pedidoDtoPorIdComItens);
		return this.transformarParaDto(pagamento.get());
	}

	public PagamentoDto cancelar(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		if (!pagamento.isPresent()) {
			throw new ResourceNotFoundException();
		}
		pagamento.get().setStatus(Status.CANCELADO);
		pagamentoRepository.save(pagamento.get());
		return this.transformarParaDto(pagamento.get());
	}

	private Pagamento transformarParaObjeto(PagamentoDto pagamentoDto) {
		return modelMapper.map(pagamentoDto, Pagamento.class);
	}

	private PagamentoDto transformarParaDto(Pagamento pagamento) {
		PagamentoDto pagamentoDto = modelMapper.map(pagamento, PagamentoDto.class);
		pagamentoDto.setPedidoDto(pedidoService.buscarPorId(pagamento.getPedidoId()));
		pagamentoDto.setFormaDePagamentoDto(formaDePagamentoService.buscarPorId(pagamento.getFormaDePagamentoId()));
		return pagamentoDto;
	}
}
