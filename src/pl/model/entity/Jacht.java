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
	@OneToMany(mappedBy="jacht", fetch = FetchType.EAGER)
	private List<Rejs> rejs;
	

	public Jacht() {
	}

	public Integer getId() {
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

	public Rejs addRejs(Rejs rejs) {
		getRejs().add(rejs);
		rejs.setJacht(this);

		return rejs;
	}

	public Rejs removeRejs(Rejs rejs) {
		getRejs().remove(rejs);
		rejs.setJacht(null);

		return rejs;
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
	        if (!(object instanceof Jacht)) {
	            return false;
	        }
	        Jacht other = (Jacht) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "pl.model.entity.Jacht[ id=" + id + " ]";
	    }
}