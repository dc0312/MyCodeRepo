package com.dc.flightReservation.controller;

import com.dc.flightReservation.dao.ReservationRespository;
import com.dc.flightReservation.dto.ReservationUpdateRequest;
import com.dc.flightReservation.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    private ReservationRespository reservationRespository;

    @GetMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        return reservationRespository.findById(id).get();
    }

    @PostMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest){
        Reservation reservation = reservationRespository.findById(reservationUpdateRequest.getId()).get();
        reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
        reservation.setCheckedIn(reservationUpdateRequest.isCheckedIn());

        return reservationRespository.save(reservation);
    }
}
