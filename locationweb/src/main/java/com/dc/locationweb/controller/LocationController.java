package com.dc.locationweb.controller;

import com.dc.locationweb.dao.entities.Location;
import com.dc.locationweb.services.LocationService;
import com.dc.locationweb.util.EMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private EMailUtil eMailUtil;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved for id -> "+locationSaved.getId();
        modelMap.addAttribute("msg",msg);
        eMailUtil.sendEmail("test03121992xyz@gmail.com","Location Saved",
                msg);
        return "createLocation";
    }

    @GetMapping("/displayLocations")
    public String displayLocation(ModelMap modelMap){
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations",locations);
        return "displayLocations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap){
        Location location = locationService.getLocationById(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations",locations);
        return "displayLocations";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id,ModelMap modelMap){
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location",location);
        return "updateLocation";
    }

    @PostMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap){
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations",locations);
        return "displayLocations";
    }
}
