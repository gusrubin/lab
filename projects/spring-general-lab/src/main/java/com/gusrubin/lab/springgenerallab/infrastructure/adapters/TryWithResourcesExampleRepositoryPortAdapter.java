package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.trywithresources.TryWithResourcesExampleRepositoryPort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@Component
public class TryWithResourcesExampleRepositoryPortAdapter implements TryWithResourcesExampleRepositoryPort {

    @Override
    public String readFile() {
	StringBuilder fileContentStringBuilder = new StringBuilder();

	try (FileReader fileReader = new FileReader("./build.gradle");
		BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	    // Operações de leitura no arquivo usando o bufferedReader
	    String linha;
	    while ((linha = bufferedReader.readLine()) != null) {
		fileContentStringBuilder.append(linha);
	    }

	} catch (IOException e) {
	    // Tratamento de exceção, se ocorrer algum erro de E/S
	    log.error(e.getMessage());
	}

	return fileContentStringBuilder.toString();
    }

}
