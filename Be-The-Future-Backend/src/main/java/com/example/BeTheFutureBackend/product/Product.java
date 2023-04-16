package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String productName;
    private String description;
    private double price;
    private String photo;
    private String deadline;
    private String state;
    @ManyToOne
    @JoinColumn(name = "CustomerName")
    private User customer;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Task> taskList;


    public Product() {
    }


    public Product(String productName, String description, double price, String photo, String deadline,
                    List<Task> taskList) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.deadline = deadline;
        this.state = "Pending";
        this.taskList = taskList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}

