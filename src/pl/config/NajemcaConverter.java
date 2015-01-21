/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.config;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import pl.model.entity.Najemca;


public class NajemcaConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent c, String s) {
        Integer i = Integer.valueOf(s);
        EntityManager em = DBManager.getManager().createEntityManager();
        Najemca p = em.find(Najemca.class, i);
        em.close();
        return p;
    }

    public String getAsString(FacesContext ctx, UIComponent c, Object o) {
        if(! (o instanceof Najemca))
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji!"));
       Najemca p = (Najemca) o;
        return p.getId().toString();
    }
    
}
