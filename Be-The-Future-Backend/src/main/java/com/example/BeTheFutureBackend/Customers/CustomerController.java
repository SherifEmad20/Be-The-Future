package com.example.BeTheFutureBackend.Customers;

import com.example.BeTheFutureBackend.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerModel customerModel;

    @Autowired
    public CustomerController(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @GetMapping("/getAllCustomers")
    public Iterable<User> getAllCustomers() {
        return customerModel.getAllCustomers();
    }

}
