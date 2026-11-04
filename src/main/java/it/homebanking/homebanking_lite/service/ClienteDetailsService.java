package it.homebanking.homebanking_lite.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.homebanking.homebanking_lite.model.Cliente;

@Service
public class ClienteDetailsService implements UserDetailsService {

    private final ClienteService clienteService;

    public ClienteDetailsService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Cliente cliente = clienteService.trovaPerUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Cliente non trovato"));

		return User.withUsername(cliente.getUsername()).password(cliente.getPasswordHash()).roles("CLIENTE").build();
    }
}