package com.example.BeTheFutureBackend.Customers;

import com.example.BeTheFutureBackend.Employee.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerModel {
    private final CustomerRepository customerRepository;

    public CustomerModel(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customers addCustomer(Customers customers) {
        if (customerRepository.existsById(customers.getUsername())) {
            throw new IllegalStateException("Customer already exists");
        }
        return customerRepository.save(customers);
    }

    public void deleteCustomer(String customerName) {
        if (customerRepository.existsById(customerName)) {
            throw new IllegalStateException("Customer does not exist");
        }
        customerRepository.deleteById(customerName);
    }

    public Customers updateCustomer(Customers customer) {
        if (customerRepository.existsById(customer.getUsername())) {
            throw new IllegalStateException("Customer does not exist");
        }
        return customerRepository.save(customer);

    }

    public Customers getCustomer(String customerName) {
        return customerRepository.findById(customerName).get();
    }

    public Iterable<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public ResponseEntity<?> register(Customers customers) {
        if (customerRepository.existsById(customers.getUsername())) {
            throw new IllegalStateException("Customer already exists");
        }
        return ResponseEntity.ok(customerRepository.save(customers));
    }

    public ResponseEntity<?> login(Customers customer) {
        if (customerRepository.existsById(customer.getUsername()) ||
                customerRepository.existsById(customer.getEmail())) {
            Customers customer1 = customerRepository.findById(customer.getUsername()).get();
            if (customer1.getPassword().equals(customer.getPassword())) {
                return ResponseEntity.ok(customer1);
                //return true;
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
        //return false;
        //return false;
    }
    //log in using username and password
    public ResponseEntity<?> login(String username, String password) {
        if (customerRepository.existsById(username)) {
            Customers customer1 = customerRepository.findById(username ).get();
            if (customer1.getPassword().equals(password)) {
                return ResponseEntity.ok(customer1);
                //return true;
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
        //return false;
        //return false;
    }


}
