package by.tms.sportcenter.repository.impl;

import by.tms.sportcenter.config.HibernateConnection;
import by.tms.sportcenter.entity.User;
import by.tms.sportcenter.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

public class UserRepositoryImpl {

    public void add(User user) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        entityManager.close();
        return users;
    }


    public void delete(User user) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}