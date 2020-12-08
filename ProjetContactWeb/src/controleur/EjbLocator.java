package controleur;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import modele.ContactManager;
import modele.ContactManagerRemote;
import modele.RendezVousManagerRemote;

public class EjbLocator {
	private static Context ctx;
	private static EjbLocator instance = new EjbLocator();
	private EjbLocator() {
	}
	public static EjbLocator getLocator() {
		return instance;
	}

	private <T> T getEjb(Class<T> ejbClass, String beanName) {
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "ProjetContactEAR";
			final String moduleName = "ProjetContactEJB";
			return (T) context.lookup("java:global/" + appName + "/" + moduleName + "/" + beanName + "!" + ejbClass.getName());
		} catch (NamingException e) {
			return null;
		}
	}	
	public ContactManagerRemote getContactManager() {
		return getEjb(ContactManagerRemote.class, "ContactManager");
	}
	public RendezVousManagerRemote getRendezVousManager() {
		return getEjb(RendezVousManagerRemote.class, "RendezVousManager");
	}
// Rajouter ici une méthode pour tout nouvel EJB auquel on souhaite accéder
}
