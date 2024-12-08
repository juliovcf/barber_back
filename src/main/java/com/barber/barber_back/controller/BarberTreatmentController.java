package com.barber.barber_back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.barber_back.model.BarberTreatment;
import com.barber.barber_back.service.BarberTreatmentService;

@RestController
@RequestMapping("/barber-treatments")
public class BarberTreatmentController {

    private final BarberTreatmentService barberTreatmentService;

    public BarberTreatmentController(BarberTreatmentService barberTreatmentService) {
        this.barberTreatmentService = barberTreatmentService;
    }

    @PostMapping
    public ResponseEntity<BarberTreatment> createBarberTreatment(@RequestBody BarberTreatment barberTreatment) {
        return ResponseEntity.ok(barberTreatmentService.create(barberTreatment));
    }

    @GetMapping
    public ResponseEntity<List<BarberTreatment>> getAllBarberTreatments() {
        return ResponseEntity.ok(barberTreatmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberTreatment> getBarberTreatmentById(@PathVariable Long id) {
        return ResponseEntity.ok(barberTreatmentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberTreatment> updateBarberTreatment(@PathVariable Long id, @RequestBody BarberTreatment barberTreatment) {
        return ResponseEntity.ok(barberTreatmentService.update(id, barberTreatment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarberTreatment(@PathVariable Long id) {
        barberTreatmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
