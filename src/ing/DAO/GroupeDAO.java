package ing.DAO;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ing.entity.Groupe;
import ing.util.HibernateUtil;

public class GroupeDAO {
	
	public Long getGroupe(String libelle){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		Criteria c=session.createCriteria(Groupe.class);
		c.add(Restrictions.eq("libelle",""+libelle+""));
		if(c.list().size()==0){
			System.out.println("nullllll");
			return null;
		}
		
		
		
		else {
			Groupe grp=new Groupe();
			List<Groupe> l=c.list();
			for (Groupe g :l ) {
				
				grp=g;
			}
			return grp.getId();
			
		}
		
	}

}
