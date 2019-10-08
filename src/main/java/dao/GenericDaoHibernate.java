package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public abstract class GenericDaoHibernate <T,ID extends Serializable> implements GenericDaoInterface<T, ID>{

	private Class<T> classe = null;
	
	public GenericDaoHibernate(Class<T> classe) {
		this.classe = classe;
	}



	public T delete(T t) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transection = session.beginTransaction();
			session.delete(t);
			transection.commit();
			session.close();
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public T update(T t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transection = session.beginTransaction();
			session.save(t);
			transection.commit();
			session.close();
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<T> findAll() {
		List<T> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			list = session.createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
			transaction.commit();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public T save(T t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transection = session.beginTransaction();
			session.save(t);
			transection.commit();
			session.close();
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public T findByUserName(String userName) {
		T t;
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from Usuario where email = :cemail");
			q.setParameter("cemail", userName);
			Transaction transaction = session.beginTransaction();
			t = (T) q.getSingleResult();
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
