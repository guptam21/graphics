/*
11/6/19
Mahek Gupta
 */

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class memoryGame extends Application
{

    private static final int numPairs = 8;
    private static final int numRow = 4;

    final ImageView selectedImage = new ImageView();
    Image image1 = new Image("https://www.medicalnewstoday.com/content/images/articles/322/322868/golden-retriever-puppy.jpg");
    Image image2 = new Image("https://ichef.bbci.co.uk/images/ic/1280xn/p06p0nss.jpg");
    Image image3 = new Image("data:image/jpeg;base64,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");
    Image image4 = new Image("data:image/jpeg;base64,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");
    Image image5 = new Image("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/lionel-animals-to-follow-on-instagram-1568319926.jpg?crop=0.922xw:0.738xh;0.0555xw,0.142xh&resize=640:*");
    Image image6 = new Image("https://columbuszoo.org/Media/columbus-zoo-aquarium/02-zoo-animals-lp_n-amer.jpg?sfvrsn=fe63d2a6_2&w=1280&h=840&mode=crop");
    Image image7 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLZGW2BVxu_JvahjcFqn3Z-3vw9dykbEigoWmONixq8llPfwsX&s");
    Image image8 = new Image("https://assets.blog.slice.ca/imageserve/wp-content/uploads/2018/05/29211306/distinctly-canadian-animals-moose/x.jpg");


    private Card selected = null;
   // private int clickCount = 2;

    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(600,600);


        //char c = 'A';
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numPairs; i++)
        {
            cards.add(new Card(image1));
            cards.add(new Card(image1));
            cards.add(new Card(image2));
            cards.add(new Card(image2));
            cards.add(new Card(image3));
            cards.add(new Card(image3));
            cards.add(new Card(image4));
            cards.add(new Card(image4));
            cards.add(new Card(image5));
            cards.add(new Card(image5));
            cards.add(new Card(image6));
            cards.add(new Card(image6));
            cards.add(new Card(image7));
            cards.add(new Card(image7));
            cards.add(new Card(image8));
            cards.add(new Card(image8));

        }

        Collections.shuffle(cards);

        for (int i = 0; i < cards.size(); i++)
        {
            Card card = cards.get(i);
            card.setTranslateX(150 * (i % numRow));
            card.setTranslateY(150 * (i / numRow));
            root.getChildren().add(card);
        }
//        Card card = new Card("A");
//        root.getChildren().add(card);

        return root;
    }


    @Override
    public void start ( Stage stage ) throws Exception
    {
        // set up window title and size
       //

        stage.setScene(new Scene(createContent()));
        stage.show();

        //GraphicsContext gc = JIGraphicsUtility.setUpGraphics( stage, "Memory Game", 700, 700);

        //your drawing code goes here

    }

    private class Card extends StackPane
    {
        private Text text = new Text();

        public Card (Image image)
        {
            Rectangle border = new Rectangle( 150, 150);
            border.setFill(null);
            border.setStroke(Color.BLACK);

           // text.setText(value);
            //text.setFont(Font.font(30));

            setAlignment(Pos.CENTER);
            getChildren().add( new ImageView());

            setOnMouseClicked(event -> {
                if (isOpen())
                {
                    return;
                }


                //open();

                if (selected == null)
                {
                    selected = this;
                    open(() -> {});
                }
                else
                {
                    open(() -> {
                        if (!hasSameValue(selected))
                        {
                            selected.close();
                            this.close();
                        }

                        selected = null;

                    });

                }
            });

            close();


        }



        public boolean isOpen()
        {
            return text.getOpacity() == 1;
        }

        public void open(Runnable action)
        {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close()
        {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();

        }
        public boolean hasSameValue (Card other)
        {
            return text.getText().equals(other.text.getText());
        }
    }


    public static void main (String [ ] args)
    {
        launch ( args );
    }
}
