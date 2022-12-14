package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DeployPlayerShip {
	
	int horizontalBorder;
	int verticalBorder;
	int type;
	int xCor;
	int yCor;
    int navigation;
    int Shipblocks;
    Rectangle cellaki = new Rectangle();
    List<Integer> listOfxCors = new ArrayList<Integer>();
    List<Integer> listOfyCors = new ArrayList<Integer>();
    List<Integer> listOfTypes=new ArrayList<Integer>();
    int map[][] = new int[10][10];
    
    public GridPane PlacePlayerShip(GridPane gp, int type, int xCor, int yCor, int navigation) {
    	
    	/*
		 * This method places the players ships in the ocean
		 * @param type : type of ship
		 * @param xCor : row cordinate of the ship
		 * @param yCor : column cordinate of the ship
		 * @param navigation : 1 -> horizontal || 2-> vertical
		 * @param cellaki : rectangle to change the color
		 * 
		 */
    	
    	//OversizeException
    	try {
        	if(xCor>9 || xCor<0 || yCor>9 || yCor<0) {
        		throw new OversizeException();
        	}	
    	}
    	catch(OversizeException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	//InvalidCountException
    	try {
    		//listOfTypes.add(type);
    		for(int m=0; m<listOfTypes.size(); m++) {
    			if(type == listOfTypes.get(m)) {
    				throw new InvalidCountException();
    			}
    		}
    	}
    	catch(InvalidCountException e) {
    		System.out.println(e.getMessage());
    	}
    	listOfTypes.add(type);
    	
    	int map[][] = new int[10][10];
    	for(int i=0; i<10; i++) {
    		for(int j=0; j<10; j++) {
    			map[i][j] = 0;
    		}
    	}

/*Carrier*/    	
    	if (type == 1) {//Carrier
    		this.Shipblocks = 5; 
    	    
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			//OverlapTilesException
        			try {
        			cellaki = (Rectangle) gp.getChildren().get(10*xCor + step + yCor);
        			//cellaki.setStyle("-fx-fill:purple;-fx-stroke:black;-fx-stroke-width:1;");
        			for(int n=0; n<listOfxCors.size(); n++) {
            			if(xCor == listOfxCors.get(n) || (step + yCor) == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:purple;-fx-stroke:black;-fx-stroke-width:1;");
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
            		try {
            		cellaki = (Rectangle) gp.getChildren().get(10*(step +xCor) + yCor);
        			//cellaki.setStyle("-fx-fill:purple;-fx-stroke:black;-fx-stroke-width:1;");
            		for(int n=0; n<listOfxCors.size(); n++) {
            			if((step +xCor) == listOfxCors.get(n) || yCor == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
            		cellaki.setStyle("-fx-fill:purple;-fx-stroke:black;-fx-stroke-width:1;");
        		}
        		
        	}
    	}
    	
/*Battleship*/
    	if (type == 2) {//Battleship
    		this.Shipblocks = 4; 
        	
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			try {
        			cellaki = (Rectangle) gp.getChildren().get(10*xCor +yCor+ step);
        			for(int n=0; n<listOfxCors.size(); n++) {
            			if(xCor == listOfxCors.get(n) || (step + yCor) == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:grey;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
            		try {
            		cellaki = (Rectangle) gp.getChildren().get(10*(step +xCor) + yCor);
            		for(int n=0; n<listOfxCors.size(); n++) {
            			if((step +xCor) == listOfxCors.get(n) || yCor == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:grey;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        		
        	}
    	}
    	
/*Cruiser*/
    	if (type == 3) {//Cruiser
    		this.Shipblocks = 3; 
        	
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			try {
        			cellaki = (Rectangle) gp.getChildren().get(10*xCor + step+yCor);
        			for(int n=0; n<listOfxCors.size(); n++) {
            			if(xCor == listOfxCors.get(n) || (step + yCor) == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:orange;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
            		try {
            		cellaki = (Rectangle) gp.getChildren().get(10*(step +xCor) + yCor);
            		for(int n=0; n<listOfxCors.size(); n++) {
            			if((step +xCor) == listOfxCors.get(n) || yCor == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:orange;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        		
        	}
    	}
    	
/*Submarine*/
    	if (type == 4) {//Submarine
    		this.Shipblocks = 3; 
   
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			try {
        			cellaki = (Rectangle) gp.getChildren().get(10*xCor + step + yCor);
        			for(int n=0; n<listOfxCors.size(); n++) {
            			if(xCor == listOfxCors.get(n) || (step + yCor) == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:yellow;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
            		try {
            		cellaki = (Rectangle) gp.getChildren().get(10*(step +xCor) + yCor);
            		for(int n=0; n<listOfxCors.size(); n++) {
            			if((step +xCor) == listOfxCors.get(n) || yCor == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:yellow;-fx-stroke:black;-fx-stroke-width:1;");
        			
        		}
        		
        	}
    	}
    	
/*Destroyer*/
    	if (type == 5) {//Destroyer
    		this.Shipblocks = 2; 
        	
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			try {
        			cellaki = (Rectangle) gp.getChildren().get(10*xCor + step + yCor);
        			for(int n=0; n<listOfxCors.size(); n++) {
            			if(xCor == listOfxCors.get(n) || (step + yCor) == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:green;-fx-stroke:black;-fx-stroke-width:1;");	
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
            		try {
            		cellaki = (Rectangle) gp.getChildren().get(10*(step +xCor) + yCor);
            		for(int n=0; n<listOfxCors.size(); n++) {
            			if((step +xCor) == listOfxCors.get(n) || yCor == listOfyCors.get(n) ) {
        				throw new OverlapTilesException();
        			    }
        			  }
        			}
        			catch (OverlapTilesException e) {
        				System.out.println(e.getMessage());
        			}
        			cellaki.setStyle("-fx-fill:green;-fx-stroke:black;-fx-stroke-width:1;");
        		}
        		
        	}	
        	
    	}
    	listOfxCors.add(xCor);
    	listOfyCors.add(yCor);
    	
		return gp;
    }
    
    public int[][] pinakasTimwn(int[][] map,int type, int xCor, int yCor, int navigation) {
		
    	this.type = type;
    	this.xCor = xCor;
    	this.yCor = yCor;
    	this.navigation = navigation;
    	
/*Carrier*/    	
    	if (type == 1) {//Carrier
    		this.Shipblocks = 5; 
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			map[xCor][step + yCor] = type;
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
        			map[step +xCor][step + yCor] = type;
        		}
        		
        	}
    	}
    	
/*Battleship*/
    	if (type == 2) {//Battleship
    		this.Shipblocks = 4; 
        	
        	//Rectangle cellaki = new Rectangle();
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			map[xCor][step + yCor] = type;
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
        			map[step +xCor][yCor] = type;
        		}
        		
        	}
    	}
    	
/*Cruiser*/
    	if (type == 3) {//Cruiser
    		this.Shipblocks = 3; 
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			map[xCor][step + yCor] = type;
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
        			map[step +xCor][yCor] = type;
        		}
        		
        	}
    	}
    	
/*Submarine*/
    	if (type == 4) {//Submarine
    		this.Shipblocks = 3; 
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			map[xCor][step + yCor] = type;
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
        			map[step +xCor][yCor] = type;
        		}
        		
        	}
    	}
    	
/*Destroyer*/
    	if (type == 5) {//Destroyer
    		this.Shipblocks = 2; 
    		
        	if(navigation == 1) { //horizontal -> allazei h sthlh yCor = column
        		for(int step=0; step<Shipblocks; step++) { 
        			map[xCor][step + yCor] = type;
        		}
        	}
            if(navigation == 2) { //vertical -> allazei h grammi xCor = row
            	for(int step=0; step<Shipblocks; step++) {
        			map[step +xCor][yCor] = type;
        		}
        		
        	}
        		
        	
    	}
		return map;
    }
    
}
