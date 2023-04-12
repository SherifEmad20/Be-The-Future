package com.example.BeTheFutureBackend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(path = "login")
    public boolean logIn(@RequestBody Admin admin) {
        return adminModel.login(admin.getUserName(),admin.getPassword());
    }

    @RequestMapping(path = "addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminModel.addAdmin(admin);
    }

    @RequestMapping(path = "getAllAdmins")
    public Iterable<Admin> getAllAdmins() {
        return adminModel.getAllAdmins();
    }
}
