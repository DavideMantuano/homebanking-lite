package it.homebanking.homebanking_lite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.homebanking.homebanking_lite.model.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

	/**
	 * Recupera tutti i movimenti associati ai conti di un cliente, ordinandoli dal
	 * più recente al meno recente.
	 *
	 * @param idCliente identificativo del cliente
	 * @return lista dei movimenti del cliente
	 */

	List<Movimento> findByContoClienteIdClienteOrderByDataDescOraDesc(Long idCliente);

	/**
	 * Recupera i movimenti di uno specifico conto appartenente a un cliente,
	 * ordinandoli dal più recente al meno recente.
	 *
	 * @param idCliente identificativo del cliente
	 * @param idConto   identificativo del conto
	 * @return lista dei movimenti del conto
	 */
	List<Movimento> findByContoClienteIdClienteAndContoIdContoOrderByDataDescOraDesc(Long idCliente, Long idConto);

}
