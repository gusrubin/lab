package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui;

import javafx.stage.Stage;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PrimaryStageReadyEvent extends ApplicationEvent {

  private static final long serialVersionUID = 2L;
  private final transient Stage stage;

  public PrimaryStageReadyEvent(Stage stage) {
    super(stage);
    this.stage = stage;
  }
}
