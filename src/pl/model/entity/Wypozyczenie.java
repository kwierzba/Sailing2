package pl.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the WYPOZYCZENIE database table.
 * 
 */
@Entity
@Table(name="WYPOZYCZENIE")
@NamedQuery(name="Wypozyczenie.findAll", query="SELECT w FROM Wypozyczenie w")
public class Wypozyczenie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(nullable=false, length=10)
	private String wcena;

	@Temporal(TemporalType.DATE)
	private Date wdata;

	@Temporal(TemporalType.DATE)
	private Date wdatazwrot;

	//bi-directional many-to-one association to Jacht
	@ManyToOne
	@JoinColumn(name="JIDFK", nullable=false)
	private Jacht jacht;

	//bi-directional many-to-one association to Najemca
	@ManyToOne
	@JoinColumn(name="NIDFK", nullable=false)
	private Najemca najemca;

	//bi-directional many-to-one association to Rejs
	@ManyToOne
	@JoinColumn(name="RIDFK", nullable=false)
	private Rejs rejs;

	public Wypozyczenie() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWcena() {
		return this.wcena;
	}

	public void setWcena(String wcena) {
		this.wcena = wcena;
	}

	public Date getWdata() {
		return this.wdata;
	}

	public void setWdata(Date wdata) {
		this.wdata = wdata;
	}

	public Date getWdatazwrot() {
		return this.wdatazwrot;
	}

	public void setWdatazwrot(Date wdatazwrot) {
		this.wdatazwrot = wdatazwrot;
	}

	public Jacht getJacht() {
		return this.jacht;
	}

	public void setJacht(Jacht jacht) {
		this.jacht = jacht;
	}

	public Najemca getNajemca() {
		return this.najemca;
	}

	public void setNajemca(Najemca najemca) {
		this.najemca = najemca;
	}

	public Rejs getRej() {
		return this.rejs;
	}

	public void setRej(Rejs rejs) {
		this.rejs = rejs;
	}

}