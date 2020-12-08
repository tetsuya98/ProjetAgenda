package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import modele.RendezVous;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({ 
	@NamedQuery(name="findAllContacts", query="SELECT c FROM Contact c ORDER BY c.id"),
    })
public class Contact implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	private int id;
	private String prenom;
	private String nom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private String mobile;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy="lesContacts")
	private Set<RendezVous> lesRendezVous=new HashSet<RendezVous>();

	public Set<RendezVous> getLesRendezVous() {
		return lesRendezVous;
	}
	public void setLesRendezVous(Set<RendezVous> lesRendezVous) {
		this.lesRendezVous = lesRendezVous;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
