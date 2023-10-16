package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/views/MainWindow.fxml")
@RequiredArgsConstructor
public class MainWindow {

	@FXML
	private AnchorPane pane;

	@FXML
	public Button openDialogButton;

	@FXML
	public Button closeButton;

	private final FxControllerAndView<InfoDialog, VBox> someDialog;

	@FXML
	public void initialize() {
		openDialogButton.setOnAction(actionEvent -> someDialog.getController().show());
	}

	@FXML
	private void handleCloseAction(ActionEvent event) {
		final Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
	}

}
