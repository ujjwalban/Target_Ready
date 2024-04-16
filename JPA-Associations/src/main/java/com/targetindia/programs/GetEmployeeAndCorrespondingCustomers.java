package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtils;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;
import jakarta.persistence.EntityManager;

public class GetEmployeeAndCorrespondingCustomers {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter the employee id: ");
        Employee emp;
        try(var em  = JpaUtils.createEntityManager()) {
            emp = em.find(Employee.class, id);

            Printer.print(emp, "customers");
            System.out.printf("this employee has processed orders for these %d customers: \n",emp.getCustomers().size());
            for (var c : emp.getCustomers()) {
                System.out.println(c);
            }
        }
    }
}
