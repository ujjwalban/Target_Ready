package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.JpaUtils;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetCustomerAndCorrespondingEmployees {
    public static void main(String[] args) {
        var id = KeyboardUtil.getString("Enter the customer id here: ");
        Customer cust;
        try(var em = JpaUtils.createEntityManager()) {
            cust = em.find(Customer.class, id);

            Printer.print(cust, "");
        }
    }
}
