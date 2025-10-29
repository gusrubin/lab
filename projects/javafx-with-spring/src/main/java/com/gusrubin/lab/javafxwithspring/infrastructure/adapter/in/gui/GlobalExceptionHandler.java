package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GlobalExceptionHandler {

  private GlobalExceptionHandler() {
    throw new IllegalStateException("Utility class");
  }

  public static void setupGlobalExceptionHandler(Stage stage) {
    Thread.setDefaultUncaughtExceptionHandler(
        (thread, throwable) -> {
          showAddNewWordDialog(stage, throwable.getMessage());
        });
  }

  private static void showAddNewWordDialog(Stage stage, String message) {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Erro");
    dialog.setHeaderText("Operação ");
    dialog.setContentText(message);

    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);

    // Bloqueia o pai enquanto o diálogo estiver aberto
    dialog.initOwner(stage);
    dialog.initModality(Modality.WINDOW_MODAL);

    // Mostra o diálogo e aguarda o usuário fechar
    dialog.showAndWait();
  }
}
