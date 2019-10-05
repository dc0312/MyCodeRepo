package com.dc.flightcheckin.controller;

import com.dc.flightcheckin.dto.Reservation;
import com.dc.flightcheckin.dto.ReservationUpdateRequest;
import com.dc.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    private ReservationRestClient restClient;

    @GetMapping("/showStartCheckin")
    public String showStartCheckin(){
        return "startCheckIn";
    }

    @PostMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation",reservation);
        return "displayReservationDetails";
    }

    @PostMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId, @RequestParam("numberOfBags") int numberOfBags){
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);

        restClient.updateReservation(reservationUpdateRequest);

        return "checkInConfirmation";
    }
}
