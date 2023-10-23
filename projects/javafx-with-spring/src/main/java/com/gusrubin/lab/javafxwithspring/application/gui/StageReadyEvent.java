package com.gusrubin.lab.javafxwithspring.application.gui;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class StageReadyEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private final transient Stage stage;

	public StageReadyEvent(Stage stage) {
		super(stage);
		this.stage = stage;
	}
}
