package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateJavaConfig;
import by.tms.sportcenter.entity.Room;
import by.tms.sportcenter.entity.Service;
import by.tms.sportcenter.repository.RoomRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public void save(Room room) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Service service=new Service();
            room.setService(service);
            session.saveOrUpdate(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public List<Room> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Room> query = session.createQuery("FROM Room", Room.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sessionFactory.close();
        }
    }
}