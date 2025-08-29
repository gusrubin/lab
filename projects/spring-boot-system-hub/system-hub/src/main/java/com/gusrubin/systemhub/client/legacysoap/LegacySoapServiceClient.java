package com.gusrubin.systemhub.client.legacysoap;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Gustavo Rubin
 */
@Component
public class LegacySoapServiceClient {

  private final WebServiceTemplate webServiceTemplate;

  public LegacySoapServiceClient(WebServiceTemplate webServiceTemplate) {
    this.webServiceTemplate = webServiceTemplate;
  }

  public GetLocalidadeResponse getLocalidade(String nomeCidade) {
    GetLocalidadeRequest request = new GetLocalidadeRequest();
    request.setNomeCidade(nomeCidade);

    // Envia o request e retorna o response
    return (GetLocalidadeResponse) webServiceTemplate.marshalSendAndReceive(request);
  }
}
