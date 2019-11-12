/* Cereal
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import java.text.DecimalFormat;

public class Cereal extends Item
{
 public Cereal( double p )
 {
  super( p );
 }
 
 public void draw( GraphicsContext gc )
 {
  drawBeltAndBag( gc );
  drawData( gc );
  drawItemNumber( gc );
  int width = 92;
  DecimalFormat money = new DecimalFormat( "$0.00" );

  Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
  gc.setFont( mediumFont );
  String display1 = "Cereal: unit price = " + money.format( price );

  gc.setFill( Color.NAVY );
  gc.fillText( display1, 20, ( y - height ) / 2 );

  gc.setFill( Color.rgb( 255, 255, 51 ) );
  gc.fillRect( x, y - height - 2, width, height );
  gc.setFill( Color.BLACK );
  
  Font mediumSmallFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
  gc.setFont( mediumSmallFont );
  gc.fillText( "Cereal", x + 1, y - height + height / 4 + 5 );

  gc.setFill( Color.RED );
  gc.setStroke( Color.RED );
  gc.strokeOval( x + width / 2 - width / 6, y - height / 2 - width / 4 + 7, width / 3, width / 3 );
  gc.strokeOval( x + width / 2 - width / 3, y - height / 2 + 10, width / 3, width / 3 );
  gc.strokeOval( x + width / 2, y - height / 2 + 10, width / 3, width / 3 );
 
  gc.fillArc( x + width / 2 - width / 3, y - height / 2 + 10, 
              2 * width / 3, 2 * width / 3, 0, -180, ArcType.ROUND ); // CHORD, OPEN
 }

}