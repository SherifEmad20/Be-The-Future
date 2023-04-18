package com.example.BeTheFutureBackend.Task;

import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String taskName;
    private String taskDescription;
    private String taskStartDate;
    private String taskDeadline;
    private boolean dropped = false;


    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    //add employee to task
    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    @JsonIgnore
    private User employee;

    private boolean done = false;

    public boolean getDropped() {
        return dropped;
    }

    public void setDropped(Boolean dropped) {
        this.dropped = dropped;
    }

    public Task() {
    }

    public Task(String taskName, String taskDescription, String taskStartDate, String taskDeadline, boolean done, boolean dropped) {
        this.dropped = dropped;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStartDate = taskStartDate;
        this.taskDeadline = taskDeadline;
        this.done = done;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public String getTaskName() {
        return taskName;
    }


    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setEmployeeName(String employeeName) {
    }

    public String getEmployeeName() {
        return employee.getUsername();
    }


}
