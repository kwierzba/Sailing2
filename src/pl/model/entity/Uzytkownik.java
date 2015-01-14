package pl.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the UZYTKOWNIK database table.
 * 
 */
@Entity
@Table(name="UZYTKOWNIK")
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(precision=22)
	private BigDecimal ridfk;

	@Column(nullable=false, length=15)
	private String uimie;

	@Column(nullable=false, length=15)
	private String umiasto;

	@Column(nullable=false, length=25)
	private String unazwisko;

	@Column(nullable=false, length=6)
	private String unrlokalu;

	@Column(nullable=false, length=25)
	private String upatent;

	@Column(nullable=false, length=21)
	private String upesel;

	@Column(nullable=false, length=20)
	private String utelefon;

	@Column(nullable=false, length=30)
	private String uulica;

	//bi-directional many-to-one association to Najemca
	@ManyToOne
	@JoinColumn(name="NIDFK")
	private Najemca najemca;

	public Uzytkownik() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getRidfk() {
		return this.ridfk;
	}

	public void setRidfk(BigDecimal ridfk) {
		this.ridfk = ridfk;
	}

	public String getUimie() {
		return this.uimie;
	}

	public void setUimie(String uimie) {
		this.uimie = uimie;
	}

	public String getUmiasto() {
		return this.umiasto;
	}

	public void setUmiasto(String umiasto) {
		this.umiasto = umiasto;
	}

	public String getUnazwisko() {
		return this.unazwisko;
	}

	public void setUnazwisko(String unazwisko) {
		this.unazwisko = unazwisko;
	}

	public String getUnrlokalu() {
		return this.unrlokalu;
	}

	public void setUnrlokalu(String unrlokalu) {
		this.unrlokalu = unrlokalu;
	}

	public String getUpatent() {
		return this.upatent;
	}

	public void setUpatent(String upatent) {
		this.upatent = upatent;
	}

	public String getUpesel() {
		return this.upesel;
	}

	public void setUpesel(String upesel) {
		this.upesel = upesel;
	}

	public String getUtelefon() {
		return this.utelefon;
	}

	public void setUtelefon(String utelefon) {
		this.utelefon = utelefon;
	}

	public String getUulica() {
		return this.uulica;
	}

	public void setUulica(String uulica) {
		this.uulica = uulica;
	}

	public Najemca getNajemca() {
		return this.najemca;
	}

	public void setNajemca(Najemca najemca) {
		this.najemca = najemca;
	}

}