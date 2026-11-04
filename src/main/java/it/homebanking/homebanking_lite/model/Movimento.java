package it.homebanking.homebanking_lite.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOVIMENTI")
public class Movimento {

	// CAMPI

	@Id
	@Column(name = "id_movimento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoMovimento tipo;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Column(name = "ora", nullable = false)
	private LocalTime ora;

	@Column(name = "causale", nullable = false)
	private String causale;

	@Column(name = "contro_parte", nullable = false)
	private String controParte;

	@Column(name = "importo", nullable = false)
	private BigDecimal importo;

	@ManyToOne
	@JoinColumn(name = "id_conto", nullable = false)
	private Conto conto;


	// Costruttore senza argomenti
	public Movimento() {

	}

	// Costruttore con parametri
	public Movimento(TipoMovimento tipo, LocalDate data, LocalTime ora, String causale, String controParte,
			BigDecimal importo, Conto conto) {
		this.tipo = tipo;
		this.data = data;
		this.ora = ora;
		this.causale = causale;
		this.controParte = controParte;
		this.importo = importo;
		this.conto = conto;
	}

	// GETTER

	public Long getIdMovimento() {
		return idMovimento;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getOra() {
		return ora;
	}

	public String getCausale() {
		return causale;
	}

	public String getControParte() {
		return controParte;
	}

	public BigDecimal getImporto() {
		return importo;
	}

	public Conto getConto() {
		return conto;
	}

	// SETTER

	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public void setControParte(String controParte) {
		this.controParte = controParte;
	}

	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	public void setConto(Conto conto) {
		this.conto = conto;
	}

}
