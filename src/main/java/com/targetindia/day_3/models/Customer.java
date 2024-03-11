package com.targetindia.day_3.models;

import com.targetindia.day_3.exceptions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private int id;
    private String name;
    private String city;
    private String email;
    private String phone;

    public Customer(int id, String name, String city, String email, String phone) {
        setId(id);
        setName(name);
        setCity(city);
        setEmail(email);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) throws InvalidIdException{
        if (id < 0) {
            throw new InvalidIdException("Id must be >=0");
        }
        this.id = id;
    }

    public void setName(String name) throws InvalidNameException{
        if (name == null) {
            throw new InvalidNameException("Name cannot be null");
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new InvalidNameException("Name cannot be blank");
        }
        if (name.length() < 3 || name.length() > 25) {
            throw new InvalidNameException("Length of name must be between 3 and 25");
        }
        this.name = name;
    }

    public void setCity(String city) throws InvalidCityException{
        if (city == null) {
            throw new InvalidNameException("City cannot be null");
        }
        city = city.trim();
        if (city.isEmpty()) {
            throw new InvalidNameException("City cannot be blank");
        }
        this.city = city;
    }

    public void setEmail(String email) throws InvalidEmailException {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            throw new InvalidEmailException("Email is not valid");
        }
        this.email = email;
    }

    public void setPhone(String phone) throws InvalidPhoneException{
        String PHONE_NUMBER_REGEX = "^\\d{10}$";
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()){
            throw new InvalidPhoneException("Invalid Phone Number");
        }
        this.phone = phone;
    }

    public String toString() {
        return id + "," + name + "," + city + "," + email + "," + phone;
    }
}
