package pl.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JACHT database table.
 * 
 */
@Entity
@Table(name="JACHT")
@NamedQuery(name="Jacht.findAll", query="SELECT j FROM Jacht j")
public class Jacht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private Integer id;

	@Column(nullable=false, precision=22)
	private BigDecimal jiloscosob;

	@Column(nullable=false, precision=22)
	private BigDecimal jmaxkg;

	@Column(nullable=false, length=20)
	private String jnazwa;

	@Column(nullable=false, length=20)
	private String jtyp;

	//bi-directional many-to-one association to Rejs
	@OneToMany(mappedBy="jacht")
	private List<Rejs> rejs;

	//bi-directional many-to-one association to Wypozyczenie
	@OneToMany(mappedBy="jacht")
	private List<Wypozyczenie> wypozyczenies;

	public Jacht() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getJiloscosob() {
		return this.jiloscosob;
	}

	public void setJiloscosob(BigDecimal jiloscosob) {
		this.jiloscosob = jiloscosob;
	}

	public BigDecimal getJmaxkg() {
		return this.jmaxkg;
	}

	public void setJmaxkg(BigDecimal jmaxkg) {
		this.jmaxkg = jmaxkg;
	}

	public String getJnazwa() {
		return this.jnazwa;
	}

	public void setJnazwa(String jnazwa) {
		this.jnazwa = jnazwa;
	}

	public String getJtyp() {
		return this.jtyp;
	}

	public void setJtyp(String jtyp) {
		this.jtyp = jtyp;
	}

	public List<Rejs> getRejs() {
		return this.rejs;
	}

	public void setRejs(List<Rejs> rejs) {
		this.rejs = rejs;
	}

	public Rejs addRej(Rejs rej) {
		getRejs().add(rej);
		rej.setJacht(this);

		return rej;
	}

	public Rejs removeRej(Rejs rej) {
		getRejs().remove(rej);
		rej.setJacht(null);

		return rej;
	}

	public List<Wypozyczenie> getWypozyczenies() {
		return this.wypozyczenies;
	}

	public void setWypozyczenies(List<Wypozyczenie> wypozyczenies) {
		this.wypozyczenies = wypozyczenies;
	}

	public Wypozyczenie addWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().add(wypozyczeny);
		wypozyczeny.setJacht(this);

		return wypozyczeny;
	}

	public Wypozyczenie removeWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().remove(wypozyczeny);
		wypozyczeny.setJacht(null);

		return wypozyczeny;
	}

}