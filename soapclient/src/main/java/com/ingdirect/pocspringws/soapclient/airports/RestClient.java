package com.ingdirect.pocspringws.soapclient.airports;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by josete on 3/6/17.
 */
@RestController
@RequestMapping("/v1.0/airport")
public class RestClient {


    private AirportService airportService;

    public RestClient(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Airport findAirportById(@PathVariable("id") String id) {

        return this.airportService.findAirportByCode(id);

    }
}
