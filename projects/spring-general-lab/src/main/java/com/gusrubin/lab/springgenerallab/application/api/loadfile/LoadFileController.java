/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.loadfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class LoadFileController {

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
	log.info("Starting uploadFile controller");

	try {
	    InputStream inputStream = file.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	    String line;
	    while ((line = reader.readLine()) != null) {
		log.info(line);
	    }

	    reader.close();
	    inputStream.close();
	} catch (IOException e) {
	    e.printStackTrace();
	    // Lógica de tratamento de erro, se necessário
	}

	return "ok";
    }

}
