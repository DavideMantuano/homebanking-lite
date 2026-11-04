package it.homebanking.homebanking_lite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.homebanking.homebanking_lite.model.Conto;
import it.homebanking.homebanking_lite.repository.ContoRepository;

@Service
public class ContoService {

	private final ContoRepository contoRepository;

	// Costruttore
	public ContoService(ContoRepository contoRepository) {
		this.contoRepository = contoRepository;
	}

	public List<Conto> trovaPerIdCliente(Long idCliente) {
		return contoRepository.findByClienteIdCliente(idCliente);
	}
}