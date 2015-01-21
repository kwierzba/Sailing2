package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;



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
	private Integer id;

	@JoinColumn(name="RIDFK", nullable=false, referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Rejs rejs;

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
	@JoinColumn(name="NIDFK", nullable=false, referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Najemca najemca;

	public Uzytkownik() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rejs getRejs() {
		return this.rejs;
	}

	public void setRejs(Rejs rejs) {
		this.rejs = rejs;
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
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.model.entity.Uzytkownik[ id=" + id + " ]";
    }

}