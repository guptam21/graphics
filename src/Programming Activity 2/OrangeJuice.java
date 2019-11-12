/* OrangeJuice
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.text.DecimalFormat;

public class OrangeJuice extends Item
{
 public OrangeJuice( double p )
 {
  super( p );
 }
 
 public void draw( GraphicsContext gc )
 {
  drawBeltAndBag( gc );
  drawData( gc );
  drawItemNumber( gc );
  DecimalFormat money = new DecimalFormat( "$0.00" );
  Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
  gc.setFont( mediumFont );
  String display1 = "Orange Juice: unit price = " + money.format( price );

  gc.setFill( Color.NAVY );
  gc.fillText( display1, 20, ( y - height ) / 2 );

  gc.setFill( Color.rgb( 244, 244, 102 ) );
  gc.fillRect( x, y - height - 2, width, height );

  gc.setFill( Color.LIGHTGRAY );
  gc.strokeLine( x, y - height + height / 5, 
                 x + width, y - height + height / 5 );
  gc.setFill( Color.BLACK );
  gc.fillText( "OJ", x + width / 4, y - height + height / 3 + 5 );

  gc.setFill( Color.rgb( 255, 132, 41 ) ); // orange
  gc.fillOval( x + width / 4, y - height + height / 3 + 5 + 5, width / 2, width / 2 );
 }

}