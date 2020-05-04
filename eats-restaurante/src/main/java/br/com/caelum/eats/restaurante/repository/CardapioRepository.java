package br.com.caelum.eats.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.Restaurante;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

	Cardapio findByRestaurante(Restaurante restaurante);
}
