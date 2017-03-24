package net.wozi.spring.tutorial.bootsoaprequest.client;

import hello.wsdl.GetQuote;
import hello.wsdl.GetQuoteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created on 2/4/2017.
 */

public class QuoteClient extends WebServiceGatewaySupport{
    private static final Logger logger = LoggerFactory.getLogger(QuoteClient.class);
    private String svcEndPoint = "http://www.webservicex.com/stockquote.asmx";
    private String svcCallback = "http://www.webserviceX.NET/GetQuote";

    public GetQuoteResponse getQuote(String ticker){
        GetQuote request = new GetQuote();
        request.setSymbol(ticker);

        logger.info("Reqesting quote for " + ticker);

        GetQuoteResponse response = (GetQuoteResponse)getWebServiceTemplate()
                        .marshalSendAndReceive(svcEndPoint, request, new SoapActionCallback(svcCallback));

        return response;
    }
}
