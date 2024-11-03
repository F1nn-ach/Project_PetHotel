package com.springmvc.manager;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.springmvc.model.*;

public class PetManager {
    private SessionFactory sessionFactory;

    public PetManager() {
        this.sessionFactory = HibernateConnection.doHibernateConnection();
    }

    public long getTotalPetId() {
        Session session = null;
        Transaction transaction = null;
        long total = 0;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT count(*) FROM Pet", Long.class);
            total = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return total;
    }
    
    public List<Pet> getAllPets() {
        Session session = null;
        Transaction transaction = null;
        List<Pet> pets = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<Pet> query = session.createQuery("FROM Pet", Pet.class);
            pets = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pets;
    }


    public List<Pet> getPetByEmail(String email) {
        Session session = null;
        Transaction transaction = null;
        List<Pet> pets = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<Pet> query = session.createQuery(
                "SELECT p FROM User u JOIN u.userPets p WHERE u.userEmail = :email",
                Pet.class
            );
            query.setParameter("email", email);
            pets = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pets;
    }

    public List<PetType> getPetTypes() {
        Session session = null;
        Transaction transaction = null;
        List<PetType> petTypes = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<PetType> query = session.createQuery("FROM PetType", PetType.class);
            petTypes = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return petTypes;
    }

    public Pet getPetById(String petId) {
        Session session = null;
        Transaction transaction = null;
        Pet pet = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            pet = session.get(Pet.class, petId);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pet;
    }

    public PetType getPetTypeByName(String name) {
        Session session = null;
        Transaction transaction = null;
        PetType petType = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<PetType> query = session.createQuery(
                "FROM PetType WHERE petTypeName = :name",
                PetType.class
            );
            query.setParameter("name", name);
            petType = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return petType;
    }

    public boolean deletePet(Pet pet) {
        Session session = null;
        Transaction transaction = null;
        boolean isDeleted = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(pet);

            transaction.commit();
            isDeleted = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isDeleted;
    }

    public boolean updatePet(Pet pet) {
        Session session = null;
        Transaction transaction = null;
        boolean isUpdated = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(pet);

            transaction.commit();
            isUpdated = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }

    public List<Pet> getPetsByUser(String userEmail) {
        Session session = null;
        List<Pet> pets = new ArrayList<>();
        
        try {
            session = sessionFactory.openSession();
            
            String hql = "FROM Pet p WHERE p.user.userEmail = :userEmail";
            Query<Pet> query = session.createQuery(hql, Pet.class);
            query.setParameter("userEmail", userEmail);
            
            pets = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return pets;
    }
}