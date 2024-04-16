package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class jpqlDemo {
    static private EntityManager em;

    public static void main(String[] args) {
        em = JpaUtils.createEntityManager();


        //displayAllShippers();
        displayProductsBetweenPrice(10.0,20.0);


        em.close();
    }

    static void displayProductsBetweenPrice(double min, double max) {
        var jpql = "from Product where unitPrice between ?1 and ?2";
        TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
        qry.setParameter(1,min);
        qry.setParameter(2,max);
        List<Product> list = qry.getResultList();
        list.stream().forEach(jpqlDemo::printProductNameAndPrice);
    }
    static void printProductNameAndPrice(Product p) {
        System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
    }


    static void displayAllShippers() {
        var jpql = "from Shipper s order by s.companyName";
        Query qry = em.createQuery(jpql);
        List list = qry.getResultList();
        list.forEach(System.out::println);
    }
}
