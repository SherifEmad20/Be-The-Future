package com.example.BeTheFutureBackend.Employee;

import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("employee")
public class Employee extends User {

    //@Id
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String Photo;
    private int workingHours;

    //add array of tasks to employee
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> taskList;

    public Employee() {
    }

    public Employee(String username, String fullName, String email, String password, String phoneNumber) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    //add task to employee
    public void addTask(Task task) {
        taskList.add(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
