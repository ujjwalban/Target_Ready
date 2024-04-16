package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtils {
    private JpaUtils() {

    }

    public static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("JPA");
    }

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
