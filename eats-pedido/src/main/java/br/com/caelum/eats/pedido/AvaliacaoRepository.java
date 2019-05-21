package br.com.caelum.eats.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.caelum.eats.restaurante.Restaurante;

interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Long> {

	@Query("select avg(a.nota) from Avaliacao a where a.pedido.restaurante.id =:restauranteId")
	public Double mediaDoRestaurantePeloId(Long restauranteId);

	@Query("select a from Avaliacao a where a.pedido.restaurante = :restaurante")
	public List<Avaliacao> findAllByRestaurante(Restaurante restaurante);

}
