package com.barber.barber_back.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.barber_back.model.User;
import com.barber.barber_back.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
