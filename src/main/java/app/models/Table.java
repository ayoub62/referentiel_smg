package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="tables")
public class Table {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "table_nom")
	private String nom;
	
	@OneToMany(mappedBy="table",cascade=CascadeType.ALL)
	private List<Champ> champs = new ArrayList<>();
	
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

	public Table(String nom) {
		this.nom = nom;
	}
	
	public Table() {
	}

	public List<Champ> getChamps() {
		return champs;
	}

	public void setChamps(List<Champ> champs) {
		this.champs = champs;
	}
	
	
}
