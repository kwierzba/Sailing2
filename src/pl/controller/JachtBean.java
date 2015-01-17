package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Jacht;

public class JachtBean {
	private Jacht jacht = new Jacht();

	public Jacht getJacht() {
		return jacht;
	}

	public void setJacht(Jacht jacht) {
		this.jacht = jacht;
	}

	//

	public List<Jacht> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Jacht.findAll").getResultList();
		em.close();
		return list;
	}

	public void jachtListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("jachtID").toString();
		int jId = Integer.parseInt(ids);
		this.jacht.setId(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.jacht = em.find(Jacht.class, jacht.getId());
		em.close();
		return "edytujJacht.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.jacht = em.find(Jacht.class, jacht.getId());
		em.remove(this.jacht);
		this.jacht = new Jacht();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Usunieto jacht!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		jacht.setId(null);
		em.persist(jacht);
		em.getTransaction().commit();
		this.dodajInformacje("Dodano jacht!");
		em.close();
		this.jacht = new Jacht();
		return null;
	}

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(jacht);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Zmieniono dane jachtu!");
		this.jacht = new Jacht();
		return "pokazJacht.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
