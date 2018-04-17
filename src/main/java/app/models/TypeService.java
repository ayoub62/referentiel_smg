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
@Table(name="typeservices")
public class TypeService {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "service_type_nom")
	private String nom;
	
	@OneToMany(mappedBy="typeService")
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

	public TypeService(String nom) {
		this.nom = nom;
	}
	
	public TypeService() {
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
