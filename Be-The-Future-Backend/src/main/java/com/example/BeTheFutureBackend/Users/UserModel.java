package com.example.BeTheFutureBackend.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModel {
    private final UserRepository userRepository;
    @Autowired
    public UserModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(User user){
        //find user
        User user1 = userRepository.findById(user.getUsername()).orElse(null);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setCity(user.getCity());
        user1.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user1);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
