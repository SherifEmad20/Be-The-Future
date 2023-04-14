package com.example.BeTheFutureBackend.Users;

import com.example.BeTheFutureBackend.Role.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

    List<User> getUsers();

    Role getRole(String roleName);
}
