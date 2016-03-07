package ing.entities;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





// Generated 5 mars 2016 15:35:36 by Hibernate Tools 4.0.0



	/**
	 * Home object for domain model class EtudiantServices.
	 * @see .EtudiantServices
	 * @author Hibernate Tools
	 */
	public class EtudiantServices {

		//ouverture Unité de travail JPA
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("enfin");
	@PersistenceContext
	EntityManager em=emf.createEntityManager();
	
	
		public Long conecter(String log,String pass){
	
	EntityTransaction tx=em.getTransaction();
	tx.begin();
	System.out.println(em.isOpen());
		//ouverture transaction
	//EntityTransaction tx=em.getTransaction();
	
	// create a query
	Query q = em.createQuery("SELECT e FROM etudiant e where e.login = ?1 and e.password= ?2");
			q.setParameter("1", log);
			q.setParameter("2", pass);

	
			
			//recupere etudiant
			
		
			Etudiant e=(Etudiant) q.getSingleResult();
		
			//	tx.commit();
				
				
				
				if(e.getId()==null){
					return null;
				}
				else return e.getId();
			
				
			
}
	


}
