/* Subtotal class
*  Anderson, Franceschi
*/

public class SubTotal
{
 private double subTotal;
 private Item item;

 public SubTotal( Item newItem, double newSubTotal )
 {
  item = newItem;
  subTotal = newSubTotal;
 }

 public double getSubTotal( )
 {
  return subTotal;
 }
 
 public Item getItem( )
 {
  return item;
 }

 public void setSubTotal( double subTotal )
 {
  if( subTotal >= 0 )
    this.subTotal = subTotal;
 }
 
 public void setItem( Item item )
 {
  this.item = item;;
 }
 
 public void addToSubTotal( double price )
 {
  this.subTotal += price;
 }
 
 public String toString( )
 {
  String result = "";
  result += item.getClass( ).getName( ) + "; " + subTotal; 
  return result;
 }

}
