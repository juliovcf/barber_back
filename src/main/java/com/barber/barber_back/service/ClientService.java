package com.barber.barber_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.barber_back.model.Client;
import com.barber.barber_back.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client update(Long id, Client nuevosDatos) {
        Client existente = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("client no encontrado"));
        
        if (nuevosDatos.getName() != null) {
            existente.setName(nuevosDatos.getName());
        }
        if (nuevosDatos.getSurname() != null) {
            existente.setSurname(nuevosDatos.getSurname());
        }
        if (nuevosDatos.getPhone() != null) {
            existente.setPhone(nuevosDatos.getPhone());
        }
        if (nuevosDatos.getEmail() != null) {
            existente.setEmail(nuevosDatos.getEmail());
        }

        return clientRepository.save(existente);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
