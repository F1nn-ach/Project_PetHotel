package com.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	
	public boolean updateRegister(Register r) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(r);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePet(Pet p) {
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(p);

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
			list = session.createQuery("Select p From Register r JOIN r.pets p WHERE r.email = :email")
					.setParameter("email", email)
					.list();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public List<Booking> getBookingByPetid(String id) {
	    List<Booking> list = new ArrayList<>();
	    Transaction transaction = null;
	    try (Session session = HibernateConnection.doHibernateConnection().openSession()) {
	        transaction = session.beginTransaction();
	        list = session.createQuery("SELECT b FROM Pet p JOIN p.bookings b WHERE p.id = :id", Booking.class)
	                      .setParameter("id", id)
	                      .getResultList();
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        ex.printStackTrace();
	    }
	    return list;
	}

	
	public Pet getPetById(String id) {
		Pet pet = null;
		Session session = null;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			pet = session.get(Pet.class, id); // Use session.get() for fetching by primary key
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return pet;
	}
	
	public long getTotalPetId() {
        long total = 0;
        SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT count(*) FROM Pet", Long.class);
            total = query.uniqueResult();

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return total;
    }
	
	 public boolean isEmailExists(String email) {
	        Session session = null;
	        Transaction transaction = null;
	        boolean exists = false;
	        try {
	            session = HibernateConnection.doHibernateConnection().openSession();
	            transaction = session.beginTransaction();
	            
	            Long count = session.createQuery("SELECT COUNT(*) FROM Register r WHERE r.email = :email", Long.class)
	                .setParameter("email", email)
	                .uniqueResult();
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
