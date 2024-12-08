package com.barber.barber_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barber.barber_back.model.BarberTreatment;

@Repository
public interface BarberTreatmentRepository extends JpaRepository <BarberTreatment, Long> {
    
}
