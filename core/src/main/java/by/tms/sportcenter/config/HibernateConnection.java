package by.tms.sportcenter.config;

import jakarta.persistence.*;

public class HibernateConnection {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserJpa");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}