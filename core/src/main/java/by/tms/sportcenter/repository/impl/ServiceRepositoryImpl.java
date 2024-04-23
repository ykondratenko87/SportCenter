package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateJavaConfig;
import by.tms.sportcenter.entity.Service;
import by.tms.sportcenter.repository.ServiceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    @Override
    public void save(Service service) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(service);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public List<Service> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Service> query = session.createQuery("FROM Service", Service.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sessionFactory.close();
        }
    }
}