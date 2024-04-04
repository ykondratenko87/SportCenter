package by.tms.sportcenter.repository.javaConfig;

import by.tms.sportcenter.config.HibernateJavaConfig;
import by.tms.sportcenter.entity.Customer;
import by.tms.sportcenter.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerRepositoryConfig implements CustomerRepository {
    @Override
    public void add(Customer customer) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }
    }
}