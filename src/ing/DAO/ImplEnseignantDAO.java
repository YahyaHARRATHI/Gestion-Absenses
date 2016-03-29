package ing.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ing.entity.Professeur;
import ing.util.HibernateUtil;

public class ImplEnseignantDAO implements IEnseignantDAO {

	@Override
	public Long connect(String login, String password) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery(" from Professeur e where e.login=:x and e.password=:y");
		q.setParameter("x", login);
		q.setParameter("y", password);
		if (q.list().size() == 0) {
			session.getTransaction().commit();
			session.close();

			return null;
		}

		else {
			Professeur e = (Professeur) q.list().get(0);
			session.getTransaction().commit();
			session.close();

			return e.getId();
		}

	}
}
