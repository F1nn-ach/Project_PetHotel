package com.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelManager {
	public List<Pet> getAllPets() {
		List<Pet> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			list = session.createQuery("From Pet").list(); // คำสั่งhibernate
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

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
			user = session.createQuery("from Register where email = :email", Register.class)
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
	
	public List<Pet> getPetByEmail(String email) {
		List<Pet> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = session.createQuery("Select p From Register r JOIN r.pets WHERE r.email = :email")
					.setParameter("email", email)
					.list();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
