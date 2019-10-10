package com.dc.flightReservation.services;

import com.dc.flightReservation.dto.ReservationRequest;
import com.dc.flightReservation.entities.Reservation;

public interface ReservationService {

    Reservation bookFlight(ReservationRequest request);
}
