package br.com.caelum.eats.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caelum.eats.pedido.entidade.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	@Query("select avg(a.nota) from Avaliacao a where a.pedido.restauranteId =:restauranteId")
	Double buscarMediaDoRestaurantePeloId(@Param("restauranteId") Long restauranteId);

	@Query("select a from Avaliacao a where a.pedido.restauranteId =: restauranteId")
	List<Avaliacao> findAllByRestaurante(@Param("restauranteId") Long restauranteId);
}
