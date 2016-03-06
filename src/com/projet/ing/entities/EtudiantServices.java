package com.projet.ing.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.projet.ing.HibernateUtil;

// Generated 5 mars 2016 15:35:36 by Hibernate Tools 4.0.0



	/**
	 * Home object for domain model class EtudiantServices.
	 * @see .EtudiantServices
	 * @author Hibernate Tools
	 */
	public class EtudiantServices {


	Session session=HibernateUtil.getSessionFactory().openSession();
		
		public Long conecter(String log,String pass){
	Long res=null;
			Transaction tx=session.beginTransaction();
			
			//recupere etudiant
			Criteria crit=session.createCriteria(Etudiant.class);
			crit.add(Restrictions.like("login", log));
			crit.add(Restrictions.like("password",pass));
			List<Etudiant> e=crit.list();
		
				for (Etudiant etudiant : e) {
					res=etudiant.getId();
				}
				
				tx.commit();
				session.close();
				if(res==null){
					return null;
				}
				else return res;
			
				
			
}
	


}
