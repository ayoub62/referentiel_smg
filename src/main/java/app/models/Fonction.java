package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fonctions")
public class Fonction {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "fonction_nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="domaine_id")
	private Domaine domaine;
	
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

	public Fonction(String nom) {
		this.nom = nom;
	}
	
	public Fonction() {
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
}
