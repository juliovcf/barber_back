package com.barber.barber_back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.barber_back.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    
}
