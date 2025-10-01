package com.benin.explo.service;

import com.benin.explo.entity.Circuit;
import com.benin.explo.repository.CircuitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitService {

    private final CircuitRepository circuitRepository;

    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    public List<Circuit> findAll() {
        return circuitRepository.findAll();
    }

    public Optional<Circuit> findById(Long id) {
        return circuitRepository.findById(id);
    }

    public Circuit save(Circuit circuit) {
        return circuitRepository.save(circuit);
    }

    public void delete(Long id) {
        circuitRepository.deleteById(id);
    }
}
