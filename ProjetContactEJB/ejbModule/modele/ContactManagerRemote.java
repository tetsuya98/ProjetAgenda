package modele;

import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface ContactManagerRemote {
	public Contact ajouterContact(Contact contact);
	public Collection<Contact> listerContact();
	public Contact findContactById(int id);
}
