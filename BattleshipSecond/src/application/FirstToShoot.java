package application;

import java.util.Random;

public class FirstToShoot {
	  
    // Generate random integers in range 0 to 999 
    int playerNumber; 
    int computerNumber;
    boolean judge;
	
	public boolean Kriths() {
		
		/*
		 * **This method returns a boolean to define if the 
		 * computer or the player will start first 
		 * 
		 * ** In the line a class type Random is created 
		 * Its object is used in the playerNumber and computerNumber integer 
		 * to give random numbers from 0 to 9
		 * 
		 * **if-else to determine who player starts
		 * 
		 * @param playerNumber: int, random number between 0 and 9
		 * 
		 * @param computerNumber: int, random number between 0 and 9
		 * 
		 * @param judge: boolean, to choose which player starts
		 * 
		 * ** The method returns the boolean
		 */

		Random rand = new Random(); 
		playerNumber = rand.nextInt(10); 
	    computerNumber = rand.nextInt(10);
		
        System.out.println("playerNumber: " + playerNumber );
        System.out.println("computerNumber: " + computerNumber );
        
		if(playerNumber <= computerNumber) {
			System.out.println("The Computer starts first");
			judge = false;
			
		}
		else {
			System.out.println("The Player starts first");
			judge = true;
		}
		
		return judge;
		
	}
	

}
