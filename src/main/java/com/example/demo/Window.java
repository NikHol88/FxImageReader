package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Window {
    int chek=0;
    ImageView imageView = new ImageView();
    javafx.scene.control.TextArea textArea = new javafx.scene.control.TextArea();
    FlowPane flowPane = new FlowPane();
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Button> buttonArrayList = new ArrayList<Button>();
        primaryStage.setTitle("Dogs application");
        primaryStage.setWidth(700);
        primaryStage.setHeight(800);
        DocReader docReader = new DocReader();
        Actions actions = new Actions(docReader,chek,textArea,imageView);
        InputStream iconStream =
                getClass().getResourceAsStream("/images/someImage.png");
        Image image1 = new Image(iconStream);
        primaryStage.getIcons().add(image1);
       // byte[] ris = docReader.docReader().get(chek).getData();

        for (int i = 0; i <180; i++) {
if (i==0){
    Button button = new Button("Pr");
    button.setOnAction(actions.getEventEventHandlerPr());
    buttonArrayList.add(button);
}
            if (i==1){
                Button button = new Button("Next");
                button.setOnAction(actions.getEventEventHandlerNext());
                buttonArrayList.add(button);
            }
            if (i>1) {
                Button button = new Button(String.valueOf(i-2));
                button.setOnAction(actions.getEventEventHandlerSave());
                buttonArrayList.add(button);
            }
        }

        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setVgap(10);
        flowPane.setHgap(10);


          imageView.setImage(actions.getCard());
       // javafx.scene.control.TextArea textArea = new javafx.scene.control.TextArea();
textArea.setMaxSize(100,100);
flowPane.getChildren().add(textArea);
flowPane.getChildren().add(imageView);
        for (int i = 0; i <180 ; i++) {
            flowPane.getChildren().add(buttonArrayList.get(i));
        }

        Scene primaryScene = new Scene(flowPane);

        primaryScene.setOnKeyTyped(actions.getKeyEventEventHandlerNext());
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
}
