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
@Table(name="services")
public class Service {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="service")
	private List<Balise> balises = new ArrayList<>();
	
	@Column(name = "service_nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="type_service_id")
	private TypeService typeService;
	
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

	public Service(String nom) {
		this.nom = nom;
	}
	
	public Service() {
	}

	public List<Balise> getBalises() {
		return balises;
	}

	public void setBalises(List<Balise> balises) {
		this.balises = balises;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
}
