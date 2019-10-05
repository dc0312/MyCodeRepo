package com.dc.flightcheckin.integration;

import com.dc.flightcheckin.dto.Reservation;
import com.dc.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest reservationUpdateRequest);
}
