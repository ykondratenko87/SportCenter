package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateConnection;
import by.tms.sportcenter.entity.User;
import by.tms.sportcenter.entity.UserStatus;
import by.tms.sportcenter.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void add(User user) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public void delete(User user) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void changeStatus(User user, UserStatus newStatus) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        user.setStatus(newStatus);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateLastVisitDate(User user) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        user.setLastVisitDate(java.time.LocalDate.now());
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}