package br.com.caelum.eats.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

	List<FormaDePagamento> findAllByOrderByNomeAsc();

}
