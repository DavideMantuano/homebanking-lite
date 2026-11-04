package it.homebanking.homebanking_lite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.homebanking.homebanking_lite.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByUsername(String username);

}
