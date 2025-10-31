package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SplashScreenController {

  @FXML private AnchorPane splashPane;

  @FXML private Label splashLabel;

  @FXML private Label splashStartingLabel;

  @FXML private Label splashSystemInfoLabel;

  public void initialize() {
    this.splashLabel.setText("Hello World JavaFX Application");
    this.splashStartingLabel.setText("Starting...");
    String applicationVersion =
        Optional.ofNullable(getClass().getPackage().getImplementationVersion())
            .orElse("It can only get when running from JAR");
    splashSystemInfoLabel.setText("Version " + applicationVersion);
  }
}
