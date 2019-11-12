/*
Mahek Gupta
10/14/19
 */

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JIGraphicsUtility
{
    public static GraphicsContext setUpGraphics ( Stage stage, String title, int height, int width)
    {
        stage.setTitle( title );
        Canvas canvas = new Canvas ( width, height );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Group root = new Group( canvas );
        stage.setScene( new Scene (root) );
        stage.show();
        return gc;
    }
}
