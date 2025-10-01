package com.benin.explo.controller;

import com.benin.explo.entity.Reservation;
import com.benin.explo.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        return reservationService.findById(id)
                .map(reservation -> {
                    reservation.setNomClient(reservationDetails.getNomClient());
                    reservation.setEmailClient(reservationDetails.getEmailClient());
                    reservation.setDateReservation(reservationDetails.getDateReservation());
                    reservation.setStatut(reservationDetails.getStatut());
                    reservation.setCircuit(reservationDetails.getCircuit());
                    reservation.setUtilisateur(reservationDetails.getUtilisateur());
                    return ResponseEntity.ok(reservationService.save(reservation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationService.findById(id).isPresent()) {
            reservationService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

