package com.gusrubin.lab.springjavafx.application;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.gusrubin.lab.springjavafx.SpringjavafxApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DesktopApp extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(SpringjavafxApplication.class).run();

        // ApplicationContextInitializer<GenericApplicationContext> initializer =
        // ac -> {
        // ac.registerBean(Application.class, () -> SpringjavafxApplication.this);
        // ac.registerBean(Parameters.class, this::getParameters);
        // ac.registerBean(HostService.class, this.getHosteServices);
        // };

        // this.context = new SpringApplicationBuilder()
        // .sources(BootFullappl);

        // ApplicationContextInitializer<GenericApplicationContext> initializer =
        // context -> {
        // context.registerBean(Application.class, () -> DesktopApp.this);
        // context.registerBean(Parameters.class, this::getParameters); // for
        // demonstration, not really needed
        // };
        // this.applicationContext = new SpringApplicationBuilder()
        // .sources(SpringjavafxApplication.class)
        // .initializers(initializer)
        // .run(getParameters().getRaw().toArray(new String[0]));
    }

    // https://www.youtube.com/watch?v=lPy9mc_O_gU&t=4s

    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));

        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        // Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " +
        // javaVersion + ".");
        // Scene scene = new Scene(new StackPane(l), 640, 480);
        // stage.setScene(scene);
        // stage.show();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    // public static void main(String[] args) {
    // launch();
    // }

}
