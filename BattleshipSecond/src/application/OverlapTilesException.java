package application;

public class OverlapTilesException extends Exception {
	
	public OverlapTilesException () {
		super("Invalid cordinates caused ship placed on top of another ship!");
	}
	
	public OverlapTilesException (String errorMessage) {
		super(errorMessage);
	}

}
