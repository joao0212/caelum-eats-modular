package br.com.caelum.eats.administrativo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.administrativo.entidade.TipoDeCozinha;

public interface TipoDeCozinhaRepository extends JpaRepository<TipoDeCozinha, Long> {

	List<TipoDeCozinha> findAllByOrderByNomeAsc();

}
