package com.gusrubin.lab.javafxwithspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gusrubin.lab.javafxwithspring.application.gui.JavaFxApplication;

import javafx.application.Application;

@SpringBootApplication
public class JavafxWithSpringApplication {

	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}

}
