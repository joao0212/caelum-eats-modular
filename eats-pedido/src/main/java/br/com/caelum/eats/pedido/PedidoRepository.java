package br.com.caelum.eats.pedido;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Pedido p set p.status = :status where p = :pedido")
	void atualizaStatus(@Param("status") Pedido.Status status, @Param("pedido") Pedido pedido);

	@Query("select p from Pedido p where p.restaurante.id = :restauranteId and p.status not in :listaDeStatus")
	List<Pedido> doRestauranteSemOsStatus(@Param("restauranteId") Long restauranteId,@Param("listaDeStatus") List<Pedido.Status> listaDeStatus);

	@Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id") 
	Pedido porIdComItens(@Param("id") Long id);

}
