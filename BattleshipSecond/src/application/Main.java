package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle; //Line, Rectangle,Polygon
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import java.util.Scanner;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Main extends Application {
	
	int arrayShipIDPlayer[][] = new int[5][4];
	int arrayShipIDComputer[][] = new int[5][4];
	int startLoop = 0;
	MenuItem menuItem1 = new MenuItem("Start");
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Battleship Medialab");
		
		//create the general (1st) menu bar 
        MenuBar menu1 = new MenuBar();
        
        ///////////////////////*MENU APPLICATIONS*//////////////////ARXI
        
        //create the 2st menu 
        Menu menu2 = new Menu("Application");
        menu2.setGraphic(new ImageView("file:ship4.jpg")); //add an icon-image
        
        
        
        //start item
        //MenuItem menuItem1 = new MenuItem("Start"); //create 1st item
        menu2.getItems().add(menuItem1);
        menuItem1.setGraphic(new ImageView("file:start2.jpg"));
        
        //////////////////***************START-LOOP-WITH-THE-INT=0***************/////////////////////ARXI (L73-L663)
        
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent t) { 
        		
        		primaryStage.setTitle("Battleship Medialab");
        		
        		//create the general (1st) menu bar 
                MenuBar menu1 = new MenuBar();
                
                ///////////////////////*MENU APPLICATIONS*//////////////////ARXI
                
                //create the 2st menu 
                Menu menu2 = new Menu("Application");
                menu2.setGraphic(new ImageView("file:ship4.jpg")); //add an icon-image
                
                //start item
                //MenuItem menuItem1 = new MenuItem("Start"); //create 1st item
                menu2.getItems().add(menuItem1);
                menuItem1.setGraphic(new ImageView("file:start2.jpg"));
        		
        		//load item
                MenuItem menuItem2 = new MenuItem("Load"); //create 2nd item
                menu2.getItems().add(menuItem2);
                menuItem2.setGraphic(new ImageView("file:load1.jpg"));
                
                //exit item
                MenuItem menuItem3 = new MenuItem("Exit"); //create 3rd item
                menu2.getItems().add(menuItem3);
                menuItem3.setGraphic(new ImageView("file:exit.png"));
                menuItem3.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent t) { 
                    System.exit(0);
                	}
                 });
                
                ///////////////////////*MENU APPLICATIONS*//////////////////TELOS
                
                ///////////////////////*MENU DETAILS*//////////////////ARXI
                
                //create the 3rd menu Details
                Menu menu3 = new Menu("Details");
                menu3.setGraphic(new ImageView("file:details3.jpg")); //add an icon-image
                
                //enemy ships item
                MenuItem menuItem4 = new MenuItem("Enemy ships "); //create 1st item
                menu3.getItems().add(menuItem4);
                menuItem4.setGraphic(new ImageView("file:pirate2.jpg"));
                //General texts for the enemy ships item
        		Text textEnemyShips1 = new Text("Status of computer's ships:");
                textEnemyShips1.setStyle("-fx-font: 23 arial;");
                textEnemyShips1.setFill(Color.DARKORANGE);
                //Carrier text
        		Text textCarrier = new Text("Status of Carrier: ");
                textCarrier.setStyle("-fx-font: 23 arial;");
                textCarrier.setFill(Color.DARKORANGE);
                //Battleship text
        		Text textBattleship = new Text("Status of Battleship: ");
                textBattleship.setStyle("-fx-font: 23 arial;");
                textBattleship.setFill(Color.DARKORANGE);
                //Cruiser text
        		Text textCruiser = new Text("Status of Cruiser: ");
                textCruiser.setStyle("-fx-font: 23 arial;");
                textCruiser.setFill(Color.DARKORANGE);
                //Submarine text
        		Text textSubmarine = new Text("Status of Submarine: ");
                textSubmarine.setStyle("-fx-font: 23 arial;");
                textSubmarine.setFill(Color.DARKORANGE);
                //Destroyer text
        		Text textDestroyer = new Text("Status of Destroyer: ");
                textDestroyer.setStyle("-fx-font: 23 arial;");
                textDestroyer.setFill(Color.DARKORANGE);
                
                //player shots item
                MenuItem menuItem5 = new MenuItem("Player shots"); //create 2nd item
                menu3.getItems().add(menuItem5);
                menuItem5.setGraphic(new ImageView("file:target.jpg"));
                //General texts for the player shots item
        		Text textPlayerShots = new Text("Last 5 player's shots: ");
                textPlayerShots.setStyle("-fx-font: 23 arial;");
                textPlayerShots.setFill(Color.DARKORANGE);
                //last5
                Text last5player = new Text();
                last5player.setStyle("-fx-font: 23 arial;");
                last5player.setFill(Color.DARKORANGE);
                //last4
                Text last4player = new Text();
                last4player.setStyle("-fx-font: 23 arial;");
                last4player.setFill(Color.DARKORANGE);
                //last3
                Text last3player = new Text();
                last3player.setStyle("-fx-font: 23 arial;");
                last3player.setFill(Color.DARKORANGE);
                //last2
                Text last2player = new Text();
                last2player.setStyle("-fx-font: 23 arial;");
                last2player.setFill(Color.DARKORANGE);
                //last1
                Text last1player = new Text();
                last1player.setStyle("-fx-font: 23 arial;");
                last1player.setFill(Color.DARKORANGE);
                
                //enemy shots item
                MenuItem menuItem6 = new MenuItem("Enemy shots "); //create 3rd item
                menu3.getItems().add(menuItem6);
                menuItem6.setGraphic(new ImageView("file:cannon.jpg"));
                //General texts for the enemy shots item
        		Text textComputerShots = new Text("Last 5 player's shots: ");
                textComputerShots.setStyle("-fx-font: 23 arial;");
                textComputerShots.setFill(Color.DARKORANGE);
                //last5
                Text last5computer = new Text();
                last5computer.setStyle("-fx-font: 23 arial;");
                last5computer.setFill(Color.DARKORANGE);
                //last4
                Text last4computer = new Text();
                last4computer.setStyle("-fx-font: 23 arial;");
                last4computer.setFill(Color.DARKORANGE);
                //last3
                Text last3computer = new Text();
                last3computer.setStyle("-fx-font: 23 arial;");
                last3computer.setFill(Color.DARKORANGE);
                //last2
                Text last2computer = new Text();
                last2computer.setStyle("-fx-font: 23 arial;");
                last2computer.setFill(Color.DARKORANGE);
                //last1
                Text last1computer = new Text();
                last1computer.setStyle("-fx-font: 23 arial;");
                last1computer.setFill(Color.DARKORANGE);
                
                ///////////////////////*MENU DETAILS*//////////////////TELOS
                
                ///////////////////////*Helper TEXTS for the correct play*//////////////////ARXI
        		
        		//helper texts to make the game look cooler ;)
                Text myOcean = new Text("Player's Ocean Map");
                myOcean.setStyle("-fx-font: 23 arial;");
                myOcean.setFill(Color.MIDNIGHTBLUE);
                Text computerOcean = new Text("Computer's Ocean Map");
                computerOcean.setStyle("-fx-font: 23 arial;");
                computerOcean.setFill(Color.MAROON);
                Text textHelp = new Text(" ");
                Text textHelp2 = new Text(" ");
                Text textHelp3 = new Text(" ");
                Text textHelp4 = new Text(" ");
                
                ///////////////////////*Helper TEXTS for the correct play*//////////////////TELOS
                
                ///////////////////////*Helper Grids for the correct play*//////////////////ARXI
           
                //ocean for the computer
                GridPane gridPlayersEnemy = new GridPane();
                OceanMapCreator creatorGridPlayersEnemy = new OceanMapCreator();
                gridPlayersEnemy = creatorGridPlayersEnemy.GridCreator(gridPlayersEnemy);

                //ocean for the computer attack board
                GridPane computerAttackBoard = new GridPane();
                OceanMapCreator creatorcomputerAttackBoard = new OceanMapCreator();
                computerAttackBoard = creatorcomputerAttackBoard.GridCreator(computerAttackBoard);

                ///////////////////////*Helper Grids for the correct play*//////////////////TELOS
                
                ///////////////////////*create down right boxaki4*///////////////////////ARXI
                //define which player starts
                boolean firstPlayer;
                FirstToShoot judge = new FirstToShoot();
                firstPlayer = judge.Kriths();
              	Text textFirstPlayer = new Text("Is Player first to shoot? [Y/n]: " + firstPlayer);
                textFirstPlayer.setStyle("-fx-font: 23 arial;");
                textFirstPlayer.setFill(Color.GOLDENROD);
                VBox boxaki4 = new VBox(textFirstPlayer);
                boxaki4.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
                //boxaki4 .setAlignment(Pos.TOP_RIGHT);
                boxaki4.setPrefSize(360, 360);

                ///////////////////////*create down right boxaki4*///////////////////////TELOS

                ///////////////////////*create upper left boxaki1*/////////////////////////BEGIN
        		//Player's Texts
                //ocean for the player 
                GridPane gridPlayerHis = new GridPane();
                OceanMapCreator creatorGridPlayerHis = new OceanMapCreator();
                gridPlayerHis = creatorGridPlayerHis.GridCreator(gridPlayerHis);
                
                /*DeployPlayerShips*/
        		DeployPlayerShip greetingPlayerScenario = new DeployPlayerShip();
        		for(int line=0; line<5; line++) {
        			gridPlayerHis = greetingPlayerScenario.PlacePlayerShip(gridPlayerHis, arrayShipIDPlayer[line][0], arrayShipIDPlayer[line][1], arrayShipIDPlayer[line][2], arrayShipIDPlayer[line][3]);
        			}
        		
        		/*Texts for Player*/
        		//1st text
                Text textAs1 = new Text("Number of player's active ships:");
                textAs1.setStyle("-fx-font: 23 arial;");
                textAs1.setFill(Color.MIDNIGHTBLUE);
                textAs1.setX(500);
                textAs1.setY(250);
                //2nd text
                Text textPp1 = new Text("Player's points:");
                textPp1.setStyle("-fx-font: 23 arial;");
                textPp1.setFill(Color.MIDNIGHTBLUE);
                //3rd text
                Text textHr1 = new Text("Player's hit rate: ");
                textHr1.setStyle("-fx-font: 23 arial;");
                textHr1.setFill(Color.MIDNIGHTBLUE);
                
                VBox boxaki1 = new VBox();
                boxaki1.getChildren().addAll(menu1,textAs1,textPp1,textHr1,myOcean,gridPlayerHis);
                boxaki1.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
                //boxaki2.setAlignment(Pos.TOP_LEFT);
                boxaki1.setPrefSize(930, 930);
                
                ///////////////////////*create upper left boxaki1*/////////////////////////TELOS
                
                ///////////////////////*create upper right boxaki2*///////////////////////ARXI
                
                //Computer's Texts
                
                //ocean for the computer attack board
                GridPane playerAttackBoard = new GridPane();
                OceanMapCreator creatorplayerAttackBoard = new OceanMapCreator();
                playerAttackBoard = creatorplayerAttackBoard.GridCreator(playerAttackBoard);
                
                /*DeployComputerShips*/
        		DeployComputerShip greetingComputerScenario = new DeployComputerShip();
        		for(int line=0; line<5; line++) {
        			gridPlayersEnemy = greetingComputerScenario.PlaceComputerShip(gridPlayersEnemy, arrayShipIDComputer[line][0], arrayShipIDComputer[line][1], arrayShipIDComputer[line][2], arrayShipIDComputer[line][3]);
        		}      
        		
        		/*Texts for Computer*/
                //1st text
                Text textAs2 = new Text("Number of computer's active ships:");
                textAs2.setStyle("-fx-font: 23 arial;");
                textAs2.setFill(Color.MAROON);
                textAs2.setX(500);
                textAs2.setY(250);
                //2nd text
                Text textPp2 = new Text("Computer's points:");
                textPp2.setStyle("-fx-font: 23 arial;");
                textPp2.setFill(Color.MAROON);
                //3rd text
                Text textHr2 = new Text("Computer's hit rate: ");
                textHr2.setStyle("-fx-font: 23 arial;");
                textHr2.setFill(Color.MAROON);
        		
                VBox boxaki2 = new VBox();
                boxaki2.getChildren().addAll(textHelp,textHelp2,textAs2,textPp2,textHr2,computerOcean,playerAttackBoard);
                boxaki2.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
                //boxaki3 .setAlignment(Pos.TOP_RIGHT);
                boxaki2.setPrefSize(930, 930);
                
                ///////////////////////*create upper right boxaki2*///////////////////////TELOS
                
                ///////////////////////*create down left boxaki3*////////////////////////ARXI
                final Label labelAttack = new Label("Choose your next shot wisely:");
                TextField epithesi = new TextField();
                CorrectBarInput sostoInput = new CorrectBarInput();
                epithesi.setPrefColumnCount(15);
                epithesi.setPromptText("Place rows-columns (ex: 23)");
                //input scanner 
                //Scanner getIn = new Scanner(System.in);
                ///***Methods to use in Submit***/// 
                Player einstein = new Player();
                Computer pc = new Computer();
                //Adding a Label
                final Label labelExplanation = new Label(); 
                //final GridPanes
                final GridPane finalgridPlayersEnemy = gridPlayersEnemy;
                final GridPane finalplayerAttackBoard = playerAttackBoard;
                final GridPane finalgridPlayerHis = gridPlayerHis;
                final GridPane finalcomputerAttackBoard = computerAttackBoard;
                HBox barAttack = new HBox();
                
                //Defining the Submit button
                Button submit = new Button("Submit");
                if(!firstPlayer) {
        			                 ////////****COMPUTER FIRST TURN****////////////ARXI
                   pc.computerBeast(finalgridPlayerHis,finalcomputerAttackBoard);
                   pc.numberOfComputerAliveShips(textAs1);
                   pc.returnHitPointsComputer(textPp2);
                   pc.hitRatioComputer(textHr2);
                   pc.getAllLists(last5computer,last4computer,last3computer,last2computer,last1computer);
                                      ////////****COMPUTER TURN****////////////TELOS
        		}
                submit.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent e) { 
                
                		if ((epithesi.getText() != null && !epithesi.getText().isEmpty() && sostoInput.isInteger(epithesi))) {
                			int numHit = Integer.parseInt(epithesi.getText());
                            int rowHitPlayer = numHit/10 ;
                            int columnHitPlayer = numHit%10 ;
                            
                                                 ////////****PLAYER TURN****////////////ARXI
                             
                            einstein.playerLikeAPro(finalgridPlayersEnemy,finalplayerAttackBoard, rowHitPlayer, columnHitPlayer);
                            einstein.numberOfPlayerAliveShips(textAs2);
                            einstein.returnHitPointsPlayer(textPp1);
                            einstein.hitRatioPlayer(textHr1);
                            //for the popup window of enemy ships
                            einstein.statusOfEnemyShips(textCarrier, textBattleship, textCruiser, textSubmarine, textDestroyer); 
                            einstein.getlistHitColumn();
                            einstein.getAllLists(last5player,last4player,last3player,last2player,last1player);
                            
                            if(einstein.endgameOfBattleship()) {
                                
                                	Stage stage = new Stage();
                                	VBox boxakiPlayerEndgame = new VBox();
                                	ImageView imageView = new ImageView("file:youWin1.jpg");
                                	boxakiPlayerEndgame.getChildren().addAll(imageView);
                            		boxakiPlayerEndgame.setPrefSize(450, 380);
                                    Scene scene = new Scene(boxakiPlayerEndgame);
                                    stage.setTitle("PlayerEndgame");
                                    stage.setScene(scene);
                                    stage.show();
                                    try {
									javafx.application.Platform.exit();
									Thread.sleep(3000);						
									} 
                                    catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                            }
                            
                                               ////////****PLAYER TURN****////////////TELOS
                            
                                               ////////****COMPUTER TURN****////////////ARXI
                            pc.computerBeast(finalgridPlayerHis,finalcomputerAttackBoard);
                            pc.numberOfComputerAliveShips(textAs1);
                            pc.returnHitPointsComputer(textPp2);
                            pc.hitRatioComputer(textHr2);
                            pc.getAllLists(last5computer,last4computer,last3computer,last2computer,last1computer);
                            if(pc.endgameOfBattleship()) {
                                
                                	Stage stage = new Stage();
                                	VBox boxakiComputerEndgame = new VBox();
                                	ImageView imageView = new ImageView("file:youLose1.jpg");
                                	boxakiComputerEndgame.getChildren().addAll(imageView);
                            		boxakiComputerEndgame.setPrefSize(570, 230);
                                    Scene scene = new Scene(boxakiComputerEndgame);
                                    stage.setTitle("ComputerEndgame");
                                    stage.setScene(scene);
                                    stage.show();
                                    
                                    try {
									//Thread.sleep(3000);
									javafx.application.Platform.exit();
									Thread.sleep(3000); }
                                    
								    catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
                            }
                            
                            if(einstein.shotLimit()) {
                                
                                	Stage stage = new Stage();
                                    Text announcement = new Text("Shot limit (40) reached");
                                    announcement.setStyle("-fx-font: 39 arial;");
                                    announcement.setFill(Color.DARKORANGE);                                    
                                	//Text winner = new Text();
                                    ImageView imageView = new ImageView();
                                    ImageView imageView1 = new ImageView("file:youWin1.jpg");
                                    ImageView imageView2 = new ImageView("file:youLose1.jpg");
                                    VBox boxakiShotLimit = new VBox();
                                    //VBox boxakiShotLimit = new VBox();
                                	if(einstein.returnHitPointsPlayer(textPp1) > pc.returnHitPointsComputer(textPp2)) {
                                		//winner.setText("GAME OVER.. YOU LOST.. BETTER LUCK NEXT TIME!");
                                		//imageView.setId("file:youWin1.jpg");
                                		boxakiShotLimit.getChildren().addAll(imageView1);
                                	}
                                	else {
                                		//winner.setText("GAME OVER.. YOU LOST.. BETTER LUCK NEXT TIME!");
                                		//imageView.setId("file:youLose1.jpg");
                                		boxakiShotLimit.getChildren().addAll(imageView2);
                                	}
                                	//winner.setStyle("-fx-font: 39 arial;");
                                	//winner.setFill(Color.DARKORANGE);
                                	//VBox boxakiShotLimit = new VBox();
                                	//boxakiShotLimit.getChildren().addAll(imageView);
                                	//boxakiShotLimit.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
                                	boxakiShotLimit.setPrefSize(570, 230);
                                    Scene scene = new Scene(boxakiShotLimit);
                                    stage.setTitle("Shot limit Endgame");
                                    stage.setScene(scene);
                                    stage.show();
                                    try {
									javafx.application.Platform.exit();
									Thread.sleep(3000); 
									} 
                                    catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
                            }
                            
                                               ////////****COMPUTER TURN****////////////TELOS
                            
                            //Clean ta inputs
                            epithesi.clear();
                            
                        } 
                		else {
                            labelExplanation.setText("OUT OF BOUNDS HIT");
                            }
                		} 
                	});

                //Defining the Clear button
                Button clear = new Button("Clear");
                clear.setOnAction(new EventHandler<ActionEvent>() { 
                	public void handle(ActionEvent e) { 
                		//edw bale na sbhnei oti exeis grapsei 
                		epithesi.clear();
                	    labelExplanation.setText(null);
                		} 
                	});
                barAttack.getChildren().addAll(labelAttack, epithesi, submit, clear,labelExplanation);
                barAttack.setSpacing(10);
                VBox boxaki3 = new VBox();
                //gridPlayersEnemy.setAlignment(Pos.BOTTOM_LEFT);
                gridPlayersEnemy.setVisible(false);
                boxaki3.getChildren().addAll(barAttack, gridPlayersEnemy);
                //boxaki3.getChildren().addAll(barAttack);
                boxaki3.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
                //boxaki3 .setAlignment(Pos.TOP_RIGHT);
                boxaki3.setPrefSize(360, 360);
                
                ///////////////////////*create down left boxaki3*////////////////////////TELOS
                
                ///////////////////////*ITEMS setOnAction*////////////////////////ARXI
                
                //menuItem2 => load popup window
                menuItem2.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent t) { 
                		Stage stage = new Stage();
                		Text textLoad1 = new Text("Choose a scenario to load:");
                        textLoad1.setStyle("-fx-font: 23 arial;");
                        textLoad1.setFill(Color.DARKORANGE);
                        //scenario 1
                        Button scenario1 = new Button("SCENARIO-1");
                        Label label1 = new Label("button 1 not selected"); 
                        scenario1.setOnAction(new EventHandler<ActionEvent>() { 
                        	public void handle(ActionEvent e) { 
                        		label1.setText("button 1 selected ");
                        		label1.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                        		/*Read Player Files*/        
                                //int arrayShipIDPlayer[][] = new int[5][4];
                        		ReadFile file1 = new ReadFile();
                        		File fileplayer = new File("player_default.txt");
                        		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                        		
                        		/*Read Computer Files*/        
                        		//int arrayShipIDComputer[][] = new int[5][4];
                        		ReadFile file2 = new ReadFile();
                        		File fileenemy = new File("enemy_default.txt");
                        		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                        	       
                        		} 
                        	});
                        scenario1.setAlignment(Pos.TOP_CENTER);
                        //scenario 2
                        Button scenario2 = new Button("SCENARIO-2");
                        Label label2 = new Label("button 2 not selected"); 
                        scenario2.setOnAction(new EventHandler<ActionEvent>() { 
                        	public void handle(ActionEvent e) { 
                        		label2.setText("button 2 selected ");
                        		label2.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                        		/*Read Player Files*/        
                                //int arrayShipIDPlayer[][] = new int[5][4];
                        		ReadFile file1 = new ReadFile();
                        		File fileplayer = new File("player_senario2.txt");
                        		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                        		
                        		/*Read Computer Files*/        
                        		//int arrayShipIDComputer[][] = new int[5][4];
                        		ReadFile file2 = new ReadFile();
                        		File fileenemy = new File("enemy_senario2.txt");
                        		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                        		} 
                        	});
                        scenario2.setAlignment(Pos.TOP_CENTER);
                        
                        Button scenario3 = new Button("SCENARIO-3");
                        Label label3 = new Label("button3 not selected"); 
                        scenario3.setOnAction(new EventHandler<ActionEvent>() { 
                        	public void handle(ActionEvent e) { 
                        		label3.setText("button 3 selected ");
                        		label3.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                        		//label3.setFill(Color.DARKORANGE);
                        		/*Read Player Files*/        
                                //int arrayShipIDPlayer[][] = new int[5][4];
                        		ReadFile file1 = new ReadFile();
                        		File fileplayer = new File("player_senario3.txt");
                        		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                        		
                        		/*Read Computer Files*/        
                        		//int arrayShipIDComputer[][] = new int[5][4];
                        		ReadFile file2 = new ReadFile();
                        		File fileenemy = new File("enemy_senario3.txt");
                        		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                        		}  
                        	});
                        scenario3.setAlignment(Pos.TOP_CENTER);
                        
                		VBox boxakiLoad = new VBox(textLoad1, scenario1,label1, scenario2, label2, scenario3,label3);
                		boxakiLoad.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
                		boxakiLoad.setPrefSize(540, 540);
                        Scene scene = new Scene(boxakiLoad);
                        stage.setTitle("Load");
                        stage.setScene(scene);
                        stage.show();
                  }
        	    });
                
                //menuItem4 => Enemy ships popup window
                menuItem4.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent t) { 
                		Stage stage = new Stage();
                		//BorderPane loadstage = new BorderPane();
                		Text textPlayerShots = new Text("Last 5 shots of player : ");
                        textPlayerShots.setStyle("-fx-font: 23 arial;");
                        textPlayerShots.setFill(Color.DARKORANGE);
                        
                		VBox boxakiEnemyShips = new VBox(textEnemyShips1,textCarrier,textBattleship,textCruiser,textSubmarine,textDestroyer);
                		boxakiEnemyShips.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
                		boxakiEnemyShips.setPrefSize(540, 540);
                        Scene loadscene = new Scene(boxakiEnemyShips);
                        stage.setTitle("Enemy ships");
                        stage.setScene(loadscene);
                        stage.show();
                  }
        	    });
                
                //menuItem5 => Player Shots popup window
                menuItem5.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent t) { 
                		Stage stage = new Stage();
                		Text textPlayerShots1 = new Text("Last 5 player's shots:");
                        textPlayerShots1.setStyle("-fx-font: 23 arial;");
                        textPlayerShots1.setFill(Color.DARKORANGE);
                        
                		VBox boxakiPlayerShots = new VBox(textPlayerShots1,last5player,last4player,last3player,last2player,last1player);
                		boxakiPlayerShots.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
                		boxakiPlayerShots.setPrefSize(540, 540);
                        Scene scene = new Scene(boxakiPlayerShots);
                        stage.setTitle("Player shots");
                        stage.setScene(scene);
                        stage.show();
                  }
        	    });
                
                //menuItem6 => Enemy Shots popup window
                menuItem6.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent t) { 
                		Stage stage = new Stage();
                		Text textEnemyShots1 = new Text("Last 5 enemy's shots:");
                        textEnemyShots1.setStyle("-fx-font: 23 arial;");
                        textEnemyShots1.setFill(Color.DARKORANGE);
                        
                		VBox boxakiEnemyShots = new VBox(textEnemyShots1,last5computer,last4computer,last3computer,last2computer,last1computer);
                		boxakiEnemyShots.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
                		boxakiEnemyShots.setPrefSize(540, 540);
                        Scene scene = new Scene(boxakiEnemyShots);
                        stage.setTitle("Enemy shots");
                        stage.setScene(scene);
                        stage.show();
                  }
        	    });                
                
                ///////////////////////*ITEMS setOnAction*////////////////////////TELOS
                
                ///////////////////////*create THE FINAL WINDOW*////////////////////////ARXI
                
                //put all items of menu2 in menu1
                menu1.getMenus().add(menu2); //add it to the Menu  
                
                //put all items of menu3 in menu1
                menu1.getMenus().add(menu3); //add it to the Menu  
                
                //create gridPane for the window
                GridPane gridWindow = new GridPane();
                //put the boxakia in the gridWindow
                //for the 1st boxaki
                gridWindow.add(boxaki1, 0, 0);
                //for the 2nd boxaki
                gridWindow.add(boxaki2, 1, 0);
                //for the 3rd boxaki
                gridWindow.add(boxaki3, 0, 1);
                //for the 4th boxaki
                gridWindow.add(boxaki4, 1, 1);
                
                Scene scene = new Scene(gridWindow, 960, 750); //declare the scene size        
        		//show the general menu
                primaryStage.setScene(scene);
                primaryStage.show();
                
                //////////////////***************START-LOOP-WITH-THE-INT=0***************/////////////////////TELOS (L73-L654)
                /////////////*****************TELOS THS START***************/////////////////////////
          }
	    });
        
        //load item exw apo th start
        MenuItem menuItem2 = new MenuItem("Load"); //create 2nd item
        menu2.getItems().add(menuItem2);
        menuItem2.setGraphic(new ImageView("file:load1.jpg"));
      //menuItem2 => load popup window
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent t) { 
        		Stage stage = new Stage();
        		Text textLoad1 = new Text("Choose a scenario to load:");
                textLoad1.setStyle("-fx-font: 23 arial;");
                textLoad1.setFill(Color.DARKORANGE);
                //scenario 1
                Button scenario1 = new Button("SCENARIO-1");
                Label label1 = new Label("button 1 not selected"); 
                scenario1.setOnAction(new EventHandler<ActionEvent>() { 
                	public void handle(ActionEvent e) { 
                		label1.setText("button 1 selected ");
                		label1.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                		/*Read Player Files*/        
                        //int arrayShipIDPlayer[][] = new int[5][4];
                		ReadFile file1 = new ReadFile();
                		File fileplayer = new File("player_default.txt");
                		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                		
                		/*Read Computer Files*/        
                		//int arrayShipIDComputer[][] = new int[5][4];
                		ReadFile file2 = new ReadFile();
                		File fileenemy = new File("enemy_default.txt");
                		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                	       
                		} 
                	});
                scenario1.setAlignment(Pos.TOP_CENTER);
                //scenario 2
                Button scenario2 = new Button("SCENARIO-2");
                Label label2 = new Label("button 2 not selected"); 
                scenario2.setOnAction(new EventHandler<ActionEvent>() { 
                	public void handle(ActionEvent e) { 
                		label2.setText("button 2 selected ");
                		label2.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                		/*Read Player Files*/        
                        //int arrayShipIDPlayer[][] = new int[5][4];
                		ReadFile file1 = new ReadFile();
                		File fileplayer = new File("player_senario2.txt");
                		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                		
                		/*Read Computer Files*/        
                		//int arrayShipIDComputer[][] = new int[5][4];
                		ReadFile file2 = new ReadFile();
                		File fileenemy = new File("enemy_senario2.txt");
                		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                		} 
                	});
                scenario2.setAlignment(Pos.TOP_CENTER);
                
                Button scenario3 = new Button("SCENARIO-3");
                Label label3 = new Label("button3 not selected"); 
                scenario3.setOnAction(new EventHandler<ActionEvent>() { 
                	public void handle(ActionEvent e) { 
                		label3.setText("button 3 selected ");
                		label3.setStyle("-fx-full:orange; -fx-font: 23 arial;");
                		//label3.setFill(Color.DARKORANGE);
                		/*Read Player Files*/        
                        //int arrayShipIDPlayer[][] = new int[5][4];
                		ReadFile file1 = new ReadFile();
                		File fileplayer = new File("player_senario3.txt");
                		arrayShipIDPlayer = file1.ReadFiles(fileplayer);
                		
                		/*Read Computer Files*/        
                		//int arrayShipIDComputer[][] = new int[5][4];
                		ReadFile file2 = new ReadFile();
                		File fileenemy = new File("enemy_senario3.txt");
                		arrayShipIDComputer = file2.ReadFiles(fileenemy);
                		}  
                	});
                scenario3.setAlignment(Pos.TOP_CENTER);
                
        		VBox boxakiLoad = new VBox(textLoad1, scenario1,label1, scenario2, label2, scenario3,label3);
        		boxakiLoad.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        		boxakiLoad.setPrefSize(540, 540);
                Scene scene = new Scene(boxakiLoad);
                stage.setTitle("Load");
                stage.setScene(scene);
                stage.show();
          }
	    });
        
        //exit item
        MenuItem menuItem3 = new MenuItem("Exit"); //create 3rd item
        menu2.getItems().add(menuItem3);
        menuItem3.setGraphic(new ImageView("file:exit.png"));
        menuItem3.setOnAction((ActionEvent t) -> {
            System.exit(0);
         });
        
        ///////////////////////*MENU APPLICATIONS*//////////////////TELOS
        
        ///////////////////////*MENU DETAILS*//////////////////ARXI
        
        //create the 3rd menu Details
        Menu menu3 = new Menu("Details");
        menu3.setGraphic(new ImageView("file:details3.jpg")); //add an icon-image
        
        //enemy ships item
        MenuItem menuItem4 = new MenuItem("Enemy ships "); //create 1st item
        menu3.getItems().add(menuItem4);
        menuItem4.setGraphic(new ImageView("file:pirate2.jpg"));
        //General text for the enemy ships item
		Text textEnemyShips1 = new Text("Status of computer's ships:");
        textEnemyShips1.setStyle("-fx-font: 23 arial;");
        textEnemyShips1.setFill(Color.DARKORANGE);
        //Carrier text
		Text textCarrier = new Text("Status of Carrier: ");
        textCarrier.setStyle("-fx-font: 23 arial;");
        textCarrier.setFill(Color.DARKORANGE);
        //Battleship text
		Text textBattleship = new Text("Status of Battleship: ");
        textBattleship.setStyle("-fx-font: 23 arial;");
        textBattleship.setFill(Color.DARKORANGE);
        //Cruiser text
		Text textCruiser = new Text("Status of Cruiser: ");
        textCruiser.setStyle("-fx-font: 23 arial;");
        textCruiser.setFill(Color.DARKORANGE);
        //Submarine text
		Text textSubmarine = new Text("Status of Submarine: ");
        textSubmarine.setStyle("-fx-font: 23 arial;");
        textSubmarine.setFill(Color.DARKORANGE);
        //Destroyer text
		Text textDestroyer = new Text("Status of Destroyer: ");
        textDestroyer.setStyle("-fx-font: 23 arial;");
        textDestroyer.setFill(Color.DARKORANGE);
        
        //player shots item
        MenuItem menuItem5 = new MenuItem("Player shots"); //create 2nd item
        menu3.getItems().add(menuItem5);
        menuItem5.setGraphic(new ImageView("file:target.jpg"));
        
        //enemy shots item
        MenuItem menuItem6 = new MenuItem("Enemy shots "); //create 3rd item
        menu3.getItems().add(menuItem6);
        menuItem6.setGraphic(new ImageView("file:cannon.jpg"));
        
        menu1.getMenus().add(menu2);
        menu1.getMenus().add(menu3);
        
        ///////////////////////*MENU DETAILS*//////////////////TELOS
        
        ///////////////////////*Helper TEXTS for the correct play*//////////////////ARXI
        
        VBox vboxAll = new VBox();
        ImageView imageView = new ImageView("file:backbattle4.jpg");
        //Media media = new Media("file:intromusic2.mp3");
        //String bip = "intromusic2.mp3";
        //Media hit = new Media(Paths.get(bip).toUri().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(hit);
        //mediaPlayer.play();
        //AudioClip mediaPlayer = new AudioClip("intromusic2.mp3"); 
        //mediaPlayer.play(); 
       // Sound.sound1.loop();
        vboxAll.getChildren().addAll(menu1,imageView);
        //vboxAll.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
        //vboxAll.setBackground(new Background(new BackgroundImage("file: backbattle1",null,null )));
        vboxAll.setPrefSize(930, 930);
        Scene scene = new Scene(vboxAll, 960, 750); //declare the scene size        
		//show the general menu
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ///////////////////////*create THE FINAL WINDOW*////////////////////////TELOS
	}
	
	public static void main(String[] args) {
		//launch(args);
		
		//isws xreiazetai to launch na mpei teleuataio
		launch(args);
	}

}
