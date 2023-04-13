package com.example.BeTheFutureBackend.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeModel {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeModel(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<?> register(Employee employee) {
        if (employeeRepository.existsById(employee.getUserName())) {
            throw new IllegalStateException("username already exists");
        }
        if (employeeRepository.existsById(employee.getEmail())) {
            throw new IllegalStateException("email already exists");
        }
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    public Optional<Employee> getEmployee(String userName) {
        return employeeRepository.findById(userName);
    }

    public Iterable<Employee> getAllManagers() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(String userName) {
        employeeRepository.deleteById(userName);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public ResponseEntity<?> login(Employee employee) {
        if (employeeRepository.existsById(employee.getUserName()) ||
                employeeRepository.existsById(employee.getEmail())) {
            Employee employee1 = employeeRepository.findById(employee.getUserName()).get();
            if (employee1.getPassword().equals(employee.getPassword())) {
                return ResponseEntity.ok(employee1);
                //return true;
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
        //return false;
    }
    //login with username and password
    public ResponseEntity<?> login(String username, String password) {
        if (employeeRepository.existsById(username)) {
            Employee employee1 = employeeRepository.findById(username).get();
            if (employee1.getPassword().equals(password)) {
                return ResponseEntity.ok(employee1);
                //return true;
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
        //return false;
    }

}
