package com.INTIA.INTIA.assurance.Services;

import ch.qos.logback.core.net.server.Client;
import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Entities.Client_;
import com.INTIA.INTIA.assurance.Repository.AssuranceRepo;
import com.INTIA.INTIA.assurance.Repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssuranceService {

    private final AssuranceRepo assuranceRepository;
    private final ClientRepo clientRepo;

    public List<Assurance> findAllAssurances() {
        return assuranceRepository.findAll();
    }

    public Assurance findAssuranceById(Long id) {
        return assuranceRepository.findById(id).orElseThrow(() -> new RuntimeException("Assurance not found"));
    }

    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }

    public void addAssuranceToclient(Long idassurance, Long idClient){
        Assurance assuranceToAdd = assuranceRepository.findById(idassurance).orElseThrow(
                ()->new RuntimeException("assurance by id" + idassurance+ " not found"));
        Client_ client = clientRepo.findById(idClient).orElseThrow(
                ()->new RuntimeException("client by id "+ idClient +"not found"));

        client.getAssuranceList().add(assuranceToAdd);
        clientRepo.save(client);
        assuranceToAdd.setClient(client);
        assuranceRepository.save(assuranceToAdd);

    }
}
