package com.example.BeTheFutureBackend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminModel {
    AdminRepository adminRepository;
    @Autowired
    public AdminModel(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    //Search for admin by email and password and return true if found
    public boolean login(String userName, String password){
        Admin admin = adminRepository.findById(userName).orElse(null);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    //add admin
    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    //get all admins
    public Iterable<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
    //get admin by id
    public Admin getAdminById(String id){
        return adminRepository.findById(id).orElse(null);
    }
    //update admin
    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }

}
