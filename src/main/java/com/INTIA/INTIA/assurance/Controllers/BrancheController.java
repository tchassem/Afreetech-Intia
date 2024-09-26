package com.INTIA.INTIA.assurance.Controllers;

import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Entities.Branche;
import com.INTIA.INTIA.assurance.Services.BrancheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/branches")
public class BrancheController {
    private final BrancheService brancheService;

    @GetMapping("/")
    public List<Branche> getAllBranche() {
        return brancheService.findAllBranche();
    }

    @GetMapping("/{id}")
    public Branche getBrancheById(@PathVariable Long id) {
        return brancheService.findBrancheById(id);
    }

    @PostMapping
    public Branche createBranche(@RequestBody Branche branche) {
        return brancheService.saveBranche(branche);
    }

    @PutMapping("/{id}")
    public Branche updateBranche(@PathVariable Long id, @RequestBody Branche branche) {
        Branche existingBranche = brancheService.findBrancheById(id);
        existingBranche.setNom(branche.getNom());
        existingBranche.setClients(branche.getClients());
        existingBranche.setLocalisation(branche.getLocalisation());

        return brancheService.saveBranche(existingBranche);
    }

    @DeleteMapping("/{id}")
    public void deleteAssurance(@PathVariable Long id) {
        brancheService.deleteBranche(id);
    }
}
