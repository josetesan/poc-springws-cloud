package com.ingdirect.pocspringws.soapclient.airports;

import org.xmlbeam.annotation.XBRead;

/**
 * Created by josetesan on 4/06/17.
 */
public interface AirportInformation {

    @XBRead("/NewDataSet/Table/CityOrAirportName")
    String cityOrAirportName();

    @XBRead("/NewDataSet/Table/Country")
    String country();


}
