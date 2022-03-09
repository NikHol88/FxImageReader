package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DoubleThread implements Runnable {

InputStream pict;
String name;

    public DoubleThread(InputStream pict, String name) {
        this.pict = pict;
        this.name = name;
    }

    @Override
    public void run() {

        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(pict);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        // String name = ((Button)actionEvent.getSource()).getText();
        File output = new File("D:\\INI\\New_Project2\\demo\\src\\main\\resources\\" + name + ".jpg");
        try {

            try {
                ImageIO.write(img1, "jpg", output);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

