package br.com.caelum.eats.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caelum.eats.restaurante.entidade.RestauranteFormaDePagamento;

public interface RestauranteFormaDePagamentoRepository
		extends JpaRepository<RestauranteFormaDePagamento, RestauranteFormaDePagamento.RestauranteFormaDePagamentoId> {

	@Query("select rf from RestauranteFormaDePagamento rf where rf.restaurante.id = :idRestaurante")
	List<RestauranteFormaDePagamento> findAllByRestauranteOrderByNomeAsc(@Param("idRestaurante") Long idRestaurante);

}
