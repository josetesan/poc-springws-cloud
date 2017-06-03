package com.ingdirect.pocspringws.soapclient.airports;

import airport.wsdl.GetAirportInformationByAirportCode;
import airport.wsdl.GetAirportInformationByAirportCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * Created by josete on 3/6/17.
 */
@Component
public class SoapClient extends WebServiceGatewaySupport {


    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);


    public GetAirportInformationByAirportCodeResponse getAirportInformationByAirportCode(String code) {
        GetAirportInformationByAirportCode request = new GetAirportInformationByAirportCode();
        request.setAirportCode(code);

        LOGGER.info("Requesting airport code {}", code);
        GetAirportInformationByAirportCodeResponse response =
                (GetAirportInformationByAirportCodeResponse)getWebServiceTemplate().marshalSendAndReceive(request);

        LOGGER.info("Found airport code's {} name is {}", code, response.getGetAirportInformationByAirportCodeResult());
        return response;

    }

}
