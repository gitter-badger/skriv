package classes;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;


public class Page extends Tab{
    
    private Canvas canvas;
    private GraphicsContext gc;
    private double curX, curY; // Cursor
    // Maybe...
    // A Page can only have one set of Notes
    //private Notes notes;
    
    public Page(){
        this("Untitled");
    }
    
    public Page(String title){
        super(title);
        super.setContent(canvas);
        curX = 20;
        curY = 20;
    }
    
    public void makeCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        canvas = new Canvas();
        canvas.widthProperty().bind(width);
        canvas.heightProperty().bind(height);
        
        gc = canvas.getGraphicsContext2D();
    }
    
    public void drawWord(Word w){
        if(canvas.getWidth() - curX < w.getWidth()){
            curX = 20;
            curY = curY + w.getHeight() + 20;
        }
        gc.drawImage(w.getImage(), curX, curY, .65*w.getWidth(), .65*w.getHeight());
        curX = curX + 20 + w.getWidth();
    }
    
    public void startLine(double x, double y){
        gc.beginPath();
        gc.moveTo(x, y);
    }
    
    public void updateLine(double x, double y){
        gc.lineTo(x, y);
        gc.stroke();
    }
}