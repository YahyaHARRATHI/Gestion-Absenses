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
import org.hibernate.criterion.Restrictions;

import ing.entity.Absence;
import ing.util.HibernateUtil;



/**
 * @author yaya
 *
 */
public class ImplAbsenceDAO implements IAbsenceDAO {


	@Override
	public List<Absence> listeAbsenceParMatiere(Long idEtudiant,Long idMatiere) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Absence> l=new ArrayList<Absence>();
		
		/*// sql code
		 * SQLQuery q=session.createSQLQuery("select a.date from Absence a where a.id_etud=:x and a.id_mat=:y");
		 
		q.setParameter("x", idEtudiant);
		q.setParameter("y", idMatiere);
		*/
		
		
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
		return l ;
	}

	
	@Override
	public boolean ajouterAbsence(Absence abs, Long idEns, Long idMat, Long idEtud) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean annulerAbsence(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see ing.DAO.IAbsenceDAO#listmail()
	 */
	@Override
	public List<Absence> listmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
