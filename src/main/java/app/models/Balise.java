package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="balises")
public class Balise {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Balise> criteres = new ArrayList<>();
	
	@Column(name = "balise_nom")
	private String nom;
	
	private int occurence;
	
	private String ref;
	
	public Champ getChamp() {
		return champ;
	}
	public void setChamp(Champ champ) {
		this.champ = champ;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

	private boolean calculated;
	
	@ManyToOne
	@JoinColumn(name="champ_id")
	private Champ champ;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;
	
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
	public int getOccurence() {
		return occurence;
	}
	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public boolean isCalculated() {
		return calculated;
	}
	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
	}
	
	public Balise(String nom, int occurence, String ref, boolean calculated) {
		this.nom = nom;
		this.occurence = occurence;
		this.ref = ref;
		this.calculated = calculated;
	}
	
	public Balise() {
	}
	public List<Balise> getCriteres() {
		return criteres;
	}
	public void setCriteres(List<Balise> criteres) {
		this.criteres = criteres;
	}
}
