package br.com.caelum.eats.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.pedido.entidade.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
