package com.example.BeTheFutureBackend.Customers;

import org.springframework.stereotype.Service;

@Service
public class CustomerModel {
    private final CustomerRepository customerRepository;

    public CustomerModel(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customers addCustomer(Customers customers) {
        if (customerRepository.findById(customers.getCustomerName()).isPresent()) {
            throw new IllegalStateException("Customer already exists");
        }
        return customerRepository.save(customers);
    }

    public void deleteCustomer(String customerName) {
        if (!customerRepository.findById(customerName).isPresent()) {
            throw new IllegalStateException("Customer does not exist");
        }
        customerRepository.deleteById(customerName);
    }

    public Customers updateCustomer(Customers customers) {
        if (!customerRepository.findById(customers.getCustomerName()).isPresent()) {
            throw new IllegalStateException("Customer does not exist");
        }
        Customers customers1 = customerRepository.findById(customers.getCustomerName()).get();
        customers1.setCustomerName(customers.getCustomerName());
        customers1.setCustomerPassword(customers.getCustomerPassword());
        customers1.setCustomerEmail(customers.getCustomerEmail());
        customers1.setCustomerPhoneNum(customers.getCustomerPhoneNum());
        customers1.setCustomerAddress(customers.getCustomerAddress());
        customers1.setCustomerCity(customers.getCustomerCity());
        customers1.setCustomerPhoto(customers.getCustomerPhoto());
        customers1.setCustomerFullName(customers.getCustomerFullName());
        return customerRepository.save(customers1);

    }

    public Customers getCustomer(String customerName) {
        return customerRepository.findById(customerName).get();
    }

    public Iterable<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String register(Customers customers) {
        if (customerRepository.existsById(customers.getCustomerName())) {
            return ("Customer already exists");
        }
        customerRepository.save(customers);
        return ("Customer added successfully");
    }

    public Customers login(Customers customers) {
        if (!customerRepository.findById(customers.getCustomerName()).isPresent()) {
            throw new IllegalStateException("Customer does not exist");
        }
        Customers customers1 = customerRepository.findById(customers.getCustomerName()).get();
        if (!customers1.getCustomerPassword().equals(customers.getCustomerPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        return customers1;
    }


}
