package com.example.BeTheFutureBackend.Employee;

import com.example.BeTheFutureBackend.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeModel employeeModel;

    @Autowired
    public EmployeeController(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
    
    //GET ALL EMPLOYEES
    @GetMapping(path = "/getAll")
    public Iterable<User> getAllEmployees(){
        return employeeModel.getAllEmployees();
    }

}
