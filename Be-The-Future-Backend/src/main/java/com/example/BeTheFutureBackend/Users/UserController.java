package com.example.BeTheFutureBackend.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserModel userModel;
    //method to delete user by username
    //method to update user by username
    //method to get user by username
    //method to get all users
    @DeleteMapping(path = "/delete/{username}")
    public void deleteUser(@PathVariable("username") String username){
        userModel.deleteUser(username);
    }
    @PutMapping(path = "/update")
    public User updateUser(@RequestBody User user){
        return userModel.updateUser(user);
    }
    @GetMapping(path = "/get/{username}")
    public User getUser(@PathVariable("username") String username){
        return userModel.getUserById(username);
    }
    @GetMapping(path = "/getAll")
    public Iterable<User> getAllUsers(){
        return userModel.getAllUsers();
    }


}
