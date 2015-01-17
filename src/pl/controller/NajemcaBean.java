package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Najemca;

public class NajemcaBean {
	private Najemca najemca = new Najemca();

	public Najemca getNajemca() {
		return najemca;
	}

	public void setNajemca(Najemca najemca) {
		this.najemca = najemca;
	}

	//

	public List<Najemca> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Najemca.findAll").getResultList();
		em.close();
		return list;
	}

	public void najemcaListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("najemcaID").toString();
		int jId = Integer.parseInt(ids);
		this.najemca.setId(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.najemca = em.find(Najemca.class, najemca.getId());
		em.close();
		return "edytujNajemce.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.najemca = em.find(Najemca.class, najemca.getId());
		em.remove(this.najemca);
		this.najemca = new Najemca();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Usunieto Najemce!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		najemca.setId(null);
		em.persist(najemca);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano najemce!");
		em.close();
		this.najemca = new Najemca();
		return null;
	}

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(najemca);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Zmieniono dane najemcy!");
		this.najemca = new Najemca();
		return "pokazNajemce.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
