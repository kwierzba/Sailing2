package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Wypozyczenie;

public class WypozyczenieBean {
	private Wypozyczenie wypozyczenie = new Wypozyczenie();

	public Wypozyczenie getWypozyczenie() {
		return wypozyczenie;
	}

	public void setWypozyczenie(Wypozyczenie wypozyczenie) {
		this.wypozyczenie = wypozyczenie;
	}

	//

	public List<Wypozyczenie> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Wypozyczenie.findAll").getResultList();
		em.close();
		return list;
	}

	public void wypozyczenieListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("wypozyczenieID").toString();
		int jId = Integer.parseInt(ids);
		this.wypozyczenie.setId(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.wypozyczenie = em.find(Wypozyczenie.class, wypozyczenie.getId());
		em.close();
		return "edytujWypozyczenie.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.wypozyczenie = em.find(Wypozyczenie.class, wypozyczenie.getId());
		em.remove(this.wypozyczenie);
		this.wypozyczenie = new Wypozyczenie();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Usunieto Wypo¿yczenie!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		wypozyczenie.setId(null);
		em.persist(wypozyczenie);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano Wypo¿yczenie!");
		em.close();
		this.wypozyczenie = new Wypozyczenie();
		return null;
	}
	

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(wypozyczenie);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Zmieniono dane wypo¿yczenia!");
		this.wypozyczenie = new Wypozyczenie();
		return "pokazWypozyczenie.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
	

}
