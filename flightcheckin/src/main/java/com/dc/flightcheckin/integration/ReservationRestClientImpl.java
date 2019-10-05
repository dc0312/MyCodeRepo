package com.dc.flightcheckin.integration;

import com.dc.flightcheckin.dto.Reservation;
import com.dc.flightcheckin.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id,Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest reservationUpdateRequest) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(RESERVATION_REST_URL,reservationUpdateRequest,Reservation.class);
        return null;
    }
}
