/*
Mahek Gupta
10/15/19
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.Random;

public class drawingShapes extends Application
{
    @Override
    public void start ( Stage stage ) throws Exception
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( stage, "Drawing Shapes", 700, 400);

        //your drawing code goes here
        gc.setStroke(Color.CORAL);
        gc.strokeText("Mahek", 15, 27);
        gc.setStroke( Color.BLUEVIOLET);
        gc.strokeLine ( 35, 78, 200, 300);

        Random randy = new Random();
        int red = randy.nextInt(0xFF);
        int blue = randy.nextInt(0xFF);
        int green = randy.nextInt(0xFF0);
        Color randyColor = Color.rgb(red, green, blue);
   //     gc.setStroke(randyColor);
//        gc.setLineWidth(10);
//        gc.strokeLine(50,50,500,500);
        gc.setFill( Color.PINK);
        gc.fillRect(  19,  30,  25,  25);
        gc.setStroke( Color.BLUE);
        gc.strokeRect(  19,  30,  25,  25);
        gc.setFill( Color.GREEN);
        gc.fillOval(  75,  60,  25,  25);
        gc.setStroke( Color.YELLOW);
        gc.strokeOval(  75,  60,  25,  25);
    }

    public static void main (String [ ] args)
    {
        launch ( args );
    }
}
