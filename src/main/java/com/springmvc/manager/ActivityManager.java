package com.springmvc.manager;

import java.time.LocalDate;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springmvc.model.*;

public class ActivityManager {
	private SessionFactory sessionFactory;

    public ActivityManager() {
        this.sessionFactory = HibernateConnection.doHibernateConnection();
    }

    public boolean createActivity(String activityDetail, String activityImage, 
                                LocalDate activityDate, String petId, String bookingId) {
        Session session = null;
        Transaction transaction = null;
        boolean isCreated = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Pet pet = session.get(Pet.class, petId);
            Booking booking = session.get(Booking.class, bookingId);

            if (pet != null && booking != null) {
                PetActivity activity = new PetActivity();
                activity.setActivityDetail(activityDetail);
                activity.setActivityImage(activityImage);
                activity.setActivityDate(activityDate);
                activity.setPet(pet);
                activity.setBooking(booking);

                session.save(activity);
                isCreated = true;
            }

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
        return isCreated;
    }

    public List<PetActivity> getPetActivityByBookingId(String bookingId) {
        Session session = null;
        List<PetActivity> activities = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            String hql = "FROM PetActivity WHERE booking.id = :bookingId";
            activities = session.createQuery(hql, PetActivity.class)
                                .setParameter("bookingId", bookingId)
                                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return activities;
    }

}
