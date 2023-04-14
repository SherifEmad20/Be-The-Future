package com.example.BeTheFutureBackend.Customers;

import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerModel {
    private final UserRepository customerRepository;

    public CustomerModel(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }





    public Iterable<User> getAllCustomers() {
         Iterable<User> users=customerRepository.findAll();
          //retur onle users with role admin
          ArrayList<User> customers=new ArrayList<>();
          for (User user:users) {
                if(user.getRole().equals(Role.ROLE_CUSTOMER)){
                 customers.add(user);
                }
          }

          return customers;
    }


}
