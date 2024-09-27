package com.INTIA.INTIA.assurance.Controllers;

import com.INTIA.INTIA.assurance.Entities.Assurance;
import com.INTIA.INTIA.assurance.Services.AssuranceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/assurances")
public class AssuranceController {
    private final AssuranceService assuranceService;

    @GetMapping
    public List<Assurance> getAllAssurances() {
        return assuranceService.findAllAssurances();
    }

    @GetMapping("/{id}")
    public Assurance getAssuranceById(@PathVariable Long id) {
        return assuranceService.findAssuranceById(id);
    }

    @PostMapping
    public Assurance createAssurance(@RequestBody Assurance assurance) {
        return assuranceService.saveAssurance(assurance);
    }

    @PutMapping("/{id}")
    public Assurance updateAssurance(@PathVariable Long id, @RequestBody Assurance assurance) {
        Assurance existingAssurance = assuranceService.findAssuranceById(id);
        existingAssurance.setTypeAssurance(assurance.getTypeAssurance());
        existingAssurance.setDateDebut(assurance.getDateDebut());
        existingAssurance.setMontant(assurance.getMontant());
        existingAssurance.setClient(assurance.getClient());
        existingAssurance.setDateFin(assurance.getDateFin());
        return assuranceService.saveAssurance(existingAssurance);
    }

    @DeleteMapping("/{id}")
    public void deleteAssurance(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
    }

    public ResponseEntity<?> addAssuranceToClient(@PathVariable Long idClient, @PathVariable Long idAssurance){
        assuranceService.addAssuranceToclient(idClient, idAssurance);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
