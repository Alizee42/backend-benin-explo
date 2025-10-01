package com.benin.explo.repository;

import com.benin.explo.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {
    // Tu peux ajouter des méthodes custom si besoin, ex :
    // List<Circuit> findByCategorie(String categorie);
}
