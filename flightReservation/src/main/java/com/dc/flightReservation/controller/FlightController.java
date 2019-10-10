package com.dc.flightReservation.controller;

import com.dc.flightReservation.dao.FlightRespository;
import com.dc.flightReservation.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRespository flightRespository;

    @PostMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate,
                              ModelMap modelMap){
        List<Flight> flights = flightRespository.findFlights(from,to,departureDate);
        modelMap.addAttribute("flights",flights);
        return "displayFlights";
    }

    @GetMapping("/admin/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }


}
