package ing.DAO;

import java.util.List;

import ing.entities.Absence;

public interface IAbsenceDAO {
	
	//pour l'étudiant et l'enseignat et le responsable
	public List<Absence> listeAbsence(long idEtudiant);
	//pour l'ensenignat
	public boolean ajouterAbsence(Absence abs,Long idEns,Long idMat,Long idEtud);
	//pour le responsable
	public boolean annulerAbsence(Long id);
	
	//envoyer mail 
	public List<Absence> listmail();
	
	
	
	
	

}
