package com.barber.barber_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barber.barber_back.model.Reservation;
import com.barber.barber_back.model.ReservationStatus;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByclient_Id(Long clientId);
    List<Reservation> findByclient_IdAndStatusIn(Long clientId, List<ReservationStatus> status);
}
