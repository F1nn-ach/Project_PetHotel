package com.springmvc.model;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelManager {
	public List<Pet> getPets() {
		List<Pet> list = new ArrayList<Pet>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = session.createQuery("From Pet").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Owner> getOwners() {
		List<Owner> list = new ArrayList<Owner>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = session.createQuery("From Owner").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean saveOwner(Owner owner) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(owner);

			session.getTransaction().commit();

			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Owner getOwnerByEmail(String email) {
		Owner owner = new Owner();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			owner = (Owner) session.createQuery("From Owner where email = '" + email + "'").uniqueResult();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return owner;
	}
}
