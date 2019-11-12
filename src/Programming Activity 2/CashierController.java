/* CashierController Class
*  Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import javafx.animation.AnimationTimer;

public class CashierController 
{
 private Item item;
 private double currentStudentSubTotal;
 
 private CashierDrawing drawing;
  
 @FXML private BorderPane bp;
 @FXML private TextField numberOfItemsInput;
 @FXML private Button checkout;
 
 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean result;
 private int numberOfItems = 3;
 
 public void initialize( )
 { 
   drawing = new CashierDrawing( );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
 }
 
 public void startPA( )
 {
   drawing.clearSubTotals( );
   drawing.reset( );
   drawing.checkout( numberOfItems );
      
   if ( ! drawing.isEmpty( ) )
   {
    item = drawing.getSubTotal( 0 ).getItem( );
    currentStudentSubTotal = drawing.getSubTotal( 0 ).getSubTotal( );
    item.setCurrentCorrectSubTotal( 0.0 );
    item.setCurrentStudentSubTotal( currentStudentSubTotal );
    item.updateCurrentCorrectSubTotal( );
    item.resetX( );
    item.setIndex( 1 );
    item.setMaxIndex( numberOfItems );
         
    startAnimation( );  
   }
 }
 
 @FXML protected void activity( ActionEvent event ) 
 {
   disableButtons( true );
   // check if input value is valid 
   boolean goodInput = false;
   try
   {
       String answer = numberOfItemsInput.getText( );
       if ( answer != null )
       {
         numberOfItems = Integer.parseInt( answer );
         if( numberOfItems >= 1 && numberOfItems <= 10 )
           goodInput = true;  
         else
           disableButtons( false );
       }
   }
   catch( Exception e )
   {
       disableButtons( false );
   }
   
   if ( goodInput )
      startPA( );
 }

 public void disableButtons( boolean state )
 {
   checkout.setDisable( state );
 }

 public void startAnimation( ) 
 {
   ItemAnimationTimer timer = new ItemAnimationTimer( );
   timer.start( );
 }
      
 private class ItemAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {         
     // update screen  
     gc.setFill( Color.rgb( 205, 205, 205 ) );   
     gc.fillRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );       
     item.draw( gc ); 
         
     if ( item.done( ) )
     {
       stop( );
       drawing.incrementIndex( );
       // get next item
       if ( ! ( drawing.done( ) ) )
       {
        double currentCorrectSubTotal = item.getCurrentCorrectSubTotal( );
        int currentIndex = item.getIndex( );
        item = drawing.getSubTotal( drawing.getIndex( ) ).getItem( );
        currentStudentSubTotal = drawing.getSubTotal( drawing.getIndex( ) ).getSubTotal( );
        item.setCurrentStudentSubTotal( currentStudentSubTotal );
        item.setCurrentCorrectSubTotal( currentCorrectSubTotal );
        item.updateCurrentCorrectSubTotal( );
        item.setIndex( currentIndex + 1 );
        item.setMaxIndex( numberOfItems );
        item.resetX( );
        startAnimation( );
       }
       else
         disableButtons( false );
      }
     
      Pause.wait( 0.05 );
      item.addToX( 2 );
   }
 }

}