package ing.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ing.entity.Absence;
import ing.entity.Matiere;
import ing.util.HibernateUtil;

public class ImplMatiere {
	
	public Long getIdMatiere(String matiere){
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query q = session.createQuery(" select m from Matiere m where m.libelle=:x ");
		q.setParameter("x", matiere);
		Matiere m =(Matiere) q.uniqueResult();
		return (m.getId());
				
	}

}
