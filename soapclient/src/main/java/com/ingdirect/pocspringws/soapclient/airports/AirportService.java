package com.ingdirect.pocspringws.soapclient.airports;

import airport.wsdl.GetAirportInformationByAirportCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by josete on 3/6/17.
 */
@Service
public class AirportService {

    private SoapClient soapClient;

    @Autowired
    public AirportService(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    public Airport findAirportByCode(String code) {

        GetAirportInformationByAirportCodeResponse response = this.soapClient.getAirportInformationByAirportCode(code);
        return  new Airport(code, response.getGetAirportInformationByAirportCodeResult(), response.getGetAirportInformationByAirportCodeResult());

    }

}
