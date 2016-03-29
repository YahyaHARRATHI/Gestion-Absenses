package ing.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ing.entity.Etudiant;
import ing.util.HibernateUtil;

public class ImplEtudiantDAO implements IEtudiant {

	@Override
	public Long connecter(String login, String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery(" from Etudiant e where e.login=:x and e.password=:y");
		q.setParameter("x", login);
		q.setParameter("y", password);
		if (q.list().size() == 0) {
			session.getTransaction().commit();
			session.close();

			return null;
		}

		else {
			Etudiant e = (Etudiant) q.list().get(0);
			session.getTransaction().commit();
			session.close();

			return e.getId();
		}

	}

	@Override
	public Etudiant getetudiant(Long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery(" from Etudiant e where e.id=:x ");
		q.setParameter("x", id);

		Etudiant e = (Etudiant) q.list().get(0);
		session.getTransaction().commit();
		session.close();
		return e;

	}

}
