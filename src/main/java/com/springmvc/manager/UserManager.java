package com.springmvc.manager;

import java.util.*;

import org.hibernate.*;

import com.springmvc.model.User;

public class UserManager {
	public boolean saveOrUpdateUser(User u) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(u);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public User getLogin(String email) {
		User user = null;
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			user = session.createQuery("from User where userEmail = :email", User.class)
					.setParameter("email", email).uniqueResult();
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
	
	public boolean updateUser(User user) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(user);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public User getUserByEmail(String email) {
	    User user = null;

	    try {
	        SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
	        Session session = sessionFactory.openSession();

	        user = (User) session.createQuery("FROM User WHERE email = :email")
	                .setParameter("email", email)
	                .uniqueResult();

	        session.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return user;
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();

		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			list = session.createQuery("From User where isAdmin = false").list();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public boolean delUser(User user) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);

			session.getTransaction().commit();

			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean isEmailExists(String email) {
		Session session = null;
		Transaction transaction = null;
		boolean exists = false;
		try {
			session = HibernateConnection.doHibernateConnection().openSession();
			transaction = session.beginTransaction();

			Long count = session.createQuery("SELECT COUNT(*) FROM User u WHERE u.userEmail = :email", Long.class)
					.setParameter("email", email).uniqueResult();
			exists = (count != null && count > 0);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return exists;
	}
}
