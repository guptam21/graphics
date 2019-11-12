 /*
Mahek Gupta
10/17/19
 */
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.Ellipse;



    public class truck extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            // set up window title and size
            GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Truck", 400, 700);
            AnimationTimer timer = new AnimationTimer() {
                double x = 0;

                @Override
                public void handle(long now) {
                    gc.setFill(Color.PINK);
                    gc.fillRect(0, 0, 700, 400);
                    gc.setFill(Color.BLACK);
                    gc.fillRect(10 + x, 100, 300, 200);
                    gc.setFill(Color.BLUE);
                    gc.fillRect(200 + x, 150, 110, 50);
                    gc.setFill(Color.RED);
                    gc.fillOval(80 + x, 270, 60, 60);
                    gc.fillOval(200 + x, 270, 60, 60);
                    x += 3;
                    gc.setFill(Color.WHITE);
                    gc.fillOval(570, 20, 50,50);
                    gc.setFill(Color.WHITE);
                    gc.fillOval(610, 20, 50,50);
                    gc.setFill(Color.WHITE);
                    gc.fillOval(650, 20, 50,50);
                    gc.setFill(Color.GREEN);
                    gc.fillOval(0, 320, 350,250 );
                    gc.fillOval(130, 300, 400,350 );
                    gc.fillOval(370, 360, 300,150 );
                    gc.fillOval(500, 340, 300,220 );
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(-50, -50, 100,100 );
                    gc.setStroke( Color.YELLOW);
                    gc.strokeLine ( 0, 0, 70, 10);
                    gc.strokeLine ( 0, 0, 65, 20);
                    gc.strokeLine ( 0, 0, 60, 30);
                    gc.strokeLine ( 0, 0, 55, 40);
                    gc.strokeLine ( 0, 0, 50, 50);
                    gc.strokeLine ( 0, 0, 45, 60);
                    gc.strokeLine ( 0, 0, 37, 65);
                    gc.strokeLine ( 0, 0, 30, 70);
                    gc.strokeLine ( 0, 0, 20, 72);
                    gc.strokeLine ( 0, 0, 10, 75);

                    gc.setFill(Color.LIMEGREEN);
                    gc.fillRect(200, 290, 5, 50);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(197, 277, 10, 7);
                    gc.setFill(Color.PURPLE);
                    gc.fillOval(200, 266, 6, 12);
                    gc.fillOval(200, 283, 6, 12);
                    gc.fillOval(186, 280, 12, 6);
                    gc.fillOval(206, 280, 12, 6);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(197, 277, 10, 7);

                    gc.setFill(Color.LIMEGREEN);
                    gc.fillRect(300, 270, 5, 50);
                    gc.setFill(Color.PURPLE);
                    gc.fillOval(300, 246, 6, 12);
                    gc.fillOval(300, 263, 6, 12);
                    gc.fillOval(286, 260, 12, 6);
                    gc.fillOval(306, 260, 12, 6);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(297, 257, 10, 7);

                    gc.setFill(Color.LIMEGREEN);
                    gc.fillRect(400, 260, 5, 55);
                    gc.setFill(Color.PURPLE);
                    gc.fillOval(400, 236, 6, 12);
                    gc.fillOval(400, 253, 6, 12);
                    gc.fillOval(386, 250, 12, 6);
                    gc.fillOval(406, 250, 12, 6);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(397, 247, 10, 7);

                    gc.setFill(Color.LIMEGREEN);
                    gc.fillRect(450, 320, 5, 50);
                    gc.setFill(Color.PURPLE);
                    gc.fillOval(450, 296, 6, 12);
                    gc.fillOval(450, 313, 6, 12);
                    gc.fillOval(436, 310, 12, 6);
                    gc.fillOval(456, 310, 12, 6);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(447, 307, 10, 7);

                    gc.setFill(Color.LIMEGREEN);
                    gc.fillRect(650, 310, 5, 50);
                    gc.setFill(Color.PURPLE);
                    gc.fillOval(650, 306, 6, 12);
                    gc.fillOval(650, 323, 6, 12);
                    gc.fillOval(636, 320, 12, 6);
                    gc.fillOval(656, 320, 12, 6);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(647, 317, 10, 7);


                }
            };

            timer.start();

        }

        public static void main(String[] args) {
            launch(args);
        }
    }