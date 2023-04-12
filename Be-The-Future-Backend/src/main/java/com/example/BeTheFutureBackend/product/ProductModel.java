package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Customers.CustomerRepository;
import com.example.BeTheFutureBackend.Customers.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductModel {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductModel(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // add proudct by customer
    public Boolean addProductByCustomerName(String customerName, Product product) {
        Optional<Customers> customer = customerRepository.findById(customerName);
        if (customer == null) {
            return false;
        } else {
            Customers customer1 = customer.get();
            customer1.addProduct(product);
            customerRepository.save(customer1);
            product.setCustomer(customer1);
            productRepository.save(product);
            return true;
        }

    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Product product1 = productRepository.findById(product.getId()).get();
        product1.setProductName(product.getProductName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setPhoto(product.getPhoto());
        product1.setDeadline(product.getDeadline());
        return productRepository.save(product1);
    }

    public Iterable<Product> getProductBycustomerName(String customerName) {
        Customers customer = customerRepository.findById(customerName).get();
        return productRepository.findAllByCustomer(customer);
    }


}
