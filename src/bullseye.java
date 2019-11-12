/*
Mahek Gupta
11/1/19
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.application.Application;

import javafx.animation.AnimationTimer;

import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class bullseye extends Application
{

    @Override
    public void start ( Stage stage )
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( stage, "Shell Graphics Application", 700, 600);

        //your drawing code goes here
        final int CENTER_X = 350, CENTER_Y = 200;

        final int START_DIAMETER = 300, END_DIAMETER = 25, DECREMENT = 25;

        Color toggleColor = Color.BLACK;
        gc.setFill( toggleColor );

        for ( int diameter = START_DIAMETER; diameter>=END_DIAMETER; diameter -= DECREMENT)
        {
            gc.fillOval( CENTER_X - diameter / 2, CENTER_Y - diameter / 2, diameter, diameter );

            if ( toggleColor.equals( Color.BLACK) )
            {
                toggleColor=Color.RED;
            }
            else
            {
                toggleColor = Color.BLACK;
            }
                gc.setFill( toggleColor );

        }

    }
    public static void main( String [] args )
    {
        launch(args);
    }

}
