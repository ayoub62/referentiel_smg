package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="domaines")
public class Domaine {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "domaine_nom")
	private String nom;
	
	@OneToMany(mappedBy="domaine")
	private List<Fonction> fonctions = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="filiale_id")
	private Filiale filiale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Domaine(String nom) {
		this.nom = nom;
	}
	
	public Domaine() {
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
}
