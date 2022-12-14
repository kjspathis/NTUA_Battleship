package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Player {
	
	//out of boat
	String chromaBlack = "-fx-fill:black;-fx-stroke:black;-fx-stroke-width:1;" ;
	//in boat
	String chromaRed = "-fx-fill:red;-fx-stroke:black;-fx-stroke-width:1;" ;
		
	int shotRow;
	int shotColumn;
	int previousPoints = 0;
	int points = 0;
	int allPoints = 0;
	int Sinkpoints =0 ;
	int fullHealth ;
	int aliveShips = 5;
	int healthCarrier =5;
	int healthBattleship =4;
	int healthCruiser =3;
	int healthSubmarine =3;
	int healthDestroyer =2;
	double onTarget = 0.0;
	double allShots = 0.0;
	int intallShots = 0;
	double pososto = 0.0;
	int shotcounter = 0;
	boolean endgame = false;
	boolean shotLimit = false;
	
	Rectangle[][] rects = new Rectangle[10][10];
	String[] shipStatus = new String[5];
	
	//Lists for the number of shots
	List<Integer> listHitRow=new ArrayList<Integer>();
	List<Integer> listHitColumn=new ArrayList<Integer>();
	List<String> listShipType=new ArrayList<String>();
	List<String> listHitType=new ArrayList<String>();
	{
		for(int i=0; i<5; i++) {
			shipStatus[i] = new String("Untouched :)");
			//listHitRow.add(-3);
			//listHitColumn.add(-3);
			//listShipType.add("NoShipHited");
			//listHitType.add("OutOfBounsShot");
		}
		
	}
	
	
	public GridPane playerLikeAPro(GridPane gpIN,GridPane gpOUT, int shotHorizontal, int shotVertical ) {
		/*
		 * This method  
		 * 
		 */
		
		shotRow = shotHorizontal;
		shotColumn = shotVertical;
		
		//cellaki grid WITH colors
		Rectangle cellakiIN = new Rectangle();
		cellakiIN = (Rectangle) gpIN.getChildren().get(10*shotRow + shotColumn);
		Color cellakiColor = (Color) cellakiIN.getFill();
		
				
		//cellaki grid WITHOUT colors
		Rectangle cellakiOUT = new Rectangle();
		cellakiOUT = (Rectangle) gpOUT.getChildren().get(10*shotRow + shotColumn);
		
		if(cellakiColor == Color.LIGHTBLUE || cellakiColor == Color.BLACK) {
			cellakiOUT.setStyle(chromaBlack);
			cellakiIN.setStyle(chromaBlack);
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 0;
			listShipType.add("NoShipHited");
			listHitType.add("OutOfBounsShot");
		}
				
		if (cellakiColor == Color.RED) {
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points =  0;
			listShipType.add("NoShipHited");
			listHitType.add("OutOfBounsShot");
		}
		if(cellakiColor == Color.PURPLE) {//carrier -> type = 1
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			onTarget = onTarget + 1.0;
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 350;
			Sinkpoints = 1000;
			healthCarrier = healthCarrier -1;
			listShipType.add("Carrier");
			listHitType.add("SuccesShot");
			shipStatus[1-1] = new String("Damaged '_'");
			if(healthCarrier == 0) {
				points = points + Sinkpoints ; 
				aliveShips = aliveShips -1 ;
				healthCarrier = -3;
				shipStatus[1-1] = new String("Sinked x_x");
			}	
		}
		if(cellakiColor == Color.GREY) {//battleship -> type = 2
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			onTarget = onTarget + 1.0;
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 250;
			Sinkpoints = 500;
			healthBattleship--;
			listShipType.add("Battleship");
			listHitType.add("SuccesShot");
			shipStatus[2-1] = new String("Damaged '_'");
			if(healthBattleship == 0) {
				points = points + Sinkpoints ; 
				aliveShips = aliveShips -1 ;
				healthBattleship = -3;
				shipStatus[2-1] = new String("Sinked x_x");
			}	
		}
		if(cellakiColor == Color.ORANGE) {//cruiser -> type = 3
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			onTarget = onTarget + 1.0;
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 100;
			Sinkpoints = 250;
			healthCruiser--;
			listShipType.add("Cruiser");
			listHitType.add("SuccesShot");
			shipStatus[3-1] = new String("Damaged '_'");
			if(healthCruiser == 0) {
				points = points + Sinkpoints ;
				aliveShips = aliveShips -1 ;
				healthCruiser = -3;
				shipStatus[3-1] = new String("Sinked x_x");
			}	
		}
		if(cellakiColor == Color.YELLOW) {//submarine -> type = 4
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			onTarget = onTarget + 1.0;
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 100;
			healthSubmarine--;
			listShipType.add("Submarine");
			listHitType.add("SuccesShot");
			shipStatus[4-1] = new String("Damaged '_'");
			if(healthSubmarine == 0) {
			    aliveShips = aliveShips -1 ;
			    healthSubmarine = -3;
			    shipStatus[4-1] = new String("Sinked x_x");
			}
		}
		if(cellakiColor == Color.GREEN) {//destroyer -> type = 5
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			onTarget = onTarget + 1.0;
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points = 50;
			healthDestroyer--;
			listShipType.add("Destroyer");
			listHitType.add("SuccesShot");
			shipStatus[5-1] = new String("Damaged '_'");
			if(healthDestroyer == 0) {
				aliveShips = aliveShips -1 ; 
				healthDestroyer = -3;
				shipStatus[5-1] = new String("Sinked x_x");
			}
			
		//}
		//else {
		//	counter++;
			
		//}
	}
		listHitRow.add(shotRow);
		listHitColumn.add(shotColumn);
		
		this.previousPoints = this.previousPoints + points ;
		if(this.previousPoints == 5200) {
			endgame = true;
		}
		if(intallShots == 40) {
			shotLimit = true;
		}
		pososto = onTarget/allShots ;
		
		return gpOUT;
	}
	
    public int returnHitPointsPlayer(Text keimeno) {   
		
		keimeno.setText("Player's points:" + this.previousPoints);
		
		return this.previousPoints;
	}
	public int numberOfPlayerAliveShips(Text keimeno) {
		
		keimeno.setText("Number of player's active ships:" + aliveShips);
		
		return aliveShips;
	}
	public double hitRatioPlayer(Text keimeno) {
				
		keimeno.setText("Player's hit rate:" + pososto);
		
		return pososto;
	}
	
	public boolean endgameOfBattleship() {
		return endgame;
	}
	
	public String[] statusOfEnemyShips(Text keimeno1,Text keimeno2,Text keimeno3,Text keimeno4, Text keimeno5) {
		
		keimeno1.setText("Status of Carrier: " + shipStatus[1-1]);
		keimeno2.setText("Status of Battleship: " + shipStatus[2-1]);
		keimeno3.setText("Status of Cruiser: " + shipStatus[3-1]);
		keimeno4.setText("Status of Submarine: " + shipStatus[4-1]);
		keimeno5.setText("Status of Destroyer: " + shipStatus[5-1]);
		
		return shipStatus;
	}
	
	public String[] returnShipStatusPlayer() {
		return shipStatus;
	}
	
	public List<Integer> getlistHitRow() {
        return listHitRow;
    }
	
    public List<Integer> getlistHitColumn() {
        return listHitColumn;
    }
    
    public List<String> getlistShipType() {
        return listShipType;
    }
    
    public List<String> getlistHitType() {
        return listHitType;
    }
    
    public void getAllLists(Text keimeno1,Text keimeno2,Text keimeno3,Text keimeno4, Text keimeno5) {
    	
    	if(intallShots <= 5) {
    	if(intallShots == 1) {
    	keimeno1.setText("X-cordinate: "+ listHitRow.get(0) + " | Y-cordinate: " + listHitColumn.get(0) + " | Ship-Type: " + listShipType.get(0) + " | Hit-Type: " + listHitType.get(0));
		}
    	
    	if(intallShots == 2) {
        	keimeno1.setText("X-cordinate: "+ listHitRow.get(0) + " | Y-cordinate: " + listHitColumn.get(0) + " | Ship-Type: " + listShipType.get(0) + " | Hit-Type: " + listHitType.get(0));
    		keimeno2.setText("X-cordinate: "+ listHitRow.get(1) + " | Y-cordinate: " + listHitColumn.get(1) + " | Ship-Type: " + listShipType.get(1) + " | Hit-Type: " + listHitType.get(1));
    		}
    	
    	if(intallShots == 3) {
        	keimeno1.setText("X-cordinate: "+ listHitRow.get(0) + " | Y-cordinate: " + listHitColumn.get(0) + " | Ship-Type: " + listShipType.get(0) + " | Hit-Type: " + listHitType.get(0));
    		keimeno2.setText("X-cordinate: "+ listHitRow.get(1) + " | Y-cordinate: " + listHitColumn.get(1) + " | Ship-Type: " + listShipType.get(1) + " | Hit-Type: " + listHitType.get(1));
    		keimeno3.setText("X-cordinate: "+ listHitRow.get(2) + " | Y-cordinate: " + listHitColumn.get(2) + " | Ship-Type: " + listShipType.get(2) + " | Hit-Type: " + listHitType.get(2));
    		}
    	
    	if(intallShots == 4) {
        	keimeno1.setText("X-cordinate: "+ listHitRow.get(0) + " | Y-cordinate: " + listHitColumn.get(0) + " | Ship-Type: " + listShipType.get(0) + " | Hit-Type: " + listHitType.get(0));
    		keimeno2.setText("X-cordinate: "+ listHitRow.get(1) + " | Y-cordinate: " + listHitColumn.get(1) + " | Ship-Type: " + listShipType.get(1) + " | Hit-Type: " + listHitType.get(1));
    		keimeno3.setText("X-cordinate: "+ listHitRow.get(2) + " | Y-cordinate: " + listHitColumn.get(2) + " | Ship-Type: " + listShipType.get(2) + " | Hit-Type: " + listHitType.get(2));
    		keimeno4.setText("X-cordinate: "+ listHitRow.get(3) + " | Y-cordinate: " + listHitColumn.get(3) + " | Ship-Type: " + listShipType.get(3) + " | Hit-Type: " + listHitType.get(3));
    		}
    	
    	if(intallShots == 5) {
        	keimeno1.setText("X-cordinate: "+ listHitRow.get(0) + " | Y-cordinate: " + listHitColumn.get(0) + " | Ship-Type: " + listShipType.get(0) + " | Hit-Type: " + listHitType.get(0));
    		keimeno2.setText("X-cordinate: "+ listHitRow.get(1) + " | Y-cordinate: " + listHitColumn.get(1) + " | Ship-Type: " + listShipType.get(1) + " | Hit-Type: " + listHitType.get(1));
    		keimeno3.setText("X-cordinate: "+ listHitRow.get(2) + " | Y-cordinate: " + listHitColumn.get(2) + " | Ship-Type: " + listShipType.get(2) + " | Hit-Type: " + listHitType.get(2));
    		keimeno4.setText("X-cordinate: "+ listHitRow.get(3) + " | Y-cordinate: " + listHitColumn.get(3) + " | Ship-Type: " + listShipType.get(3) + " | Hit-Type: " + listHitType.get(3));
    		keimeno5.setText("X-cordinate: "+ listHitRow.get(4) + " | Y-cordinate: " + listHitColumn.get(4) + " | Ship-Type: " + listShipType.get(4) + " | Hit-Type: " + listHitType.get(4));
        	}
    	}
    	else {
    		keimeno1.setText("X-cordinate: "+ listHitRow.get(intallShots-5) + " | Y-cordinate: " + listHitColumn.get(intallShots-5) + " | Ship-Type: " + listShipType.get(intallShots-5) + " | Hit-Type: " + listHitType.get(intallShots-5));
    		keimeno2.setText("X-cordinate: "+ listHitRow.get(intallShots-4) + " | Y-cordinate: " + listHitColumn.get(intallShots-4) + " | Ship-Type: " + listShipType.get(intallShots-4) + " | Hit-Type: " + listHitType.get(intallShots-4));
    		keimeno3.setText("X-cordinate: "+ listHitRow.get(intallShots-3) + " | Y-cordinate: " + listHitColumn.get(intallShots-3) + " | Ship-Type: " + listShipType.get(intallShots-3) + " | Hit-Type: " + listHitType.get(intallShots-3));
    		keimeno4.setText("X-cordinate: "+ listHitRow.get(intallShots-2) + " | Y-cordinate: " + listHitColumn.get(intallShots-2) + " | Ship-Type: " + listShipType.get(intallShots-2) + " | Hit-Type: " + listHitType.get(intallShots-2));
    		keimeno5.setText("X-cordinate: "+ listHitRow.get(intallShots-1) + " | Y-cordinate: " + listHitColumn.get(intallShots-1) + " | Ship-Type: " + listShipType.get(intallShots-1) + " | Hit-Type: " + listHitType.get(intallShots-1));
        	}
    }
    
    public boolean shotLimit() {
    	return shotLimit;
    }
}
