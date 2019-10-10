package com.dc.flightReservation.services;

import com.dc.flightReservation.dao.FlightRespository;
import com.dc.flightReservation.dao.PassengerRespository;
import com.dc.flightReservation.dao.ReservationRespository;
import com.dc.flightReservation.dto.ReservationRequest;
import com.dc.flightReservation.entities.Flight;
import com.dc.flightReservation.entities.Passenger;
import com.dc.flightReservation.entities.Reservation;
import com.dc.flightReservation.utilities.EmailUtil;
import com.dc.flightReservation.utilities.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Value("${com.dc.flightreservation.flightpath}")
    public  String FILE_PATH;
    @Autowired
    private FlightRespository flightRespository;

    @Autowired
    private PassengerRespository passengerRespository;

    @Autowired
    private ReservationRespository reservationRespository;

    @Autowired
    private PDFGenerator pdfGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        //make payment

        Long flightId = request.getFlightId();
        Flight flight = flightRespository.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger = passengerRespository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRespository.save(reservation);

        String filePath = FILE_PATH +savedReservation.getId()+".pdf";
        pdfGenerator.generateItenary(savedReservation,filePath);
        emailUtil.sendItinerary(passenger.getEmail(),filePath);

        return savedReservation;
    }
}
