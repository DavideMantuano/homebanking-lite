package it.homebanking.homebanking_lite.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import it.homebanking.homebanking_lite.model.Cliente;
import it.homebanking.homebanking_lite.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	// Costruttore
	public ClienteService(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;
	}

	public Optional<Cliente> trovaPerUsername(String username) {

		return clienteRepository.findByUsername(username);
	}

}
