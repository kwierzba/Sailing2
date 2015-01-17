package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Rejs;

public class RejsBean {
	private Rejs rejs = new Rejs();

	public Rejs getRejs() {
		return rejs;
	}

	public void setRejs(Rejs rejs) {
		this.rejs = rejs;
	}

	//

	public List<Rejs> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Rejs.findAll").getResultList();
		em.close();
		return list;
	}

	public void rejsListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("rejsID").toString();
		int jId = Integer.parseInt(ids);
		this.rejs.setId(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.rejs = em.find(Rejs.class, rejs.getId());
		em.close();
		return "edytujRejs.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.rejs = em.find(Rejs.class, rejs.getId());
		em.remove(this.rejs);
		this.rejs = new Rejs();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Usunieto Rejs!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		rejs.setId(null);
		em.persist(rejs);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano rejs!");
		em.close();
		this.rejs = new Rejs();
		return null;
	}
	

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(rejs);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Zmieniono dane rejsu!");
		this.rejs = new Rejs();
		return "pokazRejs.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
