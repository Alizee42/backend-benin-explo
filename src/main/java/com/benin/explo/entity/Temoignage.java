package com.benin.explo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "temoignage")
public class Temoignage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentaire;

    @Column(nullable = false)
    private int note; // 1 à 5 étoiles

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuit circuit; // Optionnel : un avis peut concerner un circuit

    // Constructeurs
    public Temoignage() {}

    public Temoignage(Long id, String commentaire, int note, LocalDate date, Utilisateur utilisateur, Circuit circuit) {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
        this.date = date;
        this.utilisateur = utilisateur;
        this.circuit = circuit;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Circuit getCircuit() { return circuit; }
    public void setCircuit(Circuit circuit) { this.circuit = circuit; }

    // toString
    @Override
    public String toString() {
        return "Temoignage{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", date=" + date +
                ", utilisateur=" + (utilisateur != null ? utilisateur.getNom() : "null") +
                ", circuit=" + (circuit != null ? circuit.getTitre() : "null") +
                '}';
    }
}
