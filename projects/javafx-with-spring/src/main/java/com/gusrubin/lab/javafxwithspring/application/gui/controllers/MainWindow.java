package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Slf4j
@Component
@FxmlView("/views/MainWindow.fxml")
@RequiredArgsConstructor
public class MainWindow {

	@FXML
	private AnchorPane systemInfoPane;

	@FXML
	private AnchorPane persistenceExamplePane;

	@FXML
	public Button openDialogButton;

	@FXML
	public Button closeButton;

	private final FxControllerAndView<InfoDialog, VBox> systemInfoDialog;

	@FXML
	public void initialize() {
		log.debug("initialize MainWindow");
		openDialogButton.setOnAction(actionEvent -> systemInfoDialog.getController().show());
	}

	@FXML
	private void handleMenuOpenSystemInfoAction(ActionEvent event) {
		systemInfoPane.setVisible(true);
		persistenceExamplePane.setVisible(false);
	}

	@FXML
	private void handleMenuOpenPersistenceSceneAction(ActionEvent event) {
		systemInfoPane.setVisible(false);
		persistenceExamplePane.setVisible(true);
	}

	@FXML
	private void handleMenuCloseAction(ActionEvent event) {
		getStage().close();
	}

	private Stage getStage() {
		return (Stage) systemInfoPane.getScene().getWindow();
	}

}
