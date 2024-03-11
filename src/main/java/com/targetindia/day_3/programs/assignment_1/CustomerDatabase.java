package com.targetindia.day_3.programs.assignment_1;

import com.targetindia.day_3.exceptions.*;
import com.targetindia.day_3.models.Customer;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@Slf4j
public class CustomerDatabase {
    private ArrayList<Customer> customers;
    int nextId;
    private String FileName = "customers.csv";

    public CustomerDatabase() {
        customers = new ArrayList<>();
        loadCustomersFromFile();
    }

    private void loadCustomersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String line;
            boolean SkipHeader = true;
            while ((line = reader.readLine()) != null) {
                if (SkipHeader) {
                    SkipHeader = false;
                    continue;
                }
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String city = parts[2];
                String email = parts[3];
                String phone = parts[4];
                customers.add(new Customer(id, name, city, email, phone));
            }
        } catch (IOException e) {
            System.out.println("Error loading customers from file: " + e.getMessage());
        }
    }

    public boolean SearchId(int id) {
        for (Customer customer : customers) {
            if (id == customer.getId()) {
                return true;
            }
        }
        return false;
    }

    private void saveCustomersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
            writer.write("ID,Name,City,Email,Phone");
            writer.newLine();
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving customers to file: " + e.getMessage());
        }
    }

    public void addCustomer(int id, String name, String city, String email, String phone) {
        customers.add(new Customer(id, name, city, email, phone));
        saveCustomersToFile();
        System.out.println("Customer Added Successfully");

    }

    public void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void SearchCustomerById(int Id) {
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getId() == Id) {
                found = true;
                System.out.println(customer.toString());
            }
        }
        if (!found) {
            System.out.println("Customer not found with specified Id");
        }
    }

    public void SearchCustomerByCity(String SearchCity) {
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getCity().equalsIgnoreCase(SearchCity)) {
                found = true;
                System.out.println(customer);
            }
        }
        if (!found) {
            System.out.println("Customer not found in specified city");
        }
    }

    public void deleteCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
                saveCustomersToFile();
                System.out.println("Customer deleted successfully.");
                return;
            }
        }
        System.out.println("Customer with the specified ID not found.");
    }

    public void editCustomerName(int id, String newName) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setName(newName);
                saveCustomersToFile();
                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Customer with the specified ID not found.");
    }

    public void editCustomerCity(int id, String newCity) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setCity(newCity);
                saveCustomersToFile();
                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Customer with the specified ID not found.");
    }

    public void editCustomerEmail(int id, String newEmail) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setEmail(newEmail);
                saveCustomersToFile();
                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Customer with the specified ID not found.");
    }

    public void editCustomerPhone(int id, String newPhone) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setPhone(newPhone);
                saveCustomersToFile();
                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Customer with the specified ID not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDatabase cm = new CustomerDatabase();

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add new customer");
                System.out.println("2. View all customers");
                System.out.println("3. Search customers by city");
                System.out.println("4. Delete a customer (by ID)");
                System.out.println("5. Search customers by ID and edit/update details");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        scanner.nextLine();
                        System.out.print("Enter customer id: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        if (cm.SearchId(id)) {
                            System.out.println("Id Already Exists, Id should be Unique");
                            break;
                        }
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter customer city: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter customer phone: ");
                        String phone = scanner.nextLine();
                        cm.addCustomer(id, name, city, email, phone);
                    }
                    case 2 -> cm.viewAllCustomers();
                    case 3 -> {
                        scanner.nextLine();
                        System.out.print("Enter city: ");
                        String searchCity = scanner.nextLine();
                        cm.SearchCustomerByCity(searchCity);
                    }
                    case 4 -> {
                        scanner.nextLine();
                        System.out.print("Enter id to delete Customer: ");
                        int deleteId = scanner.nextInt();
                        cm.deleteCustomer(deleteId);
                    }
                    case 5 -> {
                        System.out.print("Enter Id to Edit Details of Customer: ");
                        int editId = scanner.nextInt();
                        cm.SearchCustomerById(editId);
                        scanner.nextLine(); // Consume newline
                        System.out.println("What you want to Edit ?");
                        System.out.println("1. Name");
                        System.out.println("2. City");
                        System.out.println("3. Email");
                        System.out.println("4. Phone");
                        System.out.print("Enter your choice: ");
                        int option = scanner.nextInt();

                        switch (option) {
                            case 1 -> {
                                scanner.nextLine();
                                System.out.print("Enter Updated Name: ");
                                String newName = scanner.nextLine();
                                cm.editCustomerName(editId, newName);
                            }
                            case 2 -> {
                                scanner.nextLine();
                                System.out.print("Enter Updated City: ");
                                String newCity = scanner.nextLine();
                                cm.editCustomerCity(editId, newCity);
                            }
                            case 3 -> {
                                scanner.nextLine();
                                System.out.print("Enter Updated Email: ");
                                String newEmail = scanner.nextLine();
                                cm.editCustomerEmail(editId, newEmail);
                            }
                            case 4 -> {
                                scanner.nextLine();
                                System.out.print("Enter Updated Phone: ");
                                String newPhone = scanner.nextLine();
                                cm.editCustomerPhone(editId, newPhone);
                            }
                            default -> System.out.println("No Updates");
                        }
                    }
                    case 6 -> {
                        System.out.println("Exiting");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice. Please enter a number between 1 and 6.");
                }
            } catch (InvalidIdException | InvalidNameException | InvalidCityException | InvalidEmailException |
                     InvalidPhoneException | IllegalArgumentException e) {
                log.error(String.valueOf(e));
            }
        }
    }
}
