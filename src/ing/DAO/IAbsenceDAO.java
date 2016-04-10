package ing.DAO;

import java.util.List;

import ing.entity.Absence;

public interface IAbsenceDAO {

	/**
	 * 
	 * @param cin
	 * @param matiere
	 * @return
	 */
	public List<Absence> getAbsenceForResponsable(Integer cin,String matiere);
	/**
	 * 
	 * @param idEtudiant
	 * @param idMatiere
	 * @return
	 */
	// pour l'étudiant et l'enseignat et le responsable
	public List<Absence> listeAbsenceParMatiere(Long idEtudiant, Long idMatiere);

	/**
	 * 
	 * @param abs
	 * @return
	 */
	// pour l'ensenignat
	public boolean ajouterAbsence(Absence abs);

	// pour le responsable
	public boolean annulerAbsence(Long id);

	// pour le professeur
	/**
	 * 
	 * @param idMat
	 * @param idGroupe
	 * @return
	 */
	public List<Absence> absencesByMatiereAndGroupe(String matiere, Long groupe);

	// envoyer mail
	/**
	 * 
	 * @return
	 */
	public List<Absence> listmail();

}
