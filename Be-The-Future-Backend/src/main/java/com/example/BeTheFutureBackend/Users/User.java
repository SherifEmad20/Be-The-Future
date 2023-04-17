package com.example.BeTheFutureBackend.Users;

import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Company.Company;
import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User implements UserDetails {

    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String city;
    private String photo;

    private float salaryOverWork;

    @ManyToOne//many managers can belong to one company
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> taskList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //add task to employee
    public void addTask(Task task) {
        taskList.add(task);
    }

    //add product to customer
    public void addProduct(Product product) {
        productList.add(product);
    }

}
