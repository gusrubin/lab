package com.gusrubin.lab.javafxwithspring.application.gui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.application.gui.controllers.MainWindowController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;

@Component
@RequiredArgsConstructor
public class PrimaryStageInitializer implements ApplicationListener<PrimaryStageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Override
    public void onApplicationEvent(PrimaryStageReadyEvent event) {
	Stage stage = new Stage();
	Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
	stage.getIcons().addAll(icon);
	Parent root = fxWeaver.loadView(MainWindowController.class);
	stage.setTitle("JavaFX Hello World");
	stage.setScene(new Scene(root));
	stage.show();
    }
}
