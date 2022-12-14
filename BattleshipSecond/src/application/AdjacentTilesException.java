package application;

public class AdjacentTilesException extends Exception{
	
	public AdjacentTilesException () {
		super("Invalid cordinates caused ship cross another ship!");
	}
	
	public AdjacentTilesException (String errorMessage) {
		super(errorMessage);
	}

}
