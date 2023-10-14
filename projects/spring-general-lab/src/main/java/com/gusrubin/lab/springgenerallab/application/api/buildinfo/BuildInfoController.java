/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.buildinfo;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */

@RestController
@RequestMapping("/api/build-info")
@RequiredArgsConstructor
public class BuildInfoController {

//    private final BuildProperties buildProperties;
    
    @GetMapping
    public String getBuildInfo() {
	
//	return this.buildProperties.getVersion();
	return null;
    }

}
