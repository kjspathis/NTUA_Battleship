package application;

public class InvalidCountException extends Exception{
	
	public InvalidCountException () {
		super("Invalid ship type! This type of ship already sails in the ocean");
	}
	
	public InvalidCountException (String errorMessage) {
		super(errorMessage);
	}

}
