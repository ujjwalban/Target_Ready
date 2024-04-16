package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtils;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class DeleteShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter The Id: ");
        try(EntityManager em = JpaUtils.createEntityManager()){
            var shipper =  em.find(Shipper.class,id);

            if(shipper==null){
                System.out.println("No Shipper found with that ID");
                return ;
            }

            System.out.println(shipper);
            var choice = KeyboardUtil.getString("Are you sure?");
            if (choice.equalsIgnoreCase("yes")) {
                em.remove(shipper);
                em.getTransaction().begin();
                em.getTransaction().commit();
            }
        }
    }
}
