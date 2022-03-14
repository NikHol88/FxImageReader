package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Actions {
    DocReader docReader;
    int chek;
    TextArea textArea;
    boolean bool=true;
    String textA;
    Alert alert;
    ImageView imageView;
    Image card; //= new Image("44.jpg");
   // FlowPane flowPane;
    EventHandler<ActionEvent> eventEventHandlerNext = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(chek>=0){


                InputStream pict = null;
                try {
                    pict = new ByteArrayInputStream(docReader.docReader().get(chek).getData());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                 card= new Image(pict);
                    try {
                        pict.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setFitHeight(500);
imageView.setFitWidth(250);
               imageView.setImage(card);

                chek++;
                bool=false;
                System.out.println(chek);
                    try {
                        pict.close();
                        textArea.setText("ready");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (chek<0){

                    chek=0;
                }
                try {
                    if(chek>=docReader.docReader().size()){
                        textArea.setText("Все");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

    };
    EventHandler<ActionEvent> eventEventHandlerSave = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {




//запись
            String name = ((Button)actionEvent.getSource()).getText();
            try {
                Files.write( Path.of("D:\\INI\\New_Project2\\demo\\src\\main\\resources\\"+name+".jpg"),
                        docReader.docReader().get(chek-1).getData());
            } catch (IOException e) {
                e.printStackTrace();
            }


//проверка
               File nef = new File("D:\\INI\\New_Project2\\demo\\src\\main\\resources\\"+name+".jpg");
                textArea.setText("Ok\n"+nef.exists());


        }
    };
    EventHandler<ActionEvent> eventEventHandlerPr = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            chek--;
            textA = String.valueOf(chek);
            System.out.println(textA);
            textArea.setText(getTextA());
        }
    };
EventHandler<KeyEvent> keyEventEventHandlerNext = new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent keyEvent) {


        if(chek>=0){


            InputStream pict = null;
            try {
                pict = new ByteArrayInputStream(docReader.docReader().get(chek).getData());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            card= new Image(pict);
            try {
                pict.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setFitHeight(500);
            imageView.setFitWidth(250);
            imageView.setImage(card);

            chek++;
            bool=false;
            System.out.println(chek);
            try {
                pict.close();
                textArea.setText("ready");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (chek<0){

            chek=0;
        }
        try {
            if(chek>=docReader.docReader().size()-1){



                textArea.setText("Все");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

};

    public Actions(DocReader docReader, int chek, TextArea textArea, ImageView imageView ) {
        this.docReader = docReader;
        this.chek = chek;
        this.textArea = textArea;
        this.imageView = imageView;
     //   this.flowPane = flowPane;
    }

    public EventHandler<ActionEvent> getEventEventHandlerNext() {
        return eventEventHandlerNext;
    }

    public EventHandler<ActionEvent> getEventEventHandlerSave() {
        return eventEventHandlerSave;
    }

    public EventHandler<ActionEvent> getEventEventHandlerPr() {
        return eventEventHandlerPr;
    }

    public String getTextA() {
        return textA;
    }

    public Image getCard() {
        return card;
    }

    public EventHandler<KeyEvent> getKeyEventEventHandlerNext() {
        return keyEventEventHandlerNext;
    }
}
