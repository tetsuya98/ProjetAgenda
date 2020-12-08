package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Session Bean implementation class RendezVousManager
 */
@Stateless
@LocalBean
public class RendezVousManager implements RendezVousManagerRemote {

    /**
     * Default constructor. 
     */
    public RendezVousManager() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;
    
    public RendezVous ajouterRdv(RendezVous rdv) {
    	em.persist(rdv);
    	return rdv;
    }
    
	public Collection<RendezVous> listerRdv() {
		return em.createQuery("SELECT r FROM RendezVous r").getResultList();
	}
	
	public void addContacts(RendezVous rdv, ArrayList<Integer> cles) {
        for (Integer cle:cles)
        {
            Contact c = em.find(Contact.class, cle.intValue());
            rdv.addContact(c);
        }
        Set<Contact> cs = rdv.getLesContacts();
        for (Contact r:cs) {
        	System.out.println(r.getNom());
        }
        em.merge(rdv);
    }

}
