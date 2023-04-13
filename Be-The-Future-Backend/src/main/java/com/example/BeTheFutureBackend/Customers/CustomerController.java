package com.example.BeTheFutureBackend.Customers;

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
    public Iterable<Customers> getAllCustomers() {
        return customerModel.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{id}")
    public Customers getCustomerById(@PathVariable("id") String CustomerName) {
        return customerModel.getCustomer(CustomerName);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") String CustomerName) {
        customerModel.deleteCustomer(CustomerName);
    }

    @PutMapping("/updateCustomer")
    public Customers updateCustomer(@RequestBody Customers customers) {
        return customerModel.updateCustomer(customers);
    }
}
