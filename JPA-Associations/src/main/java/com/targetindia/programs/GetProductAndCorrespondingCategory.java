package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtils;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;
import jakarta.persistence.EntityManager;

public class GetProductAndCorrespondingCategory {
    public static void main(String[] args) throws Exception {
        var id = KeyboardUtil.getInt("Enter Product ID to search: ");
        try(EntityManager em = JpaUtils.createEntityManager()){
            var pro = em.find(Product.class,id);
            if(pro==null){
                System.out.println("No data found for product");
                return;
            }
            Printer.print(pro,"category");
            Printer.print(pro.getCategory(),"category");
        }
        catch (Exception e){
            throw new Exception("NOT FOUND");
        }
    }
}
