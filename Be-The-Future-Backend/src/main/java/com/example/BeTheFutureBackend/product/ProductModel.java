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
            product.setState("Pending");
            User customer1 = customer.get();
            customer1.addProduct(product);
            product.setCustomer(customer1);
            customerRepository.save(customer1);
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
    //update product state to inprogress
    public Product updateProductState(Long id) {
        Product product = productRepository.findById(id).get();
        product.setState("InProgress");
        return productRepository.save(product);
    }

    public Product updateProductStatus(Long id) {
        Product product = productRepository.findById(id).get();
        if (product.getState().equals("in progress")) {
            product.setState("done");
        } else {
            product.setState("in progress");
        }
        return productRepository.save(product);
    }
}
