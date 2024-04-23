package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateConnection;
import by.tms.sportcenter.entity.Customer;
import by.tms.sportcenter.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void add(Customer customer) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}