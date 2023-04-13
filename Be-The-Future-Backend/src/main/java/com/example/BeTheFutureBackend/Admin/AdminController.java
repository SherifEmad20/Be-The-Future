package com.example.BeTheFutureBackend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Admin> getAllAdmins() {
        return adminModel.getAllAdmins();
    }
}
