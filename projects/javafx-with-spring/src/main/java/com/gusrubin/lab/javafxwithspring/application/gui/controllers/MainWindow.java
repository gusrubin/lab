package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
	private AnchorPane pane;

	@FXML
	public Button openDialogButton;

	@FXML
	public Button closeButton;

	private final FxControllerAndView<InfoDialog, VBox> someDialog;

	@FXML
	public void initialize() {
		log.debug("initialize MainWindow");
		openDialogButton.setOnAction(actionEvent -> someDialog.getController().show());
	}

	@FXML
	private void handleCloseAction(ActionEvent event) {
		getStage().close();
	}

	@FXML
	private void handleOpenPersistenceSceneAction(ActionEvent event) {
		showCustomDialog(getStage());
	}

	private Stage getStage() {
		return (Stage) pane.getScene().getWindow();
	}

	private void showCustomDialog(Stage parentStage) {
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("Diálogo Personalizado");
		dialog.setHeaderText("Digite alguma coisa:");

		// Crie um campo de texto no diálogo
		TextField textField = new TextField();
		dialog.getDialogPane().setContent(textField);

		// Adicione botões padrão (OK e Cancelar)
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// Bloqueie o pai enquanto o diálogo estiver aberto
		dialog.initOwner(parentStage);
		dialog.initModality(Modality.WINDOW_MODAL);

		// Mostre o diálogo e aguarde que o usuário o feche
//		Optional<ButtonType> result = dialog.show();
		dialog.show();

//		if (result.isPresent() && result.get() == ButtonType.OK) {
//			String input = textField.getText();
//		}
	}

}
