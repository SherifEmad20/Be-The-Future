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

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getUsername())) {
            throw new IllegalStateException("employee already exists");
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(String userName) {
        return employeeRepository.findById(userName);
    }

    public Iterable<Employee> getAllManagers() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(String userName) {
        employeeRepository.findById(userName);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public ResponseEntity<Employee> login(Employee employee) {
        if (employeeRepository.existsById(employee.getUsername()) ||
                employeeRepository.existsById(employee.getEmail())) {
            Employee employee1 = employeeRepository.findById(employee.getUsername()).get();
            if (employee1.getPassword().equals(employee.getPassword())) {
                return ResponseEntity.ok(employee1);
                //return true;
            }
        }
        return (ResponseEntity<Employee>) ResponseEntity.internalServerError();
        //return false;
    }

    public String register(Employee employee) {
        if (employeeRepository.existsById(employee.getUsername())) {
            return "Username already exists";
            //return false;
        }
        employeeRepository.save(employee);
        return "Successful registration";
        //return true;
    }
}
