package br.com.caelum.eats.seguranca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.seguranca.entidade.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

}
