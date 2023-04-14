package com.example.BeTheFutureBackend.Admin;

import com.example.BeTheFutureBackend.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    AdminModel adminModel;

    @Autowired
    public AdminController(AdminModel adminModel) {
        this.adminModel = adminModel;
    }


    @GetMapping(path = "getAllAdmins")
    public Iterable<User> getAllAdmins() {
        return adminModel.getAllAdmins();
    }
}
