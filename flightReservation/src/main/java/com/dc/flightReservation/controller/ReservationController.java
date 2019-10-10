package com.dc.flightReservation.controller;

import com.dc.flightReservation.dao.FlightRespository;
import com.dc.flightReservation.dto.ReservationRequest;
import com.dc.flightReservation.entities.Flight;
import com.dc.flightReservation.entities.Reservation;
import com.dc.flightReservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRespository flightRespository;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showReservations(@RequestParam("flightId") Long id, ModelMap modelMap){
        Flight flight = flightRespository.findById(id).get();
        modelMap.addAttribute("flight",flight);
        return "completeReservation";
    }

    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest reservationRquest,ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(reservationRquest);
        modelMap.addAttribute("msg","Reservation created successfully and the id is "+reservation.getId());
        return "reservationConfirmation";
    }
}
