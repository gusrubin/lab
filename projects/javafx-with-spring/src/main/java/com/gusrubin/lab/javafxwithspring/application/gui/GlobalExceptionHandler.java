package com.gusrubin.lab.javafxwithspring.application.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GlobalExceptionHandler {

	private GlobalExceptionHandler() {
		throw new IllegalStateException("Utility class");
	}

	public static void setupGlobalExceptionHandler(Stage stage) {
		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
			showAddNewWordDialog(stage, throwable.getMessage());
		});
	}

	private static void showAddNewWordDialog(Stage stage, String message) {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Error");
		dialog.setHeaderText("Operation failed");
		dialog.setContentText(message);

		// Adicione botões padrão (OK)
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);

		// Bloqueie o pai enquanto o diálogo estiver aberto
		dialog.initOwner(stage);
		dialog.initModality(Modality.WINDOW_MODAL);

		// Mostre o diálogo e aguarde que o usuário o feche
		dialog.showAndWait();
	}

}
