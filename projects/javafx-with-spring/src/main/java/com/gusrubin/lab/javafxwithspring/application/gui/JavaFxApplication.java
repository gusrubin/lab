package com.gusrubin.lab.javafxwithspring.application.gui;

import java.io.IOException;
import java.net.URL;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.gusrubin.lab.javafxwithspring.JavafxWithSpringApplication;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext springApplicationContext;

    // This method is necessary when run by java -jar
    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	log.info("Starting application");
	log.info("Show splash screen");
	showSplashScreen(primaryStage);

	new Thread(() -> {
	    try {
		Thread.sleep(500);

		Platform.runLater(() -> {
		    try {
			initSpringContext();

			log.info("Close splash screen");
			primaryStage.close();

			GlobalExceptionHandler.setupGlobalExceptionHandler(primaryStage);

			log.info("Show main window");
			springApplicationContext.publishEvent(new PrimaryStageReadyEvent(primaryStage));

		    } catch (Exception e) {
			log.error("Failed to load application. {}", e.getMessage());
		    }
		});

	    } catch (InterruptedException e) {
		log.error("Failed to load application. {}", e.getMessage());
		Thread.currentThread().interrupt();
	    }
	}).start();
    }

    private void showSplashScreen(Stage primaryStage) {
	Parent root = null;

	try {
	    URL fxmlURL = getClass().getResource("/views/SplashScreenView.fxml");

	    root = FXMLLoader.load(fxmlURL);

	    if (fxmlURL == null) {
		throw new IOException("SplashScreenView.fxml not found");
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

	primaryStage.setTitle("JavaFX Hello World");
	Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
	primaryStage.getIcons().addAll(icon);
	primaryStage.alwaysOnTopProperty();
	primaryStage.centerOnScreen();
	primaryStage.initStyle(StageStyle.UNDECORATED);
	primaryStage.setScene(new Scene(root));
	primaryStage.show();
    }

    private void initSpringContext() {
	ApplicationContextInitializer<GenericApplicationContext> initializer = applicationContext -> {
	    applicationContext.registerBean(Application.class, () -> JavaFxApplication.this);
	    applicationContext.registerBean(Parameters.class, this::getParameters);
	    applicationContext.registerBean(HostServices.class, this::getHostServices);
	};
	this.springApplicationContext = new SpringApplicationBuilder().sources(JavafxWithSpringApplication.class)
		.initializers(initializer).run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() throws Exception {
	log.info("Application closed");
	this.springApplicationContext.close();
	Platform.exit();
    }

}
