package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Computer {
	
	//out of boat
	String chromaBlack = "-fx-fill:black;-fx-stroke:black;-fx-stroke-width:1;" ;
	//in boat
	String chromaRed = "-fx-fill:red;-fx-stroke:black;-fx-stroke-width:1;" ;
	
	int shotRow;
	int shotColumn;
	int previousPoints = 0;
	int fullHealth ;
	int points =0;
	int Sinkpoints =0;
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
	int mnimi[][] = new int[2][2];
	int counter = 0;
	boolean endgame=false;
	
	Rectangle cellakiInPrevious = new Rectangle();
	Rectangle cellakiOutPrevious = new Rectangle();
	//PC THINKING LOGICALLY//
	int shotRowCheckerAdd1;
	int shotRowCheckerSub1;
	int shotRowCheckerTheSame;
	int shotColumnCheckerAdd1;
	int shotColumnCheckerSub1;
	int shotColumnCheckerTheSame;
	
	Rectangle cellakiRowCheckerAdd1 = new Rectangle();
	Rectangle cellakiRowCheckerSub1 = new Rectangle();
	Rectangle cellakiColumnCheckerAdd1 = new Rectangle();
	Rectangle cellakiColumnCheckerSub1 = new Rectangle();
	
    String[] shipStatus = new String[5];
  
    //Lists for the number of shots
  	List<Integer> listHitRow=new ArrayList<Integer>();
  	List<Integer> listHitColumn=new ArrayList<Integer>();
  	List<String> listShipType=new ArrayList<String>();
  	List<String> listHitType=new ArrayList<String>();
  	List<Rectangle> listOfRectangle = new ArrayList<Rectangle>();
  	List<Color> listOfColors = new ArrayList<Color>();
  	List<Integer> checker=new ArrayList<Integer>();
  	
  	{
  		for(int i=0; i<5; i++) {
  			shipStatus[i] = new String("Untouched :)");
  			//listHitRow.add(-3);
  			//listHitColumn.add(-3);
  			//listShipType.add("NoShipHited");
  			//listHitType.add("OutOfBounsShot");
  		}
  		
  	}
	
	public GridPane computerBeast(GridPane gpIN,GridPane gpOUT) {
		
		/*
		 * This method  
		 * 
		 */
	
		this.shipStatus = shipStatus;

		//////////////////**************COMPUTER THINKING LIKE A DUMMY AGAIN************/////////////////////////ARXI
		
		if (intallShots == 0) {
		Random rand = new Random(); 
		
		shotRow = rand.nextInt(10);
		shotColumn = rand.nextInt(10);	

        //////////////////**************COMPUTER THINKING LIKE A DUMMY AGAIN************/////////////////////////TELOS
		
		//cellaki grid WITH colors
		Rectangle cellakiIN = new Rectangle();
		cellakiIN = (Rectangle) gpIN.getChildren().get(10*shotRow + shotColumn);
		Color cellakiColor = (Color) cellakiIN.getFill();
		cellakiInPrevious = cellakiIN;
		
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
			checker.add(0);
		}
		if (cellakiColor == Color.RED) {
			cellakiOUT.setStyle(chromaRed);	
			cellakiIN.setStyle(chromaRed);
			allShots = allShots + 1.0 ;
			intallShots = intallShots + 1;
			points =  0;
			listShipType.add("NoShipHited");
			listHitType.add("OutOfBounsShot");
			checker.add(0);
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
			listHitType.add("SuccessShot");
			shipStatus[1-1] = new String("Damaged");
			checker.add(1);
			if(healthCarrier == 0) {
				points = points + Sinkpoints ; 
				aliveShips = aliveShips -1 ;
				healthCarrier = -3;
				shipStatus[1-1] = new String("Sinked");
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
			listHitType.add("SuccessShot");
			shipStatus[2-1] = new String("Damaged");
			checker.add(1);
			if(healthBattleship == 0) {
				points = points + Sinkpoints ; 
				aliveShips = aliveShips -1 ;
				healthBattleship = -3;
				shipStatus[2-1] = new String("Sinked");
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
			listHitType.add("SuccessShot");
			shipStatus[3-1] = new String("Damaged");
			checker.add(1);
			if(healthCruiser == 0) {
				points = points + Sinkpoints ;
				aliveShips = aliveShips -1 ;
				healthCruiser = -3;
				shipStatus[3-1] = new String("Sinked");
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
			listHitType.add("SuccessShot");
			shipStatus[4-1] = new String("Damaged");
			checker.add(1);
			if(healthSubmarine == 0) {
			    aliveShips = aliveShips -1 ;
			    healthSubmarine = -3;
			    shipStatus[4-1] = new String("Sinked");
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
			listHitType.add("SuccessShot");
			shipStatus[5-1] = new String("Damaged");
			checker.add(1);
			if(healthDestroyer == 0) {
				aliveShips = aliveShips -1 ; 
				healthDestroyer = -3;
				shipStatus[5-1] = new String("Sinked");
			}
			
	}
		
		listHitRow.add(shotRow);
		listHitColumn.add(shotColumn);
		
		this.previousPoints = this.previousPoints + points ;
		if(this.previousPoints == 5200) {
			endgame = true;
		}
		pososto = onTarget/allShots ;
		
		} // edw kleinei h if (intallShots == 0) gia thn 1h fora
 
		else {
			if(checker.get(intallShots-1) == 0) {
				
            //////////////////**************COMPUTER THINKING LIKE A DUMMY AGAIN************/////////////////////////ARXI
			Random rand = new Random(); 
			
			shotRow = rand.nextInt(10);
			shotColumn = rand.nextInt(10);	

	        //////////////////**************COMPUTER THINKING LIKE A DUMMY AGAIN************/////////////////////////TELOS
			
			//cellaki grid WITH colors
			Rectangle cellakiIN = new Rectangle();
			cellakiIN = (Rectangle) gpIN.getChildren().get(10*shotRow + shotColumn);
			Color cellakiColor = (Color) cellakiIN.getFill();
			cellakiInPrevious = cellakiIN;
			
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
				checker.add(0);
			}
			if (cellakiColor == Color.RED) {
				cellakiOUT.setStyle(chromaRed);	
				cellakiIN.setStyle(chromaRed);
				allShots = allShots + 1.0 ;
				intallShots = intallShots + 1;
				points =  0;
				listShipType.add("NoShipHited");
				listHitType.add("OutOfBounsShot");
				checker.add(0);
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
				listHitType.add("SuccessShot");
				shipStatus[1-1] = new String("Damaged");
				checker.add(1);
				if(healthCarrier == 0) {
					points = points + Sinkpoints ; 
					aliveShips = aliveShips -1 ;
					healthCarrier = -3;
					shipStatus[1-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[2-1] = new String("Damaged");
				checker.add(1);
				if(healthBattleship == 0) {
					points = points + Sinkpoints ; 
					aliveShips = aliveShips -1 ;
					healthBattleship = -3;
					shipStatus[2-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[3-1] = new String("Damaged");
				checker.add(1);
				if(healthCruiser == 0) {
					points = points + Sinkpoints ;
					aliveShips = aliveShips -1 ;
					healthCruiser = -3;
					shipStatus[3-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[4-1] = new String("Damaged");
				checker.add(1);
				if(healthSubmarine == 0) {
				    aliveShips = aliveShips -1 ;
				    healthSubmarine = -3;
				    shipStatus[4-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[5-1] = new String("Damaged");
				checker.add(1);
				if(healthDestroyer == 0) {
					aliveShips = aliveShips -1 ; 
					healthDestroyer = -3;
					shipStatus[5-1] = new String("Sinked");
				}
				
		}
			
			listHitRow.add(shotRow);
			listHitColumn.add(shotColumn);
			
			this.previousPoints = this.previousPoints + points ;
			if(this.previousPoints == 5200) {
				endgame = true;
			}
			pososto = onTarget/allShots ;
			} // edw kleinei h if(checker.get(intallShots-1) == 0) pou leei oti o pc brickarei
			
			else if(checker.get(intallShots-1) == 1) {
				
			    //////////////////**************COMPUTER THINKING LOGICALLY add 1 to row************/////////////////////////ARXI
				
				
				                           /////***LETS START WITH ADD 1 IN ROW***///////////ARXI
				
				shotRowCheckerAdd1 = listHitRow.get(intallShots -1) + 1 ;
				shotColumnCheckerTheSame = listHitColumn.get(intallShots -1);
			
			    cellakiRowCheckerAdd1 = (Rectangle) gpIN.getChildren().get(10*shotRowCheckerAdd1 + shotColumnCheckerTheSame);
			    Color cellakiChromaRowCheckerAdd1 = (Color) cellakiRowCheckerAdd1.getFill();	
			                           /////***LETS START WITH ADD 1 IN ROW***///////////TELOS
			    
			                          /////***LETS START WITH CHECKING ADD 1 IN ROW***///////////ARXI
			    if(cellakiChromaRowCheckerAdd1 != Color.LIGHTBLUE && cellakiChromaRowCheckerAdd1 != Color.BLACK && cellakiChromaRowCheckerAdd1 != Color.RED) {
			    	shotRow = shotRowCheckerAdd1;
			    	shotColumn = shotColumnCheckerTheSame;
			    }
			                             /////***LETS START WITH CHECKING ADD 1 IN ROW***///////////TELOS
			
			    
			                              /////***LETS CHECK WITH SUB 1 IN ROW***///////////ARXI
				
							shotRowCheckerSub1 = listHitRow.get(intallShots -1) - 1 ;
							shotColumnCheckerTheSame = listHitColumn.get(intallShots -1);
						
						    cellakiRowCheckerSub1 = (Rectangle) gpIN.getChildren().get(10*shotRowCheckerSub1 + shotColumnCheckerTheSame);
						    Color cellakiChromaRowCheckerSub1 = (Color) cellakiRowCheckerSub1.getFill();	
						                           /////***LETS START WITH SUB 1 IN ROW***///////////TELOS
						    
						                          /////***LETS START WITH CHECKING SUB 1 IN ROW***///////////ARXI
						    if(cellakiChromaRowCheckerSub1 != Color.LIGHTBLUE && cellakiChromaRowCheckerSub1 != Color.BLACK && cellakiChromaRowCheckerSub1 != Color.RED) {
						    	shotRow = shotRowCheckerSub1;
						    	shotColumn = shotColumnCheckerTheSame;
						    }
						                             /////***LETS START WITH CHECKING SUB 1 IN ROW***///////////TELOS
						    
						                             /////***LETS CHECK WITH ADD 1 IN COLUMN***///////////ARXI
							
							shotRowCheckerTheSame = listHitRow.get(intallShots -1) ;
							shotColumnCheckerAdd1 = listHitColumn.get(intallShots -1) + 1;
						
						    cellakiColumnCheckerAdd1 = (Rectangle) gpIN.getChildren().get(10*shotRowCheckerTheSame + shotColumnCheckerAdd1);
						    Color cellakiChromaColumnCheckerAdd1 = (Color) cellakiColumnCheckerAdd1.getFill();	
						                           /////***LETS START WITH ADD 1 IN COLUMN***///////////TELOS
						    
						                          /////***LETS START WITH CHECKING ADD 1 IN COLUMN***///////////ARXI
						    if(cellakiChromaColumnCheckerAdd1 != Color.LIGHTBLUE && cellakiChromaColumnCheckerAdd1 != Color.BLACK && cellakiChromaColumnCheckerAdd1 != Color.RED) {
						    	shotRow = shotRowCheckerTheSame;
						    	shotColumn = shotColumnCheckerAdd1;
						    }
						                             /////***LETS START WITH CHECKING ADD 1 IN COLUMN***///////////TELOS
						    
	                                                /////***LETS CHECK WITH SUB 1 IN COLUMN***///////////ARXI
							
								shotRowCheckerTheSame = listHitRow.get(intallShots -1) ;
								shotColumnCheckerSub1 = listHitColumn.get(intallShots -1) - 1;
							
							    cellakiColumnCheckerSub1 = (Rectangle) gpIN.getChildren().get(10*shotRowCheckerTheSame + shotColumnCheckerSub1);
							    Color cellakiChromaColumnCheckerSub1 = (Color) cellakiColumnCheckerSub1.getFill();	
							                           /////***LETS START WITH SUB 1 IN COLUMN***///////////TELOS
							    
							                          /////***LETS START WITH CHECKING SUB 1 IN COLUMN***///////////ARXI
							    if(cellakiChromaColumnCheckerSub1 != Color.LIGHTBLUE && cellakiChromaColumnCheckerSub1 != Color.BLACK && cellakiChromaColumnCheckerSub1 != Color.RED) {
							    	shotRow = shotRowCheckerTheSame;
							    	shotColumn = shotColumnCheckerSub1;
							    }
							                             /////***LETS START WITH CHECKING SUB 1 IN COLUMN***///////////TELOS
						    

	        //////////////////**************COMPUTER THINKING LOGICALLY add 1 to row************/////////////////////////TELOS
			
			//cellaki grid WITH colors
			Rectangle cellakiIN = new Rectangle();
			cellakiIN = (Rectangle) gpIN.getChildren().get(10*shotRow + shotColumn);
			Color cellakiColor = (Color) cellakiIN.getFill();
			cellakiInPrevious = cellakiIN;
			
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
				checker.add(0);
			}
			if (cellakiColor == Color.RED) {
				cellakiOUT.setStyle(chromaRed);	
				cellakiIN.setStyle(chromaRed);
				allShots = allShots + 1.0 ;
				intallShots = intallShots + 1;
				points =  0;
				listShipType.add("NoShipHited");
				listHitType.add("OutOfBounsShot");
				checker.add(0);
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
				listHitType.add("SuccessShot");
				shipStatus[1-1] = new String("Damaged");
				checker.add(1);
				if(healthCarrier == 0) {
					points = points + Sinkpoints ; 
					aliveShips = aliveShips -1 ;
					healthCarrier = -3;
					shipStatus[1-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[2-1] = new String("Damaged");
				checker.add(1);
				if(healthBattleship == 0) {
					points = points + Sinkpoints ; 
					aliveShips = aliveShips -1 ;
					healthBattleship = -3;
					shipStatus[2-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[3-1] = new String("Damaged");
				checker.add(1);
				if(healthCruiser == 0) {
					points = points + Sinkpoints ;
					aliveShips = aliveShips -1 ;
					healthCruiser = -3;
					shipStatus[3-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[4-1] = new String("Damaged");
				checker.add(1);
				if(healthSubmarine == 0) {
				    aliveShips = aliveShips -1 ;
				    healthSubmarine = -3;
				    shipStatus[4-1] = new String("Sinked");
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
				listHitType.add("SuccessShot");
				shipStatus[5-1] = new String("Damaged");
				checker.add(1);
				if(healthDestroyer == 0) {
					aliveShips = aliveShips -1 ; 
					healthDestroyer = -3;
					shipStatus[5-1] = new String("Sinked");
				}
				
		}
			
			listHitRow.add(shotRow);
			listHitColumn.add(shotColumn);
			
			this.previousPoints = this.previousPoints + points ;
			if(this.previousPoints == 5200) {
				endgame = true;
			}
			pososto = onTarget/allShots ;
			
			}// edw kleinei h else (checker.get(intallShots-1) == 1) poy leei oti o pc ebale to prwto kalathi
			
			
			
		}// edw kleinei h else (intallShots > 0) 
		 
		return gpOUT;
	}
	
	public int returnHitPointsComputer(Text keimeno) {   
		
		keimeno.setText("Computer's points:" + this.previousPoints);
		
		return this.previousPoints;
	}
	public int numberOfComputerAliveShips(Text keimeno) {
		
		keimeno.setText("Number of computer's active ships:" + aliveShips);
		
		return aliveShips;
	}
	public double hitRatioComputer(Text keimeno) {
				
		keimeno.setText("Computer's hit rate:" + pososto);
		
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
}
