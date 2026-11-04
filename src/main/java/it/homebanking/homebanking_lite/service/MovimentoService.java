package it.homebanking.homebanking_lite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.homebanking.homebanking_lite.model.Movimento;
import it.homebanking.homebanking_lite.repository.MovimentoRepository;

@Service
public class MovimentoService {

	private final MovimentoRepository movimentoRepository;

	// Costruttore
	public MovimentoService(MovimentoRepository movimentoRepository) {
		this.movimentoRepository = movimentoRepository;
	}

	public List<Movimento> trovaPerIdCliente(Long idCliente) {

		return movimentoRepository.findByContoClienteIdClienteOrderByDataDescOraDesc(idCliente);
	}

	public List<Movimento> trovaPerIdConto(Long idCliente, Long idConto) {

		return movimentoRepository.findByContoClienteIdClienteAndContoIdContoOrderByDataDescOraDesc(idCliente, idConto);
	}

}
