package com.benin.explo.service;

import com.benin.explo.entity.Temoignage;
import com.benin.explo.repository.TemoignageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemoignageService {

    private final TemoignageRepository temoignageRepository;

    public TemoignageService(TemoignageRepository temoignageRepository) {
        this.temoignageRepository = temoignageRepository;
    }

    public List<Temoignage> findAll() {
        return temoignageRepository.findAll();
    }

    public Optional<Temoignage> findById(Long id) {
        return temoignageRepository.findById(id);
    }

    public Temoignage save(Temoignage temoignage) {
        return temoignageRepository.save(temoignage);
    }

    public void delete(Long id) {
        temoignageRepository.deleteById(id);
    }
}
