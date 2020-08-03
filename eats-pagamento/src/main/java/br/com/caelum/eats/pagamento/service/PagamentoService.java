package br.com.caelum.eats.pagamento.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.eats.administrativo.dto.FormaDePagamentoDto;
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

	public PagamentoDto detalha(Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		FormaDePagamentoDto formaDePagamentoDto = formaDePagamentoService
				.buscarPorId(pagamento.getFormaDePagamentoId());
		PedidoDto pedidoDto = pedidoService.buscarPorId(pagamento.getPedidoId());
		return new PagamentoDto(pagamento, formaDePagamentoDto, pedidoDto);
	}

	public ResponseEntity<PagamentoDto> cria(Pagamento pagamento, UriComponentsBuilder uriBuilder) {
		pagamento.setStatus(Status.CRIADO);
		Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
		FormaDePagamentoDto formaDePagamentoDto = formaDePagamentoService
				.buscarPorId(pagamentoSalvo.getFormaDePagamentoId());
		PedidoDto pedidoDto = pedidoService.buscarPorId(pagamentoSalvo.getPedidoId());
		URI path = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamentoSalvo.getId()).toUri();
		return ResponseEntity.created(path).body(new PagamentoDto(pagamentoSalvo, formaDePagamentoDto, pedidoDto));
	}

	// TODO Entender esse método e refatorar. Muita responsabilidade.
	public PagamentoDto confirma(Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		pagamento.setStatus(Status.CONFIRMADO);
		FormaDePagamentoDto formaDePagamentoDto = formaDePagamentoService
				.buscarPorId(pagamento.getFormaDePagamentoId());
		PedidoDto pedidoDto = pedidoService.buscarPorId(pagamento.getPedidoId());
		pagamentoRepository.save(pagamento);
		Long pedidoId = pagamento.getPedidoId();
		PedidoDto pedidoDtoPorIdComItens = pedidoService.buscarPorIdComItens(pedidoId);
		pedidoService.atualizaStatus(pedidoDtoPorIdComItens);
		return new PagamentoDto(pagamento, formaDePagamentoDto, pedidoDto);
	}

	public PagamentoDto cancela(Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		pagamento.setStatus(Status.CANCELADO);
		FormaDePagamentoDto formaDePagamentoDto = formaDePagamentoService
				.buscarPorId(pagamento.getFormaDePagamentoId());
		PedidoDto pedidoDto = pedidoService.buscarPorId(pagamento.getPedidoId());
		pagamentoRepository.save(pagamento);
		return new PagamentoDto(pagamento, formaDePagamentoDto, pedidoDto);
	}
}
