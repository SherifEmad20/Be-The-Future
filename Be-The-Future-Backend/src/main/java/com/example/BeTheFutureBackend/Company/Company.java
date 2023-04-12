package com.example.BeTheFutureBackend.Company;

import com.example.BeTheFutureBackend.Manager.Manager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String email;
    private String password;
    //one company can have many managers
    //one to many relationship
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Manager> managers;

    //rating of the company
    private int rating;

    public Company(String companyName, String email, String password) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public void addManager(Manager manager){
        this.managers.add(manager);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}