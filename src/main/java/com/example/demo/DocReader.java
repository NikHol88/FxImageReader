package com.example.demo;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;


public class DocReader {
    Image image;
    BufferedImage img1;
    public  List<XWPFPictureData> docReader() throws IOException {

        File file = new File("D:\\INI\\New_Project2\\FxImageReader\\src\\main\\resources\\Чудовища.docx");
        FileInputStream fileInputStream = new FileInputStream(file);
             XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);

       List<XWPFPictureData> pic = new ArrayList<XWPFPictureData>();
        pic= xwpfDocument.getAllPictures();


          //byte[] img = pic.get(i).getData();


   return pic; }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public BufferedImage getImg1() {
        return img1;
    }

    public void setImg1(BufferedImage img1) {
        this.img1 = img1;
    }



}

