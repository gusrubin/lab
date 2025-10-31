package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import com.gusrubin.lab.javafxwithspring.application.port.in.ExternalApiExampleUseCase;
import com.gusrubin.lab.javafxwithspring.domain.callexternalapi.ExampleResource;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/views/ExternalApiExampleView.fxml")
@RequiredArgsConstructor
public class ExternalApiExampleController {

  private final ExternalApiExampleUseCase externalApiExampleUseCase;

  @FXML private AnchorPane externalApiExamplePane;

  @FXML private ListView<ExampleResource> exampleResourceList;

  @FXML private Button getButton;

  @FXML private Button clearLogButton;

  @FXML
  public void initialize() {
    log.debug("initialize ExternalApiExampleController");
    this.getButton.setOnAction(actionEvent -> getResourceList());
    this.clearLogButton.setOnAction(actionEvent -> clearLog());
  }

  private void getResourceList() {
    this.externalApiExampleUseCase.getAll().forEach(this.exampleResourceList.getItems()::add);
  }

  private void clearLog() {
    this.exampleResourceList.getItems().clear();
  }
}
