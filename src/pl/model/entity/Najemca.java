package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the NAJEMCA database table.
 * 
 */
@Entity
@Table(name="NAJEMCA")
@NamedQuery(name="Najemca.findAll", query="SELECT n FROM Najemca n")
public class Najemca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private Integer id;

	@Column(nullable=false, length=20)
	private String nimie;

	@Column(length=15)
	private String nmiasto;

	@Column(nullable=false, length=25)
	private String nnazwisko;

	@Column(length=6)
	private String nnrlokalu;

	@Column(nullable=false, length=21)
	private String npesel;

	@Column(length=11)
	private String ntelefon;

	@Column(length=20)
	private String nulica;

	//bi-directional many-to-one association to Uzytkownik
	@OneToMany(mappedBy="najemca")
	private List<Uzytkownik> uzytkownik;

	//bi-directional many-to-one association to Wypozyczenie
	@OneToMany(mappedBy="najemca")
	private List<Wypozyczenie> wypozyczenie;

	public Najemca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNimie() {
		return this.nimie;
	}

	public void setNimie(String nimie) {
		this.nimie = nimie;
	}

	public String getNmiasto() {
		return this.nmiasto;
	}

	public void setNmiasto(String nmiasto) {
		this.nmiasto = nmiasto;
	}

	public String getNnazwisko() {
		return this.nnazwisko;
	}

	public void setNnazwisko(String nnazwisko) {
		this.nnazwisko = nnazwisko;
	}

	public String getNnrlokalu() {
		return this.nnrlokalu;
	}

	public void setNnrlokalu(String nnrlokalu) {
		this.nnrlokalu = nnrlokalu;
	}

	public String getNpesel() {
		return this.npesel;
	}

	public void setNpesel(String npesel) {
		this.npesel = npesel;
	}

	public String getNtelefon() {
		return this.ntelefon;
	}

	public void setNtelefon(String ntelefon) {
		this.ntelefon = ntelefon;
	}

	public String getNulica() {
		return this.nulica;
	}

	public void setNulica(String nulica) {
		this.nulica = nulica;
	}

	public List<Uzytkownik> getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(List<Uzytkownik> uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
		getUzytkownik().add(uzytkownik);
		uzytkownik.setNajemca(this);

		return uzytkownik;
	}

	public Uzytkownik removeUzytkownik(Uzytkownik uzytkownik) {
		getUzytkownik().remove(uzytkownik);
		uzytkownik.setNajemca(null);

		return uzytkownik;
	}

	public List<Wypozyczenie> getWypozyczenie() {
		return this.wypozyczenie;
	}

	public void setWypozyczenie(List<Wypozyczenie> wypozyczenie) {
		this.wypozyczenie = wypozyczenie;
	}

	public Wypozyczenie addWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenie().add(wypozyczeny);
		wypozyczeny.setNajemca(this);

		return wypozyczeny;
	}

	public Wypozyczenie removeWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenie().remove(wypozyczeny);
		wypozyczeny.setNajemca(null);

		return wypozyczeny;
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
	        if (!(object instanceof Najemca)) {
	            return false;
	        }
	        Najemca other = (Najemca) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "pl.model.entity.Najemca[ id=" + id + " ]";
	    }

}