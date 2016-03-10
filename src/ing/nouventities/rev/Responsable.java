package rev;
// Generated 10 mars 2016 13:32:39 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Responsable generated by hbm2java
 */
@Entity
@Table(name = "responsable", catalog = "gestionabsense")
public class Responsable implements java.io.Serializable {

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

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nom", length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 45)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "adresse", length = 45)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "cin")
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	@Column(name = "login", nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
