package ing.entities;
// Generated 10 mars 2016 14:50:16 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Groupe generated by hbm2java
 */
@Entity
@Table(name = "groupe", catalog = "gestionabsense")
public class Groupe implements java.io.Serializable {

	private Long id;
	private String niveau;
	private String filiere;
	private Set<Etudiant> etudiants = new HashSet<Etudiant>(0);

	public Groupe() {
	}

	public Groupe(String niveau, String filiere, Set<Etudiant> etudiants) {
		this.niveau = niveau;
		this.filiere = filiere;
		this.etudiants = etudiants;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "niveau", length = 45)
	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Column(name = "filiere", length = 45)
	public String getFiliere() {
		return this.filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}
