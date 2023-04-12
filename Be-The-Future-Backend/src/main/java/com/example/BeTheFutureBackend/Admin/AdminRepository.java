package com.example.BeTheFutureBackend.Admin;

import com.example.BeTheFutureBackend.Manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository
        extends JpaRepository <Admin , String> {

}
