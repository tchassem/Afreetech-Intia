package com.INTIA.INTIA.assurance.Services;

import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Repository.AssuranceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssuranceService {

    private final AssuranceRepo assuranceRepository;

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
}
