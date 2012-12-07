package classes;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;


public class WordImage {
    
    private Image image; // This image holds the Word essentially
    private double width, height;
    private Color c;
    // etc...
    
    public WordImage(WritableImage image){
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }
    
    public Image getImage(){
        return image;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
}