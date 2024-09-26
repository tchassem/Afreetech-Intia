package com.INTIA.INTIA.assurance.Services;

import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Entities.Branche;
import com.INTIA.INTIA.assurance.Repository.BrancheRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrancheService {

    private final BrancheRepo brancheRepository;

    public List<Branche> findAllBranche() {
        return brancheRepository.findAll();
    }

    public Branche findBrancheById(Long id) {
        return brancheRepository.findById(id).orElseThrow(() -> new RuntimeException("Assurance not found"));
    }

    public Branche saveBranche(Branche branche) {
        return brancheRepository.save(branche);
    }

    public void deleteBranche(Long id) {
        brancheRepository.deleteById(id);
    }
}
