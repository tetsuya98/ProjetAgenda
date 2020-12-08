package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({ 
	@NamedQuery(name="findAllRdv", query="SELECT r FROM RendezVous r ORDER BY r.id"),
    })
public class RendezVous implements Serializable {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	private int id;
	private String libelle;
	private String heureFin;
	private String heureDebut;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
		@JoinTable(name="participer",
		joinColumns = @JoinColumn(name="rendezvous_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="contact_id", referencedColumnName="id")
	)
	public Set<Contact> lesContacts = new HashSet<Contact>();
	
	public Set<Contact> getLesContacts() {
		return lesContacts;
	}
	public void setLesContacts(Set<Contact> lesContacts) {
		this.lesContacts = lesContacts;
	}
	
	public void addContact(Contact contact) {
		this.lesContacts.add(contact);
	}

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public int getId() {
		return id;
	}
}
