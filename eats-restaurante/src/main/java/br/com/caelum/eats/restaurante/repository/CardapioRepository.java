package br.com.caelum.eats.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.caelum.eats.restaurante.entidade.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

	@Query("select c from Cardapio c where c.restaurante.id = :id")
	public Cardapio buscarPorIdRestaurante(Long id);

}
