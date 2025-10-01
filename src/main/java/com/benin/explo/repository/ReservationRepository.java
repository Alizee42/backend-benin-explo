package com.benin.explo.repository;

import com.benin.explo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Exemple : rechercher toutes les réservations d’un utilisateur
    // List<Reservation> findByUtilisateurId(Long utilisateurId);
}
