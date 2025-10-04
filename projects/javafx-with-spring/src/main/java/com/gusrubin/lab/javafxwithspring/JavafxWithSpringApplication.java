package com.gusrubin.lab.javafxwithspring;

import com.gusrubin.lab.javafxwithspring.application.gui.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxWithSpringApplication {

  public static void main(String[] args) {
    Application.launch(JavaFxApplication.class, args);
  }
}
