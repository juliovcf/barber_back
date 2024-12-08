package com.barber.barber_back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barber.barber_back.model.BarberTreatment;
import com.barber.barber_back.repository.BarberTreatmentRepository;

@Service
public class BarberTreatmentService {

    private final BarberTreatmentRepository barberTreatmentRepository;

    public BarberTreatmentService(BarberTreatmentRepository barberTreatmentRepository) {
        this.barberTreatmentRepository = barberTreatmentRepository;
    }

    public BarberTreatment create(BarberTreatment barberTreatment) {
        return barberTreatmentRepository.save(barberTreatment);
    }

    public List<BarberTreatment> getAll() {
        return barberTreatmentRepository.findAll();
    }

    public BarberTreatment getById(Long id) {
        return barberTreatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BarberTreatment not found"));
    }

    public BarberTreatment update(Long id, BarberTreatment updatedBarberTreatment) {
        BarberTreatment existingBarberTreatment = getById(id);
        existingBarberTreatment.setName(updatedBarberTreatment.getName());
        existingBarberTreatment.setDescription(updatedBarberTreatment.getDescription());
        existingBarberTreatment.setPrice(updatedBarberTreatment.getPrice());
        return barberTreatmentRepository.save(existingBarberTreatment);
    }

    public void delete(Long id) {
        barberTreatmentRepository.deleteById(id);
    }
}

