package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;

@Slf4j
@Component
@FxmlView("/views/PersistenceExample.fxml")
@RequiredArgsConstructor
public class PersistenceExample {

	@FXML
	private AnchorPane pane;

	@FXML
	public void initialize() {
		log.debug("initialize PersistenceExample");
	}

	private Stage getStage() {
		return (Stage) pane.getScene().getWindow();
	}

}
