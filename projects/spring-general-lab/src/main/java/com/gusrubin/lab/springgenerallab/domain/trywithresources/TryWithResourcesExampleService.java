package com.gusrubin.lab.springgenerallab.domain.trywithresources;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@RequiredArgsConstructor
public class TryWithResourcesExampleService implements TryWithResourcesExampleUseCase {

    final TryWithResourcesExampleRepositoryPort tryWithResourcesExampleRepositoryPort;

    @Override
    public String readFile() {
	return this.tryWithResourcesExampleRepositoryPort.readFile();
    }

}
