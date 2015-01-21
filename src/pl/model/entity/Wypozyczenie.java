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
	private Integer id;

	@Column(nullable=false, length=10)
	private String wcena;

	@Temporal(TemporalType.DATE)
	private Date wdata;

	@Temporal(TemporalType.DATE)
	private Date wdatazwrot;

	//bi-directional many-to-one association to Najemca
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="NIDFK", nullable=false, referencedColumnName = "id")
	private Najemca najemca;

	//bi-directional many-to-one association to Rejs
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RIDFK", nullable=false, referencedColumnName = "id")
	private Rejs rejs;

	public Wypozyczenie() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Najemca getNajemca() {
		return this.najemca;
	}

	public void setNajemca(Najemca najemca) {
		this.najemca = najemca;
	}

	public Rejs getRejs() {
		return this.rejs;
	}

	public void setRejs(Rejs rejs) {
		this.rejs = rejs;
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
        if (!(object instanceof Wypozyczenie)) {
            return false;
        }
        Wypozyczenie other = (Wypozyczenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.model.entity.Wypozyczenie[ id=" + id + " ]";
    }
	
}