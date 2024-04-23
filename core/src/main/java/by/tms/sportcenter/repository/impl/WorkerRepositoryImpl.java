package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateConnection;
import by.tms.sportcenter.entity.Worker;
import by.tms.sportcenter.repository.WorkerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerRepositoryImpl implements WorkerRepository {
    @Override
    public void add(Worker worker) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(worker);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}