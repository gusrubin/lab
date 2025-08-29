package com.gusrubin.systemhub.service;

import com.gusrubin.systemhub.client.legacysoap.GetLocalidadeResponse;
import com.gusrubin.systemhub.client.legacysoap.LegacySoapServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Gustavo Rubin
 */
@Service
@RequiredArgsConstructor
public class LocalidadeService {

  private final LegacySoapServiceClient legacySoapServiceClient;

  public LocalidadeResponseDto getLocalidadeByCidade(String cidade) {
    GetLocalidadeResponse response = legacySoapServiceClient.getLocalidade(cidade);
    return new LocalidadeResponseDto(
        response.getCidade(),
        response.getEstado(),
        response.getPais());
  }
}
