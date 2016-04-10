/**
 * 
 */
package ing.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ing.entity.Absence;
import ing.util.HibernateUtil;

/**
 * @author yaya
 *
 */
public class ImplAbsenceDAO implements IAbsenceDAO {

	@Override
	public List<Absence> listeAbsenceParMatiere(Long idEtudiant, Long idMatiere) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Absence> l = null;

		/*
		 * // sql code SQLQuery q=session.createSQLQuery(
		 * "select a.date from Absence a where a.id_etud=:x and a.id_mat=:y");
		 * 
		 * q.setParameter("x", idEtudiant); q.setParameter("y", idMatiere);
		 */

		Criteria c = session.createCriteria(Absence.class);
		c.createAlias("etudiant", "a");
		c.createAlias("matiere", "m");
		c.add(Restrictions.eq("a.id", idEtudiant));
		c.add(Restrictions.eq("m.id", idMatiere));
		if (c.list().size() != 0) {
			l = new ArrayList<>();
			for (Object o : c.list()) {

				l.add((Absence) o);
			}
			session.getTransaction().commit();
			session.close();
			return l;
		}
		// autre methode
		/*
		 * Iterator<Absence> it=c.list().iterator(); while (it.hasNext()) {
		 * Absence absence = (Absence) it.next();
		 * //System.out.println(absence.getDate()); l.add(absence);
		 * 
		 * }
		 */
		else {

			session.getTransaction().commit();
			session.close();
			return null;
		}
	}

	@Override
	public boolean ajouterAbsence(Absence abs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean annulerAbsence(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ing.DAO.IAbsenceDAO#listmail()
	 */
	@Override
	public List<Absence> listmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Absence> absencesByMatiereAndGroupe(String matiere, Long groupe) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * Query q=session.createQuery(
		 * "select e.nom,e.prenom,a.date from Absence a,Etudiant e" +
		 * " where a.matiere:=x and e.groupe:=y"); q.setParameter("x", idMat);
		 * q.setParameter("y", idGroupe);
		 */

		System.out.println(matiere);
		Criteria c = session.createCriteria(Absence.class);
		c.createAlias("etudiant", "e");
		c.createAlias("matiere", "m");
		c.add(Restrictions.eq("m.libelle", matiere));
		c.add(Restrictions.eq("e.groupe.id", groupe));

		if (c.list().size() == 0) {
			System.out.println("requete null");
			session.getTransaction().commit();
			session.close();
			return null;
		}

		else {
			List<Absence> ret = c.list();
			session.getTransaction().commit();
			session.close();
			return ret;
		}

	}

	@Override
	public List<Absence> getAbsenceForResponsable(Integer cin, String matiere) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Absence.class);
		c.createAlias("etudiant", "e");
		c.createAlias("matiere", "m");
		c.add(Restrictions.eq("m.libelle", matiere));
		c.add(Restrictions.eq("e.cin", matiere));
		if (c.list().size() == 0) {
			System.out.println("requete null");
			session.getTransaction().commit();
			session.close();
			return null;
		}

		else {
			List<Absence> ret = c.list();
			session.getTransaction().commit();
			session.close();
			return ret;
		}
	}

}
