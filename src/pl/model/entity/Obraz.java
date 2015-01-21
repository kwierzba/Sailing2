package pl.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.net.URL;


/**
 * The persistent class for the OBRAZ database table.
 * 
 */
@Entity
@Table(name="OBRAZ")
@NamedQuery(name="Obraz.findAll", query="SELECT o FROM Obraz o")
public class Obraz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	private URL plik;

	//bi-directional many-to-one association to Jacht
	@ManyToOne
	@JoinColumn(name="JIDFK")
	private Jacht jacht;

	public Obraz() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public URL getPlik() {
		return this.plik;
	}

	public void setPlik(URL plik) {
		this.plik = plik;
	}

	public Jacht getJacht() {
		return this.jacht;
	}

	public void setJacht(Jacht jacht) {
		this.jacht = jacht;
	}

}