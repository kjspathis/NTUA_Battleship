package application;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class OceanMapCreator {
		
	Rectangle[][] rects = new Rectangle[10][10];
	
	int border = 10;
	
	Text textHelp = new Text(" ");
	
	public GridPane GridCreator(GridPane gp) {
		
		/*
		 * This method creates the Ocean map for each player
		 * A text is used to surrond the ocean with cell-indexs 
		 * The ocean is created as a grid and added to the Vbox
		 * 
		 */
		
		//gp.add(textHelp,0, 0);
        Text[] keimeno = new Text[border];
        
        //Display the polypothto grid        
		for (int sthlh = 0; sthlh < border; sthlh++) { 
			for (int grammi = 0; grammi < border; grammi++) {
				rects[grammi][sthlh] = new Rectangle(23,23,23,23);
				rects[grammi][sthlh].setStyle("-fx-fill: LightBlue; -fx-stroke: black; -fx-stroke-width: 1;"); 
				gp.add(rects[grammi][sthlh], grammi, sthlh);
	       }
	    }
		
		//Display numbers horizontally 
        for(int grammi=0; grammi<border; grammi++) {
            keimeno[grammi] = new Text(String.valueOf(grammi));
            //keimeno[grammi].setTextAlignment(TextAlignment.CENTER);
            gp.add(keimeno[grammi], 10, grammi) ; 
        }
        
		//Display numbers vertically 
        for(int sthlh=0; sthlh<border; sthlh++) {
            keimeno[sthlh] = new Text(String.valueOf(sthlh));
           // keimeno[sthlh].setTextAlignment(TextAlignment.CENTER);
            gp.add(keimeno[sthlh], sthlh, 10) ; 
        }
		//gp.setAlignment(Pos.BOTTOM_CENTER);
		return gp;
	}
	
}



