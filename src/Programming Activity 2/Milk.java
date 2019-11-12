/* Milk
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.text.DecimalFormat;

public class Milk extends Item
{
 public Milk( double p )
 {
  super( p );
 }
  
 public void draw( GraphicsContext gc )
 {
  drawBeltAndBag( gc );
  drawData( gc );
  drawItemNumber( gc );
  DecimalFormat money = new DecimalFormat( "$0.00" );

  String display1 = "Milk: unit price = " + money.format( price );
  Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
  gc.setFont( mediumFont );
  gc.setFill( Color.NAVY );
  gc.fillText( display1, 20, ( y - height ) / 2 );

  gc.setFill( Color.WHITE );
  gc.fillRect( x + 1, y - height - 2, width, height );
  gc.setStroke( Color.LIGHTGRAY );
  gc.strokeLine( x, y - height + height / 5, 
                 x + width, y - height + height / 5 );
  gc.strokeRect( x, y - height - 2, width + 1, height + 1 );
  gc.setFill( Color.BLACK );
  gc.fillText( "Milk", x + 5, y - height + height / 3 + 5 );
 }

}