package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="filiales")
public class Filiale {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "filiale_nom")
	private String nom;
	
	@OneToMany(mappedBy="filiale")
	private List<Domaine> domaines = new ArrayList<>();
	
	@OneToMany(mappedBy="filiale")
	private List<Service> services = new ArrayList<>();
	
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

	public Filiale(String nom) {
		this.nom = nom;
	}
	
	public Filiale() {
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
