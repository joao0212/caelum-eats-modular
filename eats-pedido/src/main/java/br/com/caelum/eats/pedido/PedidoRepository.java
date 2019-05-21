package br.com.caelum.eats.pedido;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Pedido p set p.status = :status where p = :pedido")
	void atualizaStatus(Pedido.Status status, Pedido pedido);

	@Query("select p from Pedido p where p.restaurante.id = :restauranteId and p.status not in :listaDeStatus")
	List<Pedido> doRestauranteSemOsStatus(Long restauranteId, List<Pedido.Status> listaDeStatus);

	@Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id") 
	Pedido porIdComItens(Long id);

}
