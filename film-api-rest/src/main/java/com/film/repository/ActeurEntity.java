package com.film.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name="actors")

public class ActeurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
	public Long getId() {
		return id;
	}
	
	@ManyToOne
    private FilmEntity film;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public FilmEntity getFilm() {
		return film;
	}

	public void setFilm(FilmEntity film) {
		this.film = film;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActeurEntity(String nom, String prenom, FilmEntity film) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.film = film;
	}

	public ActeurEntity() {
		super();
	}
	
	
	

}
