package com.gusrubin.lab.javafxwithspring.application.gui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.application.gui.controllers.MainWindow;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;

@Component
@RequiredArgsConstructor
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

	private final FxWeaver fxWeaver;

	@Override
	public void onApplicationEvent(StageReadyEvent event) {
		Stage stage = event.getStage();
		Scene scene = new Scene(fxWeaver.loadView(MainWindow.class), 600, 400);
		stage.setScene(scene);
		stage.show();
	}
}
