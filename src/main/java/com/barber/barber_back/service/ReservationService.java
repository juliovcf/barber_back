package com.barber.barber_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.barber_back.model.Client;
import com.barber.barber_back.model.Reservation;
import com.barber.barber_back.model.ReservationStatus;
import com.barber.barber_back.repository.ClientRepository;
import com.barber.barber_back.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;

    public Reservation create(Reservation reserva) {
        if (reserva.getClient() == null || reserva.getClient().getId() == null) {
            throw new RuntimeException("Debe especificar un client existente para crear la reserva.");
        }
        // Verificar que el client existe
        Client client = clientRepository.findById(reserva.getClient().getId())
                .orElseThrow(() -> new RuntimeException("client no encontrado"));
        
        reserva.setClient(client);
        reserva.setStatus(ReservationStatus.CONFIRMED);
        
        return reservationRepository.save(reserva);
    }

    public Reservation update(Long id, Reservation nuevosDatos) {
        Reservation existente = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (nuevosDatos.getData() != null) {
            existente.setData(nuevosDatos.getData());
        }
        if (nuevosDatos.getBarberTreatment() != null) {
            existente.setBarberTreatment(nuevosDatos.getBarberTreatment());
        }

        // Si se quiere modificar el client de la reserva
        if (nuevosDatos.getClient() != null && nuevosDatos.getClient().getId() != null) {
            Client client = clientRepository.findById(nuevosDatos.getClient().getId())
                    .orElseThrow(() -> new RuntimeException("client no encontrado"));
            existente.setClient(client);
        }

        return reservationRepository.save(existente);
    }

    public void cancel(Long id) {
        Reservation existente = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        existente.setStatus(ReservationStatus.CANCELED);
        reservationRepository.save(existente);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    // Nuevo método para listar por el ID del client
    public List<Reservation> getAllById(Long clientId) {
        return reservationRepository.findByclient_Id(clientId);
    }

    public List<Reservation> getActiveReservationsByClient(Long clientId) {
        List<ReservationStatus> activeStatuses = List.of(ReservationStatus.PENDING, ReservationStatus.CONFIRMED);
        return reservationRepository.findByclient_IdAndStatusIn(clientId, activeStatuses);
    }
}
