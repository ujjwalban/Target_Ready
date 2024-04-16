package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.entity.Laptop;
import com.targetindia.utils.JpaUtils;

public class IssueNewLaptopToEmployees {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setMake("ACER");
        l1.setModel("TravelMate 345");

        Laptop l2 = new Laptop();
        l2.setMake("Apple");
        l2.setModel("macbook pro");

        try(var em = JpaUtils.createEntityManager()){


            var emp1 = em.find(Employee.class,3);
            var emp2 = em.find(Employee.class,7);

            emp1.setLaptop(l1);
            l1.setAssignedTo(emp1);

            emp2.setLaptop(l2);
            l2.setAssignedTo(emp2);

            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("new laptops assigned to employees");
        }
    }
}
