package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/views/MainWindowView.fxml")
@RequiredArgsConstructor
public class MainWindowController {

  @FXML private AnchorPane mainPane;

  @FXML private Label mainPaneLabel;

  @FXML private AnchorPane systemInfoPane;

  @FXML private AnchorPane persistenceExamplePane;

  @FXML private AnchorPane externalApiExamplePane;

  @FXML
  public void initialize() {
    log.debug("initialize MainController");
    this.mainPane.setVisible(true);
    this.mainPaneLabel.setText("JavaFX with Spring Boot - Hello World");
    this.systemInfoPane.setVisible(false);
    this.persistenceExamplePane.setVisible(false);
    this.externalApiExamplePane.setVisible(false);
  }

  @FXML
  private void handleMenuOpenSystemInfoAction(ActionEvent event) {
    this.mainPane.setVisible(false);
    this.systemInfoPane.setVisible(true);
    this.persistenceExamplePane.setVisible(false);
    this.externalApiExamplePane.setVisible(false);
  }

  @FXML
  private void handleMenuOpenPersistenceSceneAction(ActionEvent event) {
    this.mainPane.setVisible(false);
    this.systemInfoPane.setVisible(false);
    this.persistenceExamplePane.setVisible(true);
    this.externalApiExamplePane.setVisible(false);
  }

  @FXML
  private void handleMenuOpenExternalApiSceneAction(ActionEvent event) {
    this.mainPane.setVisible(false);
    this.systemInfoPane.setVisible(false);
    this.persistenceExamplePane.setVisible(false);
    this.externalApiExamplePane.setVisible(true);
  }

  @FXML
  private void handleMenuCloseAction(ActionEvent event) {
    getStage().close();
  }

  private Stage getStage() {
    return (Stage) systemInfoPane.getScene().getWindow();
  }
}
