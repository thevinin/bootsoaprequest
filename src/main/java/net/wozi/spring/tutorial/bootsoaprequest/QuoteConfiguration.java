package net.wozi.spring.tutorial.bootsoaprequest;

import net.wozi.spring.tutorial.bootsoaprequest.client.QuoteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created on 2/4/2017.
 */
@Configuration
public class QuoteConfiguration {
    private String svcURI = "http://www.webservicex.com/stockquote.asmx";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in the pom.xml
        marshaller.setContextPath("hello.wsdl");
        return marshaller;
    }

    @Bean
    public QuoteClient quoteClient(Jaxb2Marshaller marshaller){
        QuoteClient client = new QuoteClient();
        client.setDefaultUri(svcURI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
