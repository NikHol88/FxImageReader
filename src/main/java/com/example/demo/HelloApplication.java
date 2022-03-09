package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    Window window = new Window();
   // WindFXML windFXML = new WindFXML();
    @Override
    public void start(Stage primaryStage) throws Exception {
   //   windFXML.start(primaryStage);
      window.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}