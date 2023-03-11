package com.gusrubin.lab.runningtomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringRunningInTomcatApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(SpringRunningInTomcatApplication.class, args);
    }

}
