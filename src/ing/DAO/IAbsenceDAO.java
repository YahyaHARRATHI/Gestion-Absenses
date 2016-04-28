package ing.DAO;

import java.util.List;
import java.util.Map;

import ing.entity.Absence;
import ing.model.ImprimeModel;
import ing.model.MailClass;

public interface IAbsenceDAO {

	
    
    /**
     * 
     * @param matiere
     * @param groupe
     * @return 
     */
    public List<ImprimeModel> imprimer(String matiere,Long groupe);
    
    
    
    
	public List<Absence> getAbsenceForResponsable(int cin,String matiere);

	
	/**
	 * 
	 * @param idEtudiant
	 * @param idMatiere
	 * @return
	 */
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
	public List<MailClass> listmail();

}
