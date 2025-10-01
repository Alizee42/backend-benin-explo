package com.benin.explo.controller;

import com.benin.explo.entity.Temoignage;
import com.benin.explo.service.TemoignageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temoignages")
@CrossOrigin(origins = "*")
public class TemoignageController {

    private final TemoignageService temoignageService;

    public TemoignageController(TemoignageService temoignageService) {
        this.temoignageService = temoignageService;
    }

    @GetMapping
    public List<Temoignage> getAllTemoignages() {
        return temoignageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temoignage> getTemoignageById(@PathVariable Long id) {
        return temoignageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Temoignage createTemoignage(@RequestBody Temoignage temoignage) {
        return temoignageService.save(temoignage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Temoignage> updateTemoignage(@PathVariable Long id, @RequestBody Temoignage temoignageDetails) {
        return temoignageService.findById(id)
                .map(temoignage -> {
                    temoignage.setCommentaire(temoignageDetails.getCommentaire());
                    temoignage.setNote(temoignageDetails.getNote());
                    temoignage.setDate(temoignageDetails.getDate());
                    temoignage.setUtilisateur(temoignageDetails.getUtilisateur());
                    temoignage.setCircuit(temoignageDetails.getCircuit());
                    return ResponseEntity.ok(temoignageService.save(temoignage));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemoignage(@PathVariable Long id) {
        if (temoignageService.findById(id).isPresent()) {
            temoignageService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

