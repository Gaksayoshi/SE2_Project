package com.example.se2_project.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "This field is mandatory")
    @Length(min = 3, max = 30)
    private String name;

    @NotEmpty(message = "This field is mandatory")
    private String email;

    @NotEmpty(message = "This field is mandatory")
    private int phone;

    @NotEmpty(message = "This field is mandatory")
    private String address;

    @NotEmpty(message = "This field is mandatory")
    @Length(max = 30)
    private String userName;

    @Length(min = 8, max = 30)
    @NotEmpty(message = "This field is mandatory")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
