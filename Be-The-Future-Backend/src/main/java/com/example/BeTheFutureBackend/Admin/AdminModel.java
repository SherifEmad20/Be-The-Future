package com.example.BeTheFutureBackend.Admin;

import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class AdminModel {
    UserRepository adminRepository;
    @Autowired
    public AdminModel(UserRepository  adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Iterable<User> getAllAdmins( ){
        Iterable<User> users=adminRepository.findAll();
        //retur onle users with role admin
        ArrayList<User> admins=new ArrayList<>();
        for (User user:users) {
            if(user.getRole().equals((Role.ROLE_ADMIN))){
                admins.add(user);
            }
        }

        return admins;
    }


}
