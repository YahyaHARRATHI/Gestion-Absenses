package ing.entities;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Matiere generated by hbm2java
 */
@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMat;
	
	private String nomMatiere;
	

	public Matiere() {
	}

	

	public Matiere(Absence absence, String nomMatiere) {
		
		this.nomMatiere = nomMatiere;
		
	}

	public Long getIdMat() {
		return this.idMat;
	}

	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}



	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}


}