package com.dc.flightReservation.dao;

import com.dc.flightReservation.entities.Passenger;
import com.dc.flightReservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRespository extends JpaRepository<Reservation,Long> {
}
