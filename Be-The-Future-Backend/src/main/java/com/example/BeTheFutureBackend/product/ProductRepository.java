package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Customers.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //get all products by customer name

    Iterable<Product> findAllByCustomer(Customers customer);
}
