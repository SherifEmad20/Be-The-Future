package com.example.BeTheFutureBackend.Employee;

import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.Task.TaskRepository;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeModel {

    private final UserRepository userRepository;

    @Autowired
    public EmployeeModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllEmployees(){
        Iterable<User> users=userRepository.findAll();
        //retur onle users with role admin
        ArrayList<User> employees=new ArrayList<>();
        for (User user:users) {
            if(user.getRole().equals((Role.ROLE_EMPLOYEE))){
                employees.add(user);
            }
        }

        return employees;
    }


}
