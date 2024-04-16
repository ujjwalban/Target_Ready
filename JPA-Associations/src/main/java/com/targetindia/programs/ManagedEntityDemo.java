package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;

@Slf4j
public class ManagedEntityDemo {
    public static void main(String[] args) throws Exception {
        try(EntityManager em = JpaUtils.createEntityManager()){
            System.out.println("em is an object of type"+em.getClass().getName());

            Category cat = em.find(Category.class,1);

            try(FileInputStream file = new FileInputStream("beverages.jpeg")){
                byte[] bytes = new byte[file.available()];
                file.read(bytes);

                cat.setPicture(bytes);
            }
            em.getTransaction().begin();
            em.getTransaction().commit();
        }
    }
}
