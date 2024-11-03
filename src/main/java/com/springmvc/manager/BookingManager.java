package com.springmvc.manager;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.springmvc.model.*;

public class BookingManager {
	private SessionFactory sessionFactory;

	public BookingManager() {
		this.sessionFactory = HibernateConnection.doHibernateConnection();
	}
	
	public Booking getBookingById(String id) {
	    Session session = null;
	    Transaction transaction = null;
	    Booking booking = null;

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();

	        booking = session.get(Booking.class, id);

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
	    return booking;
	}

	public long getTotalBookingId() {
		Session session = null;
		Transaction transaction = null;
		long total = 0;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Long> query = session.createQuery("SELECT count(*) FROM Booking", Long.class);
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
	
	public List<Booking> getAllBookings() {
	    Session session = null;
	    Transaction transaction = null;
	    List<Booking> bookings = new ArrayList<>();

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();

	        Query<Booking> query = session.createQuery("FROM Booking", Booking.class);
	        bookings = query.list();

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
	    return bookings;
	}

	public List<Booking> getBookingByUserPetEmail(String userEmail) {
		Session session = null;
		Transaction transaction = null;
		List<Booking> bookings = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Booking> query = session.createQuery(
					"SELECT b FROM Booking b " + "JOIN b.pet p " + "JOIN p.user u " + "WHERE u.userEmail = :userEmail",
					Booking.class);
			query.setParameter("userEmail", userEmail);
			bookings = query.getResultList();

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
		return bookings;
	}

	public boolean createBooking(Booking booking) {
		Session session = null;
		Transaction transaction = null;
		boolean isCreated = false;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(booking);

			transaction.commit();
			isCreated = true;
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

	public BookingStatus getStatusById(String id) {
		Session session = null;
		Transaction transaction = null;
		BookingStatus bookingStatus = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			int statusId = Integer.parseInt(id);
			bookingStatus = session.get(BookingStatus.class, statusId);

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
		return bookingStatus;
	}

	public boolean isPetBooked(String petId) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();
	        
	        Query<Long> query = session.createQuery(
	            "SELECT COUNT(b) FROM Booking b " +
	            "WHERE b.pet.petId = :petId " +
	            "AND b.status.statusName != :excludedStatus", 
	            Long.class
	        );
	        
	        query.setParameter("petId", petId);
	        query.setParameter("excludedStatus", "สำเร็จ"); 
	        
	        Long count = query.uniqueResult();
	        transaction.commit();
	        
	        return count != null && count > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	public List<RoomType> getAllRoomType() {
		Session session = null;
		Transaction transaction = null;
		List<RoomType> roomTypes = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<RoomType> query = session.createQuery("FROM RoomType", RoomType.class);
			roomTypes = query.getResultList();

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
		return roomTypes;
	}
	
	public boolean updateBookingStatus(String bookingId, int statusId) {
	    Session session = null;
	    Transaction transaction = null;
	    boolean isUpdated = false;

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();

	        Booking booking = session.get(Booking.class, bookingId);
	        if (booking != null) {
	            BookingStatus status = session.get(BookingStatus.class, statusId);
	            if (status != null) {
	                booking.setStatus(status);
	                session.update(booking);
	                
	                if (status.getStatusName().equals("สำเร็จ") || status.getStatusName().equals("ยกเลิก")) {
	                    Room room = booking.getRoom();
	                    room.setAvailable(true);
	                    session.update(room);
	                }
	                
	                isUpdated = true;
	            }
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
	    return isUpdated;
	}

	public RoomType getRoomTypeById(int id) {
		Session session = null;
		Transaction transaction = null;
		RoomType roomType = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			roomType = session.get(RoomType.class, id);

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
		return roomType;
	}

	public List<Room> findAvailableRoom(int roomTypeId, Calendar startDateTime, Calendar endDateTime) {
		Session session = null;
		Transaction transaction = null;
		List<Room> availableRooms = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Room> query = session.createQuery(
					"SELECT r FROM Room r " + "WHERE r.roomType.roomTypeId = :roomTypeId " + "AND r.isAvailable = true "
							+ "AND r.roomId NOT IN (" + "SELECT b.room.roomId FROM Booking b "
							+ "WHERE b.startDate < :endDateTime AND b.endDate > :startDateTime)",
					Room.class);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("startDateTime", startDateTime);
			query.setParameter("endDateTime", endDateTime);
			availableRooms = query.getResultList();

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
		return availableRooms;
	}
	
	public int getVacantRoomCount(int roomTypeId) {
	    Session session = null;
	    Transaction transaction = null;
	    
	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();
	        
	        Long count = (Long) session.createQuery(
	            "SELECT COUNT(r) FROM Room r WHERE r.roomType.roomTypeId = :roomTypeId AND r.isAvailable = true")
	            .setParameter("roomTypeId", roomTypeId)
	            .uniqueResult();
	            
	        transaction.commit();
	        return count.intValue();
	        
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return 0;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

	public void updateRoomStatus(int roomId, boolean isAvailable) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<?> query = session.createQuery("UPDATE Room r SET r.isAvailable = :status WHERE r.roomId = :roomId");
			query.setParameter("status", isAvailable);
			query.setParameter("roomId", roomId);
			query.executeUpdate();

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
	}

	public long getTotalBookingHistories() {
		Session session = null;
		Transaction transaction = null;
		long total = 0;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Long> query = session.createQuery("SELECT count(*) FROM BookingHistory", Long.class);
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

	public void addBookingHistory(BookingHistory bookingHistory) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(bookingHistory);

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
	}

	public BookingHistory getBookingHistoryById(String historyId) {
		Session session = null;
		Transaction transaction = null;
		BookingHistory bookingHistory = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			bookingHistory = session.get(BookingHistory.class, historyId);

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
		return bookingHistory;
	}

	public List<BookingHistory> getAllBookingHistories() {
		Session session = null;
		Transaction transaction = null;
		List<BookingHistory> bookingHistories = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<BookingHistory> query = session.createQuery("FROM BookingHistory", BookingHistory.class);
			bookingHistories = query.getResultList();

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
		return bookingHistories;
	}

	public void deleteBookingHistory(String historyId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			BookingHistory bookingHistory = session.get(BookingHistory.class, historyId);
			if (bookingHistory != null) {
				session.delete(bookingHistory);
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
	}

	public List<PetActivity> getPetActivityByBookingId(String bookingId) {
	    Session session = null;
	    Transaction transaction = null;
	    List<PetActivity> petActivities = new ArrayList<>();

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();

	        String hql = "SELECT pa FROM PetActivity pa JOIN pa.booking b WHERE b.bookingId = :bookingId";
	        Query<PetActivity> query = session.createQuery(hql, PetActivity.class);
	        query.setParameter("bookingId", bookingId);

	        petActivities = query.getResultList();

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
	    return petActivities;
	}

	
	
}