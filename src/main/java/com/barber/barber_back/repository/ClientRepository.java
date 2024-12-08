package com.barber.barber_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barber.barber_back.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

