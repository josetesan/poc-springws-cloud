package com.ingdirect.pocspringws.soapclient.airports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;


/**
 * Created by josete on 3/6/17.
 */
@Configuration
public class AirportConfiguration {


    @Bean
    public WebServiceMessageFactory webServiceMessageFactory() {
        SaajSoapMessageFactory soapMessageFactory = new SaajSoapMessageFactory();
        soapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return soapMessageFactory;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.webservicex.wsdl.airport");
        return marshaller;
    }

    @Bean
    public SoapClient soapClient() throws Exception{
        SoapClient client = new SoapClient();
        client.setMessageFactory(webServiceMessageFactory());
        client.setDefaultUri("http://www.webservicex.com/airport.asmx");
        client.setMarshaller(marshaller());
        client.setUnmarshaller(marshaller());
        return client;
    }

}
