package com.gusrubin.lab.javafxwithspring.application.gui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.gusrubin.lab.javafxwithspring.JavafxWithSpringApplication;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JavaFxApplication extends Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() throws Exception {
		ApplicationContextInitializer<GenericApplicationContext> initializer = applicationContext -> {
			applicationContext.registerBean(Application.class, () -> JavaFxApplication.this);
			applicationContext.registerBean(Parameters.class, this::getParameters);
			applicationContext.registerBean(HostServices.class, this::getHostServices);
		};
		this.context = new SpringApplicationBuilder().sources(JavafxWithSpringApplication.class)
				.initializers(initializer).run(getParameters().getRaw().toArray(new String[0]));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JavaFX Hello World");
//		primaryStage.setResizable(false);
		context.publishEvent(new StageReadyEvent(primaryStage));

		GlobalExceptionHandler.setupGlobalExceptionHandler(primaryStage);
	}

	@Override
	public void stop() throws Exception {
		log.info("Application closed");
		this.context.close();
		Platform.exit();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
