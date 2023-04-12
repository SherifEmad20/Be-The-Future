package com.example.BeTheFutureBackend.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository
        extends JpaRepository<Manager, String> {

    Manager findByEmail(String email);
    Manager findByPhone(String phone);

}
