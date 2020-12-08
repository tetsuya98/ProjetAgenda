package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import modele.ContactManager;
import modele.ContactManagerRemote;

public class clientText {
	private static ContactManagerRemote lookupRemoteStatelessContactManager() throws NamingException 
	{
	   ContactManagerRemote bean=null;
	   final Hashtable jndiProperties = new Hashtable();
	   jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	   Context context=null;
	   context = new InitialContext(jndiProperties);
	   final String moduleName = "ProjetContactEAR";
	   final String distinctName = "ProjetContactEJB";
	   final String beanName = ContactManager.class.getSimpleName();
	   final String viewClassName = ContactManagerRemote.class.getName();
	   System.out.println("JNDI généré     : ejb:" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	   bean= (ContactManagerRemote) context.lookup("ejb:" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	   return bean;
	}
	


}
