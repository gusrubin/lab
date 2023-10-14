package com.gusrubin.lab.springjavafx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;

import com.gusrubin.lab.springjavafx.application.DesktopApp;

@SpringBootApplication
public class SpringjavafxApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringjavafxApplication.class, args);
		Application.launch(DesktopApp.class, args);
	}

}
