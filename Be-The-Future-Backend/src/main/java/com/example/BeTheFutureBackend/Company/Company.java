package com.example.BeTheFutureBackend.Company;

import com.example.BeTheFutureBackend.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<User> managers;

    //rating of the company
    private int rating;



    public void addManager(User manager){
        this.managers.add(manager);
    }

}