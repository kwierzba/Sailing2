package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import pl.config.DBManager;
import pl.config.UzytkownikConverter;
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
		this.dodajInformacje("Usunieto U¿ytkownika!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		uzytkownik.setId(null);
		em.persist(uzytkownik);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano U¿ytkownika!");
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
		this.dodajInformacje("Zmieniono dane u¿ytkownika!");
		this.uzytkownik = new Uzytkownik();
		return "pokazUzytkownika.xhtml";
	}

	public String logon(){
		EntityManager em = DBManager.getManager().createEntityManager();
		Uzytkownik test = (Uzytkownik) em.createQuery("SELECT u FROM Uzytkownik u WHERE u.uimie = '" + this.uzytkownik.getUimie() + "' "
				+ "AND u.unazwisko = '" + this.uzytkownik.getUnazwisko() + "'")
				.getSingleResult();
		//if(em.find(Uzytkownik.class, uzytkownik.getUimie()))
		//String sImie = 	this.uzytkownik.getUimie();
		//String sNazwisko = this.uzytkownik.getUnazwisko();
		em.close();
		if(test.getId()!=null)
			return "success";
		else return "failure";
		
	}
	
	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
