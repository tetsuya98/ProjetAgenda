package modele;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ContactManager
 */
@Stateless
@LocalBean
public class ContactManager implements ContactManagerRemote {

    /**
     * Default constructor. 
     */
    public ContactManager() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;
    
    public Contact ajouterContact(Contact contact) {
    	em.persist(contact);
    	return contact;
    }
    
	public Collection<Contact> listerContact() {
		return em.createQuery("SELECT c FROM Contact c").getResultList();
	}
	
	public Contact findContactById(int id) {
		return (Contact) em.createQuery("SELECT c FROM Contact c where c.id = "+id).getSingleResult();
	}

}
