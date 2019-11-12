/* CashierDrawing Class
* Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class CashierDrawing
{
 // ArrayList representing the various Items and subtotals
 // as they are used by the loop
 private ArrayList<SubTotal> subTotals;
 SubTotal currentSubTotal;
 Item currentItem;
 // current index of subTotals
 private int index;

 private Cart cart;
                    
 public CashierDrawing( )
 {
   subTotals = new ArrayList<SubTotal>( );
   index = 0;
   cart = new Cart( );
 }

 public void checkout( int numberOfItems )
 {
   /* ***** Student writes the body of this method ***** */
   //
   //  The parameter of this method, numberOfItems,
   //  represents the number of items in the cart. The
   //  user will be prompted for this number.
   //
   //  Using a for loop, calculate the total price
   //  of the groceries in the cart.
   //
   //  The getNext method (in this CashierDrawing class) returns the next
   //  item in the cart, which is an Item object (we do not
   //  know which item will be returned; this is randomly generated).
   //  getNext does not take any arguments. its API is
   //      Item getNext( )
   //
   //  As the last statement of the body of your for loop,
   //  you should call the animate method.
   //  The animate method takes one argument:  a double,
   //  which is your current subtotal.
   //  For example, if the name of your variable representing
   //  the current subtotal is total, your call to the animate
   //  method should be:
   //      animate( total );
   //
   //  The getPrice method of the Item class
   //  returns the price of the Item object as a double.
   //  The getPrice method does not take any arguments. Its API is
   //     double getPrice( )
   //
   
   

   //
   //  End of student code
   //
 }

  public Item getNext( )
  {
   // get next item
   // if the first item is the divider, that is ok - the cart is empty
   int number = ( (int) ( Math.random( ) * cart.getItemSize( ) ) );
   cart.setCurrentItem( number );

   // animate divider if necessary
   // if ( number == 3 )
      // animate( cart.getTotal( ) );
      
   Item item = ( cart.getItems( ) )[cart.getCurrentItem( )];
   // update subTotal
   currentItem = item;
   currentSubTotal = new SubTotal( item, 0 );
   return item;
  }
 
 public void animate( double total )
 {
   // update subTotals
   currentSubTotal.setSubTotal( total );
   // put it in ArrayList
   subTotals.add( currentSubTotal );
 }
  
  public void reset( )
  {
   index = 0;
  }
  
  public void incrementIndex( )
  {
   index++;
  }
  
  public int getIndex( )
  {
   return index;
  }
  
  public boolean done( )
  {
    return index >= subTotals.size( );
  } 
  
  public SubTotal getSubTotal( int index )
  {
    return subTotals.get( index );
  }
  
  public String toString( )
  {
    String result = "List: ";
    for( SubTotal current : subTotals )
    {
      result += current.toString( ) + " ";
    }
    return result;
  }
  
  public void clearSubTotals( )
  {
    subTotals.clear( );
  }
  
  public boolean isEmpty( )
  {
    return subTotals.size( ) == 0;
  }

}