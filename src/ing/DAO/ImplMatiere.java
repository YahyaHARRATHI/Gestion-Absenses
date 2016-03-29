package ing.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ing.entity.Matiere;
import ing.util.HibernateUtil;

public class ImplMatiere {

	public Long getIdMatiere(String matiere) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Matiere m=null;
		Query q = session.createQuery(" select m from Matiere m where m.libelle=:x ");
		q.setParameter("x", matiere);
		if(q.list().size()!=0){
			
		m=new Matiere();
		m=(Matiere) q.list().get(0);
		
		session.getTransaction().commit();
		session.close();
		return m.getId();
		}
		
		else{
		session.getTransaction().commit();
		session.close();

		return null;
		}
	}

}
