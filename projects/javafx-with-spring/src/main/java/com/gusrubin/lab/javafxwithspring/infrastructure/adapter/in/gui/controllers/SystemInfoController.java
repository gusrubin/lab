package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/views/SystemInfoView.fxml")
@RequiredArgsConstructor
public class SystemInfoController {

  @FXML private AnchorPane systemInfoPane;

  @FXML public Button openDialogButton;

  private final FxControllerAndView<SystemInfoDialogController, VBox> systemInfoDialog;

  @FXML
  public void initialize() {
    log.debug("initialize SystemInfoController");
    openDialogButton.setOnAction(actionEvent -> systemInfoDialog.getController().show());
  }
}
