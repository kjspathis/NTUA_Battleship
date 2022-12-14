
package application;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OversizeException extends Exception {
	
	public OversizeException () {
		super("Invalid cordinates caused ship placed out of the ocean!");
	}
	
	public OversizeException (String errorMessage) {
		super(errorMessage);
	}
			
}

