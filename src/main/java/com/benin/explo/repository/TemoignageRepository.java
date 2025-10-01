package com.benin.explo.repository;

import com.benin.explo.entity.Temoignage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemoignageRepository extends JpaRepository<Temoignage, Long> {
    // Exemple : récupérer les témoignages liés à un circuit
    // List<Temoignage> findByCircuitId(Long circuitId);
}
