package com.springmvc.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelManager {
	public boolean saveRegister(Register r) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(r);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public Register getUserByEmail(String email) {
		Register user = null;
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			user = session.createQuery("from User where user_email = :email", Register.class)
					.setParameter("email", email)
					.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
}
