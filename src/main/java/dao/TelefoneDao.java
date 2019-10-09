package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Telefone;
import util.HibernateUtil;

public class TelefoneDao extends GenericDaoHibernate<TelefoneDao, Long>{

	public TelefoneDao(Class<TelefoneDao> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}
	
	
	public Telefone findGetTelefone(String userName){
		Telefone t;
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from Telefone where id = :cemail");
			q.setParameter("cemail", userName);
			Transaction transaction = session.beginTransaction();
			t = (Telefone) q.getSingleResult();
			transaction.commit();
			session.close();
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
			//e.printStackTrace();
			
		}
		
		return null;
	}

}
