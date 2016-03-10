package ing.DAO;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import ing.util.HibernateUtil;

public class ImplEtudiantDAO implements IEtudiant {

	
	
	@Override
	public boolean connecter(String login, String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query q = session.createQuery(" from Etudiant e where e.login=:x and e.password=:y");
		q.setParameter("x", login);
		q.setParameter("y", password);
		if(q.list().size()==0)
		{
			session.getTransaction().commit();
			session.close();
			
			return false;
		}
		 
		else{
			session.getTransaction().commit();
			session.close();
			return true;
		}
				
		
		
		
		
	}

}
