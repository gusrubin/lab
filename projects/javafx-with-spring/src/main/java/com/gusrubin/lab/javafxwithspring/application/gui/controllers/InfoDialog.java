package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.domain.systeminfo.GetSystemInfoUseCase;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/views/InfoDialog.fxml")
@RequiredArgsConstructor
public class InfoDialog {

	private Stage stage;

	@FXML
	private VBox dialog;

	@FXML
	private Label osVersion;

	@FXML
	private Label jvmVersion;

	@FXML
	private Label springBootVersion;

	@FXML
	private Button closeButton;

	private final GetSystemInfoUseCase getSystemInfoUseCase;

	@FXML
	public void initialize() {
		this.stage = new Stage();
		stage.setScene(new Scene(dialog));

		closeButton.setOnAction(actionEvent -> stage.close());
	}

	public void show() {
		osVersion.setText(this.getSystemInfoUseCase.get().getOperationSystemName() + " "
				+ this.getSystemInfoUseCase.get().getOperationSystemVersion());
		jvmVersion.setText(this.getSystemInfoUseCase.get().getJvmVersion());
		springBootVersion.setText(this.getSystemInfoUseCase.get().getSpringBootVersion());
		stage.show();
	}

}
