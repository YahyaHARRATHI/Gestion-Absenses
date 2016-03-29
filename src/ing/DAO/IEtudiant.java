package ing.DAO;

import ing.entity.Etudiant;

public interface IEtudiant {
	
	public Long connecter(String login,String password);
	public Etudiant getetudiant(Long id);

}
