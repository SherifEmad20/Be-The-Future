package com.example.BeTheFutureBackend.Employee;

import com.example.BeTheFutureBackend.Task.Task;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String Photo;
    private int workingHours;
    private final String role = "employee";

    //add array of tasks to employee
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> taskList;

    public Employee() {
    }

    public Employee(String userName, String fullName, String email, String password, String phoneNumber) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return role;
    }
}
