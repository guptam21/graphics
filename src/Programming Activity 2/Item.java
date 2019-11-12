/* Item
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public abstract class Item
{
 protected double price;
 protected double currentStudentSubTotal;
 protected double correctCorrectSubTotal;
 
 protected int x;
 protected int y = 270;
 protected int startX = 50;
 protected int endX = 200;
 
 protected int height = 150;  // 65;
 protected int width = 70;  // 30;

 protected int beltHeight = 10;
 protected int bagWidth = 120;
 
 private int index;
 private int maxIndex;

 public Item( double p )
 {
  price = p;
 }
 
 public void setIndex( int index )
 {
  this.index = index;
 }
 
 public void setMaxIndex( int maxIndex )
 {
  this.maxIndex = maxIndex;
 }
 
 public int getIndex( )
 {
  return index;
 }
 
 public int getMaxIndex( )
 {
  return maxIndex;
 }

 public void setPrice( double newPrice )
 {
  price = ( newPrice > 0 ? newPrice : 0 );
 }

 public double getPrice( )
 {
  return price;
 }
 
 public void addToX( int delta )
 {
   x += delta;
 }
 
 public void resetX( )
 {
   x = startX;
 }
 
 public boolean done( )
 {
   return ( x >= endX );
 }
 
 public void setCurrentStudentSubTotal( double currentStudentSubTotal )
 {
   if ( currentStudentSubTotal > 0 )
     this.currentStudentSubTotal = currentStudentSubTotal;
 }
 
 public void setCurrentCorrectSubTotal( double currentCorrectSubTotal )
 {
   this.correctCorrectSubTotal = currentCorrectSubTotal;
 }

 public void updateCurrentCorrectSubTotal( )
 {
   if ( price >= 0 )
     correctCorrectSubTotal += price;
 }
 
 public double getCurrentCorrectSubTotal( )
 {
   return correctCorrectSubTotal;
 }


 public abstract void draw( GraphicsContext gc );

 public void drawBeltAndBag( GraphicsContext gc )
 {
   gc.setFill( Color.BLACK );
   gc.fillRoundRect( startX, y, endX, beltHeight, 2, 2 );  // belt
   gc.setFill( Color.rgb( 220, 110, 55 ) );
  
   gc.fillRoundRect( endX, y, bagWidth, bagWidth, 10, 10 ); // bag 
   gc.setFont( new Font( Dimensions.MEDIUM_SMALL_FONT_SIZE ) );
   gc.setFill( Color.BLACK );
   gc.fillText( "Market", endX + bagWidth / 6, y + bagWidth / 2 );
   gc.fillText( " Foods", endX + bagWidth / 6, y + 3 * bagWidth / 4 );
 }
 
 public void drawData( GraphicsContext gc )
 {
   DecimalFormat money = new DecimalFormat( "$0.00" );

   String displayStudentTotal = "Your subtotal = " + money.format( currentStudentSubTotal );
   String displayExactTotal = "Correct subtotal = " + money.format( correctCorrectSubTotal );

   gc.setFill( Color.NAVY );
   Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
   gc.setFont( mediumFont );
   gc.fillText( displayStudentTotal, endX + bagWidth + 30, y - y / 6 );
   gc.fillText( displayExactTotal, endX + bagWidth + 30, y + y / 6 );
 }
 
 public void drawItemNumber( GraphicsContext gc )
 {
   String itemSubTotal = "Item # " + index + " of " + maxIndex;

   gc.setFill( Color.BLACK );
   Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
   gc.setFont( mediumFont );
   gc.fillText( "Express Lane", endX + bagWidth + 30 + 60, y - 2 * y / 3 + 10 );
   gc.fillText( itemSubTotal, endX + bagWidth + 30 + 60, y - y / 3 - y / 6 + 10 );
 }

 public String toString( )
 {
   return getClass( ).getName( );
 }
 
}
