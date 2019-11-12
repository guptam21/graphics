/* Cart
*  Anderson, Franceschi
*/

import javafx.scene.paint.Color;

public class Cart
{
 Item[] items;
 int itemSize = 3; // 4;
 int currentItem;

 double currentTotal;
 double exactTotal;
 Color background = Color.rgb( 205, 205, 205 );

 public Cart( )
 {
  items = new Item[ itemSize ];

  //
  // Student can modify constructors' arguments below
  // Check out the 3 constructors
  // argument represents price
  //
  items[0] = new Milk( 2.00 );
  items[1] = new Cereal( 3.50 );
  items[2] = new OrangeJuice( 3.00 );
  //
  //

  currentTotal = 0.0;
  exactTotal = 0.0;
  currentItem = -1;
 }

 public void setCurrentItem( int ci )
 {
  currentItem = ci;
 }

 public int getCurrentItem( )
 {
  return currentItem;
 }

 public Item [] getItems( )
 {
  return items;
 }

 public int getItemSize( )
 {
  return itemSize;
 }

 public void updateTotal( double newCurrentTotal )
 {
  currentTotal = newCurrentTotal;
 }

 public double getTotal( )
 {
  return currentTotal;
 }

 public void setExactTotal( double newExactTotal )
 {
  exactTotal = newExactTotal;
 }

 public Color getBackground( )
 {
  return background;
 }
}