package it.homebanking.homebanking_lite.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTI")
public class Cliente {

	// Campi

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cognome", nullable = false)
	private String cognome;

	@Column(name = "codice_fiscale", nullable = false, unique = true)
	private String codiceFiscale;

	@Column(name = "data_nascita", nullable = false)
	private LocalDate dataNascita;

	@Column(name = "citta", nullable = false)
	private String citta;

	@Column(name = "provincia", nullable = false)
	private String provincia;

	@Column(name = "via", nullable = false)
	private String via;

	@OneToMany(mappedBy = "cliente")
	private List<Conto> conti = new ArrayList<>();



	// Construttore senza argomenti
	public Cliente() {

	}

	// Construttore con parametri
	public Cliente(String username, String nome, String cognome, String codiceFiscale, LocalDate dataNascita,
			String citta, String provincia, String via) {

		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.citta = citta;
		this.provincia = provincia;
		this.via = via;
	}


	// Getter

	public Long getIdCliente() {

		return idCliente;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getNome() {

		return nome;
	}

	public String getCognome() {

		return cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public String getCitta() {
		return citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getVia() {
		return via;
	}

	public List<Conto> getConti() {
		return conti;
	}

	// Setter

	public void setConti(List<Conto> conti) {
		this.conti = conti;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
