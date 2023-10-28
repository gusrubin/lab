package com.gusrubin.lab.javafxwithspring.application.gui;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class PrimaryStageReadyEvent extends ApplicationEvent {

    private static final long serialVersionUID = 2L;
    private final transient Stage stage;

    public PrimaryStageReadyEvent(Stage stage) {
	super(stage);
	this.stage = stage;
    }
}
