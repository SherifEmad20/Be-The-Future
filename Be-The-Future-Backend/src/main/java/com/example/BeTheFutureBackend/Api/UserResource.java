package com.example.BeTheFutureBackend.Api;


import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/api/v1/users/user/save").toUriString());
        return ResponseEntity.created(location).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/api/v1/users/role/save").toUriString());
        return ResponseEntity.created(location).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRole(@RequestBody RoleToUserForm roleToUserForm) {
        userService.addRoleToUser(roleToUserForm.getUserName(), roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}

