import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.TilePane; 
import javafx.stage.Stage;

public class Tile extends Application {
	public void start(Stage stage) {    
 
	      TilePane tilePane = new TilePane();   
	       
	      tilePane.setOrientation(Orientation.HORIZONTAL); 
	       
	      tilePane.setTileAlignment(Pos.CENTER_LEFT); 
	       
	      tilePane.setPrefRows(4);  
	
	      ObservableList list = tilePane.getChildren(); 
	
	      list.addAll(buttons);
	
	      Scene scene = new Scene(tilePane);  
	   
	      stage.setTitle("Countdown"); 
	    
	      stage.setScene(scene); 
	  
	      stage.show(); 
	   } 
	   public static void main(String args[]){ 
	      launch(args); 
	   }
	private static void launch(String[] args) {
		
	} 
}

