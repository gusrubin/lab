package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SplashScreenController {

    @FXML
    private AnchorPane splashPane;

    @FXML
    private Label splashLabel;

    @FXML
    private Label splashStartingLabel;

    @FXML
    private Label splashSystemInfoLabel;

    public void initialize() {
	this.splashLabel.setText("Hello World JavaFX Application");
	this.splashStartingLabel.setText("Starting...");
	String javaVersion = System.getProperty("java.version");
	String javafxVersion = System.getProperty("javafx.version");
	splashSystemInfoLabel.setText("JavaFX " + javafxVersion + " running on JVM " + javaVersion);
    }

}
