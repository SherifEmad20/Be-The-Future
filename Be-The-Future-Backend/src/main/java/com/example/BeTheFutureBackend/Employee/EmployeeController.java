package com.example.BeTheFutureBackend.Employee;

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

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeModel.addEmployee(employee);
    }

    @GetMapping("/getEmployee/{userName}")
    public Optional<Employee> getEmployee(@PathVariable("userName") String userName) {
        return employeeModel.getEmployee(userName);
    }

    @GetMapping("/getAllEmployees")
    public Iterable<Employee> getAllEmployees() {
        return employeeModel.getAllManagers();
    }

    @DeleteMapping("/deleteEmployee/{userName}")
    public void deleteEmployee(@PathVariable("userName") String userName) {
        employeeModel.deleteEmployee(userName);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeModel.updateEmployee(employee);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee employee) {
        return employeeModel.login(employee);
    }

    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        return employeeModel.register(employee);
    }


}
