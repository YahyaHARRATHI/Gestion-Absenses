package ing.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ing.entities.Annee;

import ing.util.HibernateUtil;

public class ImplEtudiantDAO implements IEtudiant {

	
	
	@Override
	public boolean connecter(String login, String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query q = session.createSQLQuery("select * from Annee");
		
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
		return false;
	}

}
