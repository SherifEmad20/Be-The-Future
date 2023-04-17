package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //get all products by customer name

    Iterable<Product> findAllByCustomer(User customer);

    //get product by product name
    Optional<Product> findByProductName(String productName);
}
