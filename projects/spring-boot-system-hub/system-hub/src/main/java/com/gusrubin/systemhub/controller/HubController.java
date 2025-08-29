package com.gusrubin.systemhub.controller;

import com.gusrubin.systemhub.client.legacyrest.LegacyRestServiceClient;
import com.gusrubin.systemhub.client.legacyrest.UserResponseDto;
import com.gusrubin.systemhub.service.LocalidadeResponseDto;
import com.gusrubin.systemhub.service.LocalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Gustavo Rubin
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HubController {

  private final LegacyRestServiceClient legacyRestServiceClient;
  private final LocalidadeService localidadeService;

  @GetMapping("/users")
  public Flux<UserResponseDto> getAllUsers() {
    return legacyRestServiceClient.getUsers();
  }

  @GetMapping("/cidade/{cidade}")
  public LocalidadeResponseDto buscar(@PathVariable String cidade) {
    return localidadeService.getLocalidadeByCidade(cidade);
  }
}
