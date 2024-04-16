package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.JpaUtils;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;
import jakarta.persistence.EntityManager;

import java.sql.SQLOutput;

public class GetCategoryAndCorrespondingProduct {
    public static void main(String[] args) {
        var id = KeyboardUtil.getInt("enter the category id here: ");
        try(EntityManager em = JpaUtils.createEntityManager()){
            var cat = em.find(Category.class,id);

            if(cat==null){
                System.out.println("No category found for id "+ id);
                return;
            }

            Printer.print(cat,"products");
        }
    }
}
