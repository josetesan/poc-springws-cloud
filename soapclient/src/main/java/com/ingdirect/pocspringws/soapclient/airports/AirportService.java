package com.ingdirect.pocspringws.soapclient.airports;

import com.webservicex.wsdl.airport.GetAirportInformationByAirportCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlbeam.XBProjector;

/**
 * Created by josete on 3/6/17.
 */
@Service
public class AirportService {

    private SoapClient soapClient;
    private XBProjector xbProjector;

    private static final Logger LOGGER = LoggerFactory.getLogger(AirportService.class);

    @Autowired
    public AirportService(SoapClient soapClient) {
        this.soapClient = soapClient;
        this.xbProjector = new XBProjector(XBProjector.Flags.TO_STRING_RENDERS_XML);
    }

    public Airport findAirportByCode(String code) {

        GetAirportInformationByAirportCodeResponse response = this.soapClient.getAirportInformationByAirportCode(code);
        return  parseSoapResponse(code,response.getGetAirportInformationByAirportCodeResult());
    }


    private Airport parseSoapResponse(String code, String response) {

        LOGGER.info("Parsing response {}", response);
        AirportInformation airportInformation =
                this.xbProjector.onXMLString(response).createProjection(AirportInformation.class);

        Airport airport = new Airport(code, airportInformation.cityOrAirportName(), airportInformation.country());

        LOGGER.info("Found airport information for code {} : {}", code, airport);

        return airport;

    }

}
