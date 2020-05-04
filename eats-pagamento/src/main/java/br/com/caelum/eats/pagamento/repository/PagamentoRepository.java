package br.com.caelum.eats.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.pagamento.entidade.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
