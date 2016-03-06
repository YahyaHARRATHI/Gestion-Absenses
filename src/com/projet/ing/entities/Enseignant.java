package com.projet.ing.entities;


import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Enseignant generated by hbm2java
 */
@Entity
public class Enseignant  {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String prenom;
	private Date datenaiss;
	private String adresse;
	private String password;
	private String login;
	

	public Enseignant() {
	}

	public Enseignant(Absence absence, String password) {
		
		this.password = password;
	}

	public Enseignant(Absence absence, String nom, String prenom, Date datenaiss, String adresse, String password,
			String login) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.datenaiss = datenaiss;
		this.adresse = adresse;
		this.password = password;
		this.login = login;
		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaiss() {
		return this.datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

}
