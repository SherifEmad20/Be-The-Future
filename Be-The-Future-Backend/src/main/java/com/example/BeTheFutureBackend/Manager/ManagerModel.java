package com.example.BeTheFutureBackend.Manager;

import com.example.BeTheFutureBackend.Company.Company;
import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.Task.TaskRepository;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ManagerModel {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public ManagerModel(UserRepository userRepository,  TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public Optional<User> getManager(String userName) {
        //get
        return userRepository.findByUsername(userName);
    }

    //get all managers
    public Iterable<User> getAllManagers() {
        Iterable<User> users=userRepository.findAll();
        //retur onle users with role admin
        ArrayList<User> managers=new ArrayList<>();
        for (User user:users) {
            if(user.getRole().equals((Role.ROLE_MANAGER))){
                managers.add(user);
            }
        }

        return managers;
    }

    //add company to manager
    public void addCompanyToManager(User manager, Company company) {
        manager.setCompany(company);
        userRepository.save(manager);
    }

    // add task to employee
    public String addTaskToEmployee(String employeeName, long taskID) {
        User employee = userRepository.findByUsername(employeeName).get();
        Task task = taskRepository.findById(taskID).get();
        employee.addTask(task);
        task.setEmployee(employee);
        taskRepository.save(task);
        userRepository.save(employee);
        return "Task added to employee " + employeeName;
    }
}
