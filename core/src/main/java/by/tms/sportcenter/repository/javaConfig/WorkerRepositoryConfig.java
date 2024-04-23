package by.tms.sportcenter.repository.javaConfig;

import by.tms.sportcenter.config.HibernateJavaConfig;
import by.tms.sportcenter.entity.Worker;
import by.tms.sportcenter.repository.WorkerRepository;
import org.hibernate.Remove;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerRepositoryConfig implements WorkerRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(Worker worker) {
//        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(worker);
            session.getTransaction().commit();
        }
    }
}