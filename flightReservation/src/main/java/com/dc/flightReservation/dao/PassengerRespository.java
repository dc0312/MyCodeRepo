package com.dc.flightReservation.dao;

import com.dc.flightReservation.entities.Flight;
import com.dc.flightReservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRespository extends JpaRepository<Passenger,Long> {
}
