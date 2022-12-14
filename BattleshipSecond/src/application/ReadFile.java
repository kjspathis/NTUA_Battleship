package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	
	int  boatType[] = new int[5];
	int xCor[] = new int[5];
	int yCor[] = new int[5];
	int navigation[] = new int[5];
	int arrayID[][] = new int[5][4];
	boolean vertical = true;
	
	public  int[][] ReadFiles (File f) {
		
		/*
		 * This method opens a txt file in the SecondBattleship folder
		 * and converts the string arguments into an array form so that
		 * it can be readable from the load method and get the game started!
		 * 
		 */

		
		Scanner myReader;
		try {
			myReader = new Scanner(f);
			int i=0;
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] grammi = data.split(",",4); 
		        boatType[i] = Integer.parseInt(grammi[0]);
		        xCor[i] = Integer.parseInt(grammi[1]);
		        yCor[i] = Integer.parseInt(grammi[2]);
		        navigation[i] = Integer.parseInt(grammi[3]);
		        //System.out.println(grammi[1]);
		        //System.out.println(xCor[i]);
		        i = i +1;
		      }
			myReader.close();
			//fill column by column
			for(int j=0; j<4; j++) {
				if(j==0) {
					for(int z=0; z<5; z++ ) {
						arrayID[z][j] = boatType[z] ;
					}
				}
				if(j==1) {
					for(int z=0; z<5; z++ ) {
						arrayID[z][j] = xCor[z] ;
					}
				}
				if(j==2) {
					for(int z=0; z<5; z++ ) {
						arrayID[z][j] = yCor[z] ;
					}
				}
				if(j==3) {
					for(int z=0; z<5; z++ ) {
						arrayID[z][j] = navigation[z] ;
					}
				}
			}
			
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrayID;
   }
}