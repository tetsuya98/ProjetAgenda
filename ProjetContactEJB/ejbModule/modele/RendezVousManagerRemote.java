package modele;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface RendezVousManagerRemote {
	public RendezVous ajouterRdv(RendezVous rdv);
	public Collection<RendezVous> listerRdv();
	void addContacts(RendezVous rdv, ArrayList<Integer> cles);
}
