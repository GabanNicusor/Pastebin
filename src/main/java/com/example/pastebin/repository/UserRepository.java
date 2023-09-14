package com.example.pastebin.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastebin.entities.UserData;


public interface UserRepository extends JpaRepository<UserData, Integer> {
   Optional<UserData> findByUsernameAndPassword(String Username, String Password);
   UserData findByUsername(String Username);
}