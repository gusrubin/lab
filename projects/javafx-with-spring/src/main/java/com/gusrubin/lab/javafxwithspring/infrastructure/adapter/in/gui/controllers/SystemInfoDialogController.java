package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import com.gusrubin.lab.javafxwithspring.application.port.in.GetSystemInfoUseCase;
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
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/views/SystemInfoDialogView.fxml")
@RequiredArgsConstructor
public class SystemInfoDialogController {

  private Stage stage;

  @FXML private VBox dialog;

  @FXML private Label applicationVersion;

  @FXML private Label springBootVersion;

  @FXML private Label javaFxVersion;

  @FXML private Label jvmVersion;

  @FXML private Label osVersion;

  @FXML private Button closeButton;

  private final GetSystemInfoUseCase getSystemInfoUseCase;

  @FXML
  public void initialize() {
    log.debug("initialize InfoDialog");
    this.stage = new Stage();
    this.stage.initModality(Modality.APPLICATION_MODAL);
    this.stage.setScene(new Scene(dialog));

    this.applicationVersion.setText(this.getSystemInfoUseCase.get().getApplicationVersion());
    this.springBootVersion.setText(this.getSystemInfoUseCase.get().getSpringBootVersion());
    this.javaFxVersion.setText(this.getSystemInfoUseCase.get().getJavafxVersion());
    this.jvmVersion.setText(this.getSystemInfoUseCase.get().getJvmVersion());
    this.osVersion.setText(
        this.getSystemInfoUseCase.get().getOperationSystemName()
            + " "
            + this.getSystemInfoUseCase.get().getOperationSystemVersion());

    this.closeButton.setOnAction(actionEvent -> stage.close());
  }

  public void show() {
    log.debug("show InfoDialog");
    this.stage.show();
  }
}
