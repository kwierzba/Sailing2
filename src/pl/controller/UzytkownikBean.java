package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Uzytkownik;

public class UzytkownikBean {
	private Uzytkownik uzytkownik = new Uzytkownik();

	public Uzytkownik getUzytkownik() {
		return uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	//

	public List<Uzytkownik> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Uzytkownik.findAll").getResultList();
		em.close();
		return list;
	}

	public void uzytkownikListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("uzytkownikID").toString();
		int jId = Integer.parseInt(ids);
		this.uzytkownik.setId(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.uzytkownik = em.find(Uzytkownik.class, uzytkownik.getId());
		em.close();
		return "edytujUzytkownika.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.uzytkownik = em.find(Uzytkownik.class, uzytkownik.getId());
		em.remove(this.uzytkownik);
		this.uzytkownik = new Uzytkownik();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Usunieto Użytkownika!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		uzytkownik.setId(null);
		em.persist(uzytkownik);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano Użytkownika!");
		em.close();
		this.uzytkownik = new Uzytkownik();
		return null;
	}
	

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(uzytkownik);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Zmieniono dane użytkownika!");
		this.uzytkownik = new Uzytkownik();
		return "pokazUzytkownika.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
