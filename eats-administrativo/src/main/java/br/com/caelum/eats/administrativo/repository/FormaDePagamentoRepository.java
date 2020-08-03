package br.com.caelum.eats.administrativo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caelum.eats.administrativo.entidade.FormaDePagamento;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

	@Query("select fp from FormaDePagamento fp where fp.id in :ids")
	public List<FormaDePagamento> buscarPorIds(@Param("ids") List<Long> ids);

}
