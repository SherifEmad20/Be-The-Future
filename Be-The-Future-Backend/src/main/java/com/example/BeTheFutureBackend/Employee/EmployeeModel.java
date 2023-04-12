package com.example.BeTheFutureBackend.Employee;

import org.springframework.beans.factory.annotation.Autowired;
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
        if (employeeRepository.existsById(employee.getUserName())) {
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


    public String login(Employee employee) {
        if (employeeRepository.existsById(employee.getUserName()) ||
                employeeRepository.existsById(employee.getEmail())) {
            Employee employee1 = employeeRepository.findById(employee.getUserName()).get();
            if (employee1.getPassword().equals(employee.getPassword())) {
                return "Login successful";
                //return true;
            }
        }
        return "Login failed";
        //return false;
    }

    public String register(Employee employee) {
        if (employeeRepository.existsById(employee.getUserName())) {
            return "Username already exists";
            //return false;
        }
        employeeRepository.save(employee);
        return "Successful registration";
        //return true;
    }
}
