package com.projet.ing.entities;


// Generated 5 mars 2016 15:35:36 by Hibernate Tools 4.0.0

import java.util.Date;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Absence generated by hbm2java
 */
@Entity
public class Absence  {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Integer numeroSeance;
	private Date date;
	private String justification;
	@OneToMany
	private Set<Enseignant> enseignants ;
	@OneToMany
	private Set<Etudiant> etudiants ;
	@OneToMany
	private Set<Matiere> matieres ;

	public Absence() {
	}

	public Absence(long id) {
		this.id = id;
	}

	public Absence(long id, Integer numeroSeance, Date date, String justification) {
		this.id = id;
		this.numeroSeance = numeroSeance;
		this.date = date;
		this.justification = justification;
		
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNumeroSeance() {
		return this.numeroSeance;
	}

	public void setNumeroSeance(Integer numeroSeance) {
		this.numeroSeance = numeroSeance;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getJustification() {
		return this.justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Set<Enseignant> getEnseignants() {
		return this.enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public Set<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Set<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

}
