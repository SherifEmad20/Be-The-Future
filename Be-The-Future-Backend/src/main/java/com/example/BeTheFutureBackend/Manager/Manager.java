package com.example.BeTheFutureBackend.Manager;

import com.example.BeTheFutureBackend.Company.Company;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String phone;

    private String Photo;

    private final String role = "manager";
    @ManyToOne//many managers can belong to one company
    @JoinColumn(name = "company_id")
    private Company company;


    public Manager(String userName, String fullName, String email, String password, String phone) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected Manager() {

    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }
}