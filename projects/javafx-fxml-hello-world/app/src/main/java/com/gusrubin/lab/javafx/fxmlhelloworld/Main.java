package com.gusrubin.lab.javafx.fxmlhelloworld;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getFxmlURL());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private URL getFxmlURL() {
        URL fxmlURL = null;

        try {
            // Obtenha o URL do arquivo FXML da pasta resources
            fxmlURL = getClass().getResource("/hellofx.fxml");

            if (fxmlURL == null) {
                throw new IOException("Arquivo FXML não encontrado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fxmlURL;
    }

}
