package com.springmvc.model;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelManager {
	public List<Pet> getPets() {
		List<Pet> list = new ArrayList<>();
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
	
	public List<Register> getUsers() {
		List<Register> list = new ArrayList<>();
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
	
	public boolean saveRegister(Register r) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(r);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
