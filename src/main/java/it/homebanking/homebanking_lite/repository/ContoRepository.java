package it.homebanking.homebanking_lite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.homebanking.homebanking_lite.model.Conto;

public interface ContoRepository extends JpaRepository<Conto, Long> {

	List<Conto> findByClienteIdCliente(Long idCliente);

}

