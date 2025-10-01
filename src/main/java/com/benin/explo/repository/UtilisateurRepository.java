package com.benin.explo.repository;

import com.benin.explo.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Exemple : rechercher un utilisateur par email
    Optional<Utilisateur> findByEmail(String email);
}
