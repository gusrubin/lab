package com.gusrubin.lab.springgenerallab.application.api.trywithresourcesexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gusrubin.lab.springgenerallab.domain.trywithresources.TryWithResourcesExampleUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/try-with-resources")
@RequiredArgsConstructor
public class TryWithResourcesExampleApi {

    final TryWithResourcesExampleUseCase tryWithResourcesExampleUseCase;

    @GetMapping
    public String getFileContent() {
	log.info("getFileContent()");
	return this.tryWithResourcesExampleUseCase.readFile();
    }

}
