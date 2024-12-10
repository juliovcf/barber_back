package com.barber.barber_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.barber_back.model.BarberTreatment;
import com.barber.barber_back.model.Client;
import com.barber.barber_back.model.Reservation;
import com.barber.barber_back.model.ReservationStatus;
import com.barber.barber_back.repository.BarberTreatmentRepository;
import com.barber.barber_back.repository.ClientRepository;
import com.barber.barber_back.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final BarberTreatmentRepository barberTreatmentRepository;

    public Reservation create(Reservation reservation) {
        // Verificar si el cliente existe
        Client client = clientRepository.findById(reservation.getClient().getId())
                .orElseGet(() -> {
                    // Crear el cliente automáticamente si no existe
                    Client newClient = reservation.getClient();
                    return clientRepository.save(newClient);
                });

        // Verificar si el tratamiento existe
        BarberTreatment barberTreatment = barberTreatmentRepository.findById(reservation.getBarberTreatment().getId())
                .orElseThrow(() -> new RuntimeException("BarberTreatment not found"));

        // Asociar el cliente y el tratamiento a la reserva
        reservation.setClient(client);
        reservation.setBarberTreatment(barberTreatment);

        // Guardar la reserva
        return reservationRepository.save(reservation);
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
