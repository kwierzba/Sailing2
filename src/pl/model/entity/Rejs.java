package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the REJS database table.
 * 
 */
@Entity
@Table(name="REJS")
@NamedQuery(name="Rejs.findAll", query="SELECT r FROM Rejs r")
public class Rejs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date rdatakoniec;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date rdatapocz;

	@Column(nullable=false, length=30)
	private String rportkoncowy;

	@Column(nullable=false, length=30)
	private String rportpocz;

	//bi-directional many-to-one association to Jacht
	@JoinColumn(name="JIDFK", nullable=false, referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Jacht jacht;

	//bi-directional many-to-one association to Wypozyczenie
	@OneToMany(mappedBy="rejs")
	private List<Wypozyczenie> wypozyczenies;

	public Rejs() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRdatakoniec() {
		return this.rdatakoniec;
	}

	public void setRdatakoniec(Date rdatakoniec) {
		this.rdatakoniec = rdatakoniec;
	}

	public Date getRdatapocz() {
		return this.rdatapocz;
	}

	public void setRdatapocz(Date rdatapocz) {
		this.rdatapocz = rdatapocz;
	}

	public String getRportkoncowy() {
		return this.rportkoncowy;
	}

	public void setRportkoncowy(String rportkoncowy) {
		this.rportkoncowy = rportkoncowy;
	}

	public String getRportpocz() {
		return this.rportpocz;
	}

	public void setRportpocz(String rportpocz) {
		this.rportpocz = rportpocz;
	}

	public Jacht getJacht() {
		return this.jacht;
	}

	public void setJacht(Jacht jacht) {
		this.jacht = jacht;
	}

	public List<Wypozyczenie> getWypozyczenies() {
		return this.wypozyczenies;
	}

	public void setWypozyczenies(List<Wypozyczenie> wypozyczenies) {
		this.wypozyczenies = wypozyczenies;
	}

	public Wypozyczenie addWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().add(wypozyczeny);
		wypozyczeny.setRej(this);

		return wypozyczeny;
	}

	public Wypozyczenie removeWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().remove(wypozyczeny);
		wypozyczeny.setRej(null);

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
        if (!(object instanceof Rejs)) {
            return false;
        }
        Rejs other = (Rejs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.model.entity.Rejs[ id=" + id + " ]";
    }

}