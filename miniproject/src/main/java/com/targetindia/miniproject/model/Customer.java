package com.targetindia.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="CUSTOMER_ID")
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="CITY")
    private String city;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE")
    private String phone;
}
