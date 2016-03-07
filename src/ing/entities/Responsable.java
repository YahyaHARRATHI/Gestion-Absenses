package ing.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Generated 5 mars 2016 15:35:36 by Hibernate Tools 4.0.0

/**
 * Responsable generated by hbm2java
 */
@Entity
public class Responsable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private Integer cin;
	private String login;
	private String password;

	public Responsable() {
	}

	public Responsable(long id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Responsable(long id, String nom, String prenom, String adresse, Integer cin, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cin = cin;
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}