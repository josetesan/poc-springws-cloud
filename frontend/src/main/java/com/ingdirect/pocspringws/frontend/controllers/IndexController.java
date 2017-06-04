package com.ingdirect.pocspringws.frontend.controllers;

import com.ingdirect.pocspringws.frontend.services.AirportSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller

public class IndexController {


    private AirportSearchService airportSearchService;

    public IndexController(AirportSearchService airportSearchService) {
        this.airportSearchService = airportSearchService;
    }


    @ModelAttribute("airports")
    public List<Airport> populateTypes() {
        return Arrays.asList(new Airport("Madrid","MAD"), new Airport("New York", "JFK"));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String index(Airport airport) {
        return "index";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/airportSearch")
    public ModelAndView findAirport(String code) {

        ModelAndView mav = new ModelAndView("airports");
        mav.addObject("airport", this.airportSearchService.findbyCode(code));
        return mav;

    }
}
