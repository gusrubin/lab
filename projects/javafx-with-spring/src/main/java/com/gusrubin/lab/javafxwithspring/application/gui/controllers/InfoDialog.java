package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.domain.systeminfo.GetSystemInfoUseCase;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;

@Slf4j
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
		log.debug("initialize InfoDialog");
		this.stage = new Stage();
		this.stage.initModality(Modality.APPLICATION_MODAL);
		this.stage.setScene(new Scene(dialog));

		this.osVersion.setText(this.getSystemInfoUseCase.get().getOperationSystemName() + " "
				+ this.getSystemInfoUseCase.get().getOperationSystemVersion());
		this.jvmVersion.setText(this.getSystemInfoUseCase.get().getJvmVersion());
		this.springBootVersion.setText(this.getSystemInfoUseCase.get().getSpringBootVersion());

		this.closeButton.setOnAction(actionEvent -> stage.close());
	}

	public void show() {
		log.debug("show InfoDialog");
		this.stage.show();
	}

}
