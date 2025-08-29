package com.gusrubin.legacysoap.legacysoap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Gustavo Rubin
 */
@Endpoint
public class LocalidadeEndpoint {

  private static final String NAMESPACE_URI = "http://example.com/localidade";

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocalidadeRequest")
  @ResponsePayload
  public GetLocalidadeResponse getLocalidade(@RequestPayload GetLocalidadeRequest request) {
    GetLocalidadeResponse response = new GetLocalidadeResponse();
    response.setCidade("Campinas");
    response.setEstado("SP");
    response.setPais("Brasil");
    return response;
  }
}
