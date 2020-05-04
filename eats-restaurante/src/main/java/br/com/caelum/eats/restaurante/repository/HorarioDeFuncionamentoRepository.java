package br.com.caelum.eats.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.restaurante.entidade.HorarioDeFuncionamento;
import br.com.caelum.eats.restaurante.entidade.Restaurante;

public interface HorarioDeFuncionamentoRepository extends JpaRepository<HorarioDeFuncionamento, Long> {

	List<HorarioDeFuncionamento> findAllByRestaurante(Restaurante restaurante);

}
