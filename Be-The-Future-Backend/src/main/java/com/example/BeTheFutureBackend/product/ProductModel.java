package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductModel {
    private final UserRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductModel(UserRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    // add proudct by customer
    public Boolean addProductByCustomerName(String customerName, Product product) {
        Optional<User> customer = customerRepository.findById(customerName);
        if (customer == null) {
            return false;
        } else {
            User customer1 = customer.get();
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
        User customer = customerRepository.findByUsername(customerName).get();
        return productRepository.findAllByCustomer(customer);
    }


}
