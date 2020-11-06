package com.film.repository;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")

public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;
    
    @OneToMany(targetEntity = ActeurEntity.class, cascade = CascadeType.ALL)
    private Set<ActeurEntity> acteurs;
    
	public Long getId() {
		return id;
	}

	public FilmEntity(String titre, String description, Set<ActeurEntity> acteurs) {
		super();
		this.titre = titre;
		this.description = description;
		this.acteurs = acteurs;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ActeurEntity> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Set<ActeurEntity> acteurs) {
		this.acteurs = acteurs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmEntity() {
		super();
	}

	

	

	

    
}
