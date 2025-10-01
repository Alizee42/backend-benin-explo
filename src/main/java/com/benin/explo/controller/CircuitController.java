package com.benin.explo.controller;

import com.benin.explo.entity.Circuit;
import com.benin.explo.service.CircuitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/circuits")
@CrossOrigin(origins = "*")
public class CircuitController {

    private final CircuitService circuitService;

    public CircuitController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    @GetMapping
    public List<Circuit> getAllCircuits() {
        return circuitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable Long id) {
        return circuitService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Circuit createCircuit(@RequestBody Circuit circuit) {
        return circuitService.save(circuit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Circuit> updateCircuit(@PathVariable Long id, @RequestBody Circuit circuitDetails) {
        return circuitService.findById(id)
                .map(circuit -> {
                    circuit.setTitre(circuitDetails.getTitre());
                    circuit.setDescription(circuitDetails.getDescription());
                    circuit.setPrix(circuitDetails.getPrix());
                    circuit.setCategorie(circuitDetails.getCategorie());
                    circuit.setImageUrl(circuitDetails.getImageUrl());
                    return ResponseEntity.ok(circuitService.save(circuit));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCircuit(@PathVariable Long id) {
        if (circuitService.findById(id).isPresent()) {
            circuitService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

