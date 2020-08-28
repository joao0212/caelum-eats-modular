package br.com.caelum.eats.pedido.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caelum.eats.pedido.entidade.Pedido;
import br.com.caelum.eats.pedido.enums.Status;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Pedido p set p.status = :status where p.id = :id")
	void atualizarStatus(@Param("status") Status status, @Param("id") Long id);

	@Query("select p from Pedido p where p.restauranteId = :restauranteId and p.status not in :listaDeStatus")
	List<Pedido> doRestauranteSemOsStatus(@Param("restauranteId") Long restauranteId,
			@Param("listaDeStatus") List<Status> listaDeStatus);

	@Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itensDoPedido where p.id = :id")
	Pedido porIdComItens(Long id);
}
