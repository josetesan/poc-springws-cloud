package com.ingdirect.pocspringws.frontend.services;

import com.ingdirect.pocspringws.frontend.controllers.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AirportSearchService {

    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(AirportSearchService.class);

    public AirportSearchService() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory());
    }

    public Optional<Airport> findbyCode(String code) {
        LOGGER.info("Searching for airport code {}", code);
        ResponseEntity<Airport> airport = this.restTemplate.getForEntity("http://localhost:8080/v1.0/airport/{code}",Airport.class, code);
        LOGGER.info("Found {}", airport.getBody());
        if (airport.getStatusCode().is2xxSuccessful()) {
            return Optional.of(airport.getBody());
        } else return Optional.empty();

    }

}
