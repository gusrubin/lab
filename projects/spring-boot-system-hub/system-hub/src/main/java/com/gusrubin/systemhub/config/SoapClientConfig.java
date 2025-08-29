package com.gusrubin.systemhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Gustavo Rubin
 */
@Configuration
public class SoapClientConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // Pacote onde estão as classes geradas pelo JAXB a partir do XSD
    marshaller.setClassesToBeBound(
        com.gusrubin.systemhub.client.legacysoap.GetLocalidadeRequest.class,
        com.gusrubin.systemhub.client.legacysoap.GetLocalidadeResponse.class);
    return marshaller;
  }

  @Bean
  public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
    WebServiceTemplate template = new WebServiceTemplate();
    template.setMarshaller(marshaller);
    template.setUnmarshaller(marshaller);
    template.setDefaultUri("http://localhost:8082/ws"); // endpoint SOAP
    return template;
  }
}
