package com.springmvc.model;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelManager {
	public Owner getLogin(String email, String password) {
	    Owner user = null;
	    SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
	    Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    
	    try {
	        tx = session.beginTransaction();
	        user = session.createQuery("from User where email = :email and password = :password", Owner.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
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


	public boolean saveUser(Owner s) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(s);

			session.getTransaction().commit();

			session.close();
			return true;
		} catch (Exception ex) {
		}
		return false;
	}
}
