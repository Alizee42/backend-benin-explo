package com.benin.explo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomClient;

    @Column(nullable = false, length = 100)
    private String emailClient;

    @Column(nullable = false)
    private LocalDate dateReservation;

    @Column(nullable = false, length = 50)
    private String statut; // En attente, Confirmée, Annulée

    @ManyToOne
    @JoinColumn(name = "circuit_id", nullable = false)
    private Circuit circuit;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Constructeurs
    public Reservation() {}

    public Reservation(Long id, String nomClient, String emailClient, LocalDate dateReservation, String statut, Circuit circuit, Utilisateur utilisateur) {
        this.id = id;
        this.nomClient = nomClient;
        this.emailClient = emailClient;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.circuit = circuit;
        this.utilisateur = utilisateur;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomClient() { return nomClient; }
    public void setNomClient(String nomClient) { this.nomClient = nomClient; }

    public String getEmailClient() { return emailClient; }
    public void setEmailClient(String emailClient) { this.emailClient = emailClient; }

    public LocalDate getDateReservation() { return dateReservation; }
    public void setDateReservation(LocalDate dateReservation) { this.dateReservation = dateReservation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Circuit getCircuit() { return circuit; }
    public void setCircuit(Circuit circuit) { this.circuit = circuit; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    // toString
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", nomClient='" + nomClient + '\'' +
                ", emailClient='" + emailClient + '\'' +
                ", dateReservation=" + dateReservation +
                ", statut='" + statut + '\'' +
                ", circuit=" + (circuit != null ? circuit.getTitre() : "null") +
                ", utilisateur=" + (utilisateur != null ? utilisateur.getNom() : "null") +
                '}';
    }
}
