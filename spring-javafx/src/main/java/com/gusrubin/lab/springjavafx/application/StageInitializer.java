package com.gusrubin.lab.springjavafx.application;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.springjavafx.application.DesktopApp.StageReadyEvent;

// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final String applicationTitle = "Example of Java FX with Spring Boot";
    private final FxWeaver fxWeaver;

    public StageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        // FXMLLoader fxmlLoader;
        // Parent parent;
        Stage stage = event.getStage();
        stage.setScene(new Scene(fxWeaver.loadView(MainWindow.class), 800, 600));
        stage.setTitle(applicationTitle);
        stage.show();
    }

}
