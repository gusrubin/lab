package com.gusrubin.lab.javafxwithspring.application.port.out;

import com.gusrubin.lab.javafxwithspring.domain.callexternalapi.ExampleResource;
import java.util.List;

/**
 * @author Gustavo Rubin
 */
public interface ExternalApiPort {

  List<ExampleResource> getAll();

  ExampleResource getById(Long id);
}
