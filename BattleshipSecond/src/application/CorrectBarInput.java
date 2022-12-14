package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CorrectBarInput {
	
	public boolean isInteger(TextField textField) { 
		/*
		 * This method forms the correct input for the 
		 * attack bar, in order to warn the player if
		 * he tryed to hit out of bound
		 * 
		 */

		String text = textField.getText();
		
		if(text.length() == 2) { 
			Integer.parseInt(text);
			return true;
		}
		else {
			return false;
		}      
	}

}
