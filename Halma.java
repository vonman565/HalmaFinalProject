//Vondray Sanford
//Halma Project from PPII
package projectFiles;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Halma extends Application {
	//Classwide declared variables
	GridPane board = new GridPane();
	Circle c1 = new Circle();
	Rectangle r1 = new Rectangle();
	static int[][] grid = new int[16][16];
	static int turn = 1;
	
	//This launches the program
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//This creates the buttons
		primaryStage.setTitle("Halma Game");
		Button newGame = new Button("New Game");
		newGame.setOnAction(new newGameHandler());
		Button rules = new Button ("Rules");
		rules.setOnAction(new rulesHandler());
		Button exit = new Button ("Exit");
		exit.setOnAction(new exitHandler());
		
		//This creates the game board.
		for(int row = 0; row < 16; row++ ){
			for (int col = 0; col < 16; col++){
				r1 = new Rectangle(50,50);
				if (row%2 == 0 && col%2 == 0){
					r1.setFill(Color.TAN);
					r1.setStroke(Color.BLACK);
					r1.setOnMouseClicked(new destinationHandler());
				}
				else if(row%2 == 1 && col%2 == 1){
					r1.setFill(Color.TAN);
					r1.setStroke(Color.BLACK);
					r1.setOnMouseClicked(new destinationHandler());
				}
				else r1.setFill(Color.ALICEBLUE);
				r1.setStroke(Color.BLACK);
				r1.setOnMouseClicked(new destinationHandler());
				board.add(r1,row,col);
			}
			
		}

		//This creates the red game pieces
		for(int row = 0; row < 5; row++){
			for(int col = 0; col < 5; col++){
				c1 = new Circle(25);
				if((row<2)||(row ==2 && col<4) || (row == 3 && col <3) ||(row ==4 && col<2)){
				grid[row][col] = 1;
					c1.setFill(Color.RED);
				c1.setOnMouseClicked(new circleHandler());
				board.add(c1, row, col);
				
			}
			
		}
		}
			
		//This creates the blue game pieces
		for(int row = 11;row<16;row++){
			for(int col =11; col <16; col++){
				c1 = new Circle(25);
				if((row>13)||(row == 13 && col>11) || (row == 12 && col>12) ||(row ==11 && col>13)){
					grid[row][col] = 2;
					c1.setFill(Color.BLUE);
				c1.setOnMouseClicked(new circleHandler());
				board.add(c1, col, row);
			}
		}
		}
			
		//Creates and set up the program window
		HBox hb = new HBox();
		hb.setPadding(new Insets(5,5,5,5));
		hb.setAlignment(Pos.CENTER);
		board.add(hb, 800, 800);
		BorderPane bp = new BorderPane();
		bp.setAlignment(hb,Pos.CENTER);
		bp.setBottom(board);
		bp.setTop(hb);
		hb.getChildren().addAll(rules,newGame,exit);
		
		Scene s = new Scene(bp, 815,870);	
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	//This checks to see if player 2 has won
	public static void checkWin2(){	
		boolean win = true;
		for(int row =0; row<5; row++){
			for(int col = 0; col<5; col++){
		if(grid[row][col] != 2 && ((col<2) || (col ==2 && row <4) && (col == 3 && row <3) && (col ==4 && row<2))){
				win = false;
		}
			}
		}
			if (win == true){
			JOptionPane.showMessageDialog(null, "Player 2 wins!");
		System.exit(0);	
	}
		}
	
	//This checks to see if player 1 has won
	public static void checkWin(){
		boolean win = true;
		for(int row = 11;row<16;row++){
			for(int col =11; col<16; col++){
				if(grid[row][col] != 1 && ((col>13)||(col ==13 && row>11) || (col == 12 && row>12) ||(col ==11 && row>13))){
				win = false;
				}
			}
		}
				if (win == true){
				JOptionPane.showMessageDialog(null, "Player 1 wins!");
				System.exit(0);
		}
	}
	
	//This resets the game
	public class newGameHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			//Wipes the board
			board.getChildren().clear();	
			
			//Creates a new position array
			grid = new int[16][16];
			
			//Resets the turn variable
			turn = 1;
			
			//This creates the game board.
			for(int row = 0; row < 16; row++ ){
				for (int col = 0; col < 16; col++){
					r1 = new Rectangle(50,50);
					if (row%2 == 0 && col%2 == 0){
						r1.setFill(Color.TAN);
						r1.setStroke(Color.BLACK);
						r1.setOnMouseClicked(new destinationHandler());
					}
					else if(row%2 == 1 && col%2 == 1){
						r1.setFill(Color.TAN);
						r1.setStroke(Color.BLACK);
						r1.setOnMouseClicked(new destinationHandler());
					}
					else r1.setFill(Color.ALICEBLUE);
					r1.setStroke(Color.BLACK);
					r1.setOnMouseClicked(new destinationHandler());
					board.add(r1,row,col);
				}
				
			}
			
			//This creates the red game pieces
			for(int col =0; col<5; col++){
				for(int row = 0; row<5; row++){
					c1 = new Circle(25);
					if((row<2)||(row ==2 && col<4) || (row == 3 && col <3) ||(row ==4 && col<2)){
						grid[row][col] = 1;
					c1.setFill(Color.RED);
					c1.setOnMouseClicked(new circleHandler());
					board.add(c1, row, col);
					
				}
				
			}
			}
				
			//This creates the blue game pieces
			for(int col = 11;col<16;col++){
				for(int row =11; row<16; row++){
					c1 = new Circle(25);
					if((row>13)||(row ==13 && col>11) || (row == 12 && col>12) ||(row ==11 && col>13)){
						grid[row][col] = 2;
					c1.setFill(Color.BLUE);
					c1.setOnMouseClicked(new circleHandler());
					board.add(c1, col, row);
				}
			}
		}
		
	}
	}
	
	//This handler prints out the instructions for the game in the console
	class rulesHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Setup" + "\n" + "\n" + "Each player's camp consists of a cluster of adjacent squares in one corner of the board." + "\n" 
					+ "These camps are delineated on the board, each player's camp is a cluster of 19 squares." + "\n" + "The camps are in opposite corners. " + "\n"
					+ "Each player has a set of pieces in a distinct color, of the same number as squares in each camp. " + "\n"
					+ "The game starts with each player's camp filled by pieces of their own color. " + "\n" + "The player who selects the red tokens goes first." + "\n" 
					+ "Pieces can move in eight possible directions (orthogonally and diagonally)." + "\n" + "\n" + "Each player's turn consists of moving a single piece of one's own color in one of the following plays: " + "\n" 
					+ "One move to an empty square: " + "\n" + "\t" + "Place the piece in an empty adjacent square, This move ends the play." + "\n" + "\n" + "One or more jumps over adjacent pieces: " + "\n"
					+ "\t" + "An adjacent piece of any color can be jumped if there is an adjacent empty square on the directly opposite side of that piece." + "\n" + "\t" + "Place the piece in the empty square on the opposite side of the jumped piece."
					+ "\n" + "\t" + "The piece that was jumped over is unaffected and remains on the board." + "\n" + "\t" + "After any jump, one may make further jumps using the same piece, or end the play."
					+ "\n" + "\t" + "If the current play results in having every square of the opposing camp occupied by one's own pieces, the acting player wins. Otherwise, play proceeds clockwise around the board.");
			
		}
	}
	
	//This handler exits the program upon button click
	class exitHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.exit(0);
		}
		
	}
	
	//This handler selects and keeps track of the position of the circle object when selected
		class circleHandler implements EventHandler<MouseEvent>{

			@Override
			public void handle(MouseEvent event) {
				c1 = (Circle)event.getSource();
				if(c1.getFill() == Color.RED && turn != 1){
					JOptionPane.showMessageDialog(null,"Please select a blue piece!");
					return;
				}
				else if (c1.getFill() == Color.BLUE & turn != 2){
					JOptionPane.showMessageDialog(null,"Please select a red piece!");
					return;
				}
				int row = board.getRowIndex(c1);
				int col = board.getColumnIndex(c1);
				c1.setStroke(Color.YELLOW);
				c1.setStrokeWidth(3);
			}
			
		}
		
		//This handler keeps track of the circles destination, moves the circle to the new position, and also checks to see if it is a specific player's turn and if they have won
		class destinationHandler implements EventHandler<MouseEvent>{

			@Override
			public void handle(MouseEvent event) {
				r1 = (Rectangle)event.getSource();
				int row = board.getRowIndex(r1);
				int col = board.getColumnIndex(r1);
				int C1row = board.getRowIndex(c1);
				int C1col = board.getColumnIndex(c1);
				
				if(grid[row][col] == 0 && (row==C1row+1 && col==C1col  || row==C1row-1 && col==C1col || row==C1row && col==C1col+1 || row==C1row && col==C1col-1 ||
						row==C1row+1 && col==C1col+1 || row==C1row-1 && col==C1col-1|| row==C1row-1 && col==C1col+1|| row==C1row+1 && col==C1col-1)){
				grid[row][col] = turn;
				board.getChildren().remove(c1);
				c1.setStroke(null);
				board.add(c1, (col), (row));
				if (turn == 1)
					turn = 2;
				else turn = 1;
				checkWin();
				checkWin2();
			}
				
}
}
}





