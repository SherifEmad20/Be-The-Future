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

    //sign in
    @PostMapping(path = "login")
    public ResponseEntity<?> logIn(@RequestBody Admin admin) {
        return adminModel.login(admin.getUserName(),admin.getPassword());
    }

    @PostMapping(path = "addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminModel.addAdmin(admin);
    }

    @GetMapping(path = "getAllAdmins")
    public Iterable<Admin> getAllAdmins() {
        return adminModel.getAllAdmins();
    }
}
