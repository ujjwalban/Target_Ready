package com.targetindia.programs;

import java.util.ResourceBundle;

public class AddShipperRecord {
    public static void main(String []args){
        ResourceBundle rb=ResourceBundle.getBundle("jdbc-conig");
        String driverClassName=rb.getString("jdbc.driver.class-name");
        String url=rb.getString("jdbc.driver.url");
        String username=rb.getString("jdbc.driver.username");
        String password=rb.getString("jdbc.driver.password");

    }
}
