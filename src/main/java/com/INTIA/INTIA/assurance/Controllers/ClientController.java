package com.INTIA.INTIA.assurance.Controllers;

import ch.qos.logback.core.net.server.Client;
import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Entities.Client_;
import com.INTIA.INTIA.assurance.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    @GetMapping
    public List<Client_> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client_ getClientById(@PathVariable Long id) {
        return clientService.findClientById(id);
    }

    @PostMapping
    public Client_ createClient(@RequestBody Client_ client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public Client_ updateClient(@PathVariable Long id, @RequestBody Client_ client) {
        Client_ existingClient = clientService.findClientById(id);
        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setEmail(client.getEmail());
        existingClient.setAdresse(client.getAdresse());
        existingClient.setTelephone(client.getTelephone());
        return clientService.saveClient(existingClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/assurances")
    public ResponseEntity<List<Assurance>> getAssuranceOfClient(Client client){
        List<Assurance> assuranceListOfClient = clientService.assuranceOfClient(client);
        return new ResponseEntity<>(assuranceListOfClient, HttpStatus.OK);
    }
}
