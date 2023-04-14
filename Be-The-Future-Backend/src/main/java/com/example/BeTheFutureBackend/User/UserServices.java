package com.example.BeTheFutureBackend.User;

import com.example.BeTheFutureBackend.Admin.Admin;
import com.example.BeTheFutureBackend.Admin.AdminModel;
import com.example.BeTheFutureBackend.Customers.CustomerModel;
import com.example.BeTheFutureBackend.Customers.Customers;
import com.example.BeTheFutureBackend.Employee.Employee;
import com.example.BeTheFutureBackend.Employee.EmployeeModel;
import com.example.BeTheFutureBackend.Manager.Manager;
import com.example.BeTheFutureBackend.Manager.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserServices {
    //Create an Object form admin model, Customer model, Employee model, Manager model
    AdminModel adminModel;
    CustomerModel customerModel;
    EmployeeModel employeeModel;
    ManagerModel managerModel;

    //Create a constructor to initialize the objects
    @Autowired
    public UserServices(AdminModel adminModel, CustomerModel customerModel, EmployeeModel employeeModel, ManagerModel managerModel) {
        this.adminModel = adminModel;
        this.customerModel = customerModel;
        this.employeeModel = employeeModel;
        this.managerModel = managerModel;
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> logIn(@RequestBody User user) {
        if (user.getRole().equalsIgnoreCase("admin")) {
            return adminModel.login(user.getUserName(), user.getPassword());
        } else if (user.getRole().equalsIgnoreCase("customer")) {
            return customerModel.login(user.getUserName(), user.getPassword());
        } else if (user.getRole().equalsIgnoreCase("employee")) {
            return employeeModel.login(user.getUserName(), user.getPassword());
        } else if (user.getRole().equalsIgnoreCase("manager")) {
            return managerModel.login(user.getUserName(), user.getPassword());
        } else {
            return ResponseEntity.badRequest().body("User Type is not valid");
        }
    }
    
    @PostMapping(path = "register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getRole().equalsIgnoreCase("admin")) {
            Admin admin = new Admin(user.getUserName(), user.getPassword());
            return adminModel.register(admin);
        } else if (user.getRole().equalsIgnoreCase("customer")) {
            Customers customer = new Customers(user.getUserName(), user.getFullName(), user.getEmail(), user.getPassword()
                    , user.getPhoneNumber(), user.getAddress(), user.getCity(), user.getPhoto());
            return customerModel.register(customer);
        } else if (user.getRole().equalsIgnoreCase("employee")) {
            Employee employee = new Employee(user.getUserName(), user.getFullName(), user.getEmail(), user.getPassword(),
                    user.getPhoneNumber());
            return employeeModel.register(employee);
        } else if (user.getRole().equalsIgnoreCase("manager")) {
            Manager manager = new Manager(user.getUserName(), user.getFullName(), user.getEmail(), user.getPassword(),
                    user.getPhoneNumber());
            return managerModel.register(manager);
        } else {
            return ResponseEntity.badRequest().body("User Type is not valid");
        }
    }

}
