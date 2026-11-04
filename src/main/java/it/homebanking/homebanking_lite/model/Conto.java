package it.homebanking.homebanking_lite.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTI")
public class Conto {

	// Campi

	@Id
	@Column(name = "id_conto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConto;

	@Column(name = "iban", nullable = false, unique = true)
	private String iban;

	@Column(name = "saldo", nullable = false)
	private BigDecimal saldo = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;


	// Costruttore senza argomenti
	public Conto() {

	}


	// Costruttore con parametri
	public Conto(String iban, BigDecimal saldo, Cliente cliente) {

		this.iban = iban;
		this.saldo = saldo;
		this.cliente = cliente;
	}


	// GETTER

	public Long getIdConto() {
		return idConto;
	}

	public String getIban() {
		return iban;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}


	// SETTER

	public void setIdConto(Long idConto) {
		this.idConto = idConto;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
