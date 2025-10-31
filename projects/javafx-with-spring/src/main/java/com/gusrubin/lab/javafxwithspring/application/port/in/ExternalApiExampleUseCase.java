package com.gusrubin.lab.javafxwithspring.application.port.in;

import com.gusrubin.lab.javafxwithspring.domain.callexternalapi.ExampleResource;
import java.util.List;

/**
 * @author Gustavo Rubin
 */
public interface ExternalApiExampleUseCase {

  List<ExampleResource> getAll();

  ExampleResource getById(Long id);
}
