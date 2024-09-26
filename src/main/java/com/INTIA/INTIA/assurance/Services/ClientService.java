package com.INTIA.INTIA.assurance.Services;

import ch.qos.logback.core.net.server.Client;
import com.INTIA.INTIA.assurance.Entities.Client_;
import com.INTIA.INTIA.assurance.Repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepo clientRepository;

    public List<Client_> findAllClients() {
        return clientRepository.findAll();
    }

    public Client_ findClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client_ saveClient(Client_ client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
