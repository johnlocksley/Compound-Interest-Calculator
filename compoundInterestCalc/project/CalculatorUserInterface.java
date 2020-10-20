package compoundInterestCalc.project;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.control.Button; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class CalculatorUserInterface extends Application {
	 @Override     
	   public void start(Stage primaryStage) throws Exception { 
	      
	    //creating label initalBalance 
	      Text principle = new Text("Initial Balance");       
	      
	      //creating label interestRate 
	      Text interestRate = new Text("Interest Rate"); 
	      
	      //creating label calculationPeriod
	      Text calculationPeriod = new Text("Calculation Period");
	      
	      //creating label compoundInterval
	      Text compoundInterval = new Text("Compound Interval");
	      
	    //Creating Text Field for initialBalance        
	      TextField textField1 = new TextField();       
	      
	      //Creating Text Field for interestRate       
	      TextField textField2 = new TextField();
	      
	    //Creating Text Field for calculationPeriod       
	      TextField textField3 = new TextField();  
	      
	      //creating Text Field for compoundInterval
	      TextField textField4 = new TextField();
	      
	    //Creating Buttons 
	      Button button1 = new Button("Submit"); 
	   // set default button 
	        button1.setDefaultButton(true); 
	        
	        
	      Button button2 = new Button("Clear");  
	      Button button3 = new Button("Back");
	      
	    //Creating a Grid Pane 
	      GridPane gridPane = new GridPane(); 
	      GridPane resultPane = new GridPane();
	      
	      //Setting size for the pane 
	      gridPane.setMinSize(400, 200); 
	      resultPane.setMinSize(400, 200);
	      
	      //Setting the padding  
	      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      resultPane.setPadding(new Insets(10, 10, 10, 10));
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(8); 
	      gridPane.setHgap(8); 
	      resultPane.setVgap(20);
	      resultPane.setHgap(50);
	      
	      //Setting the Grid alignment 
	      gridPane.setAlignment(Pos.CENTER); 
	      resultPane.setAlignment(Pos.BASELINE_LEFT);
	      
	    //Arranging all the nodes in the grid 
	      gridPane.add(principle, 0, 0); 
	      gridPane.add(textField1, 0, 1); 
	      gridPane.add(interestRate, 0, 2);       
	      gridPane.add(textField2, 0, 3);
	      gridPane.add(calculationPeriod, 2, 0);
	      gridPane.add(textField3, 2, 1);
	      gridPane.add(compoundInterval, 2, 2);
	      gridPane.add(textField4, 2, 3);
	      gridPane.add(button1, 3, 4); 
	      gridPane.add(button2, 0, 4);
	      
	      //styling nodes
	      principle.setStyle("-fx-font: normal bold 20px 'serif' "); 
	      interestRate.setStyle("-fx-font: normal bold 20px 'serif' ");  
	      calculationPeriod.setStyle("-fx-font: normal bold 20px 'serif' "); 
	      compoundInterval.setStyle("-fx-font: normal bold 20px 'serif' ");  
	      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
	      button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
	      button3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	      gridPane.setStyle("-fx-background-color: BEIGE;"); 
	      resultPane.setStyle("-fx-background-color: BEIGE;"); 
	       
	      
	   // action event 
	        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	Double p = Double.valueOf(textField1.getText());
	            	Double r = Double.valueOf(textField2.getText());
	            	Integer n = Integer.valueOf(textField3.getText());
	            	Integer t = Integer.valueOf(textField4.getText());
	            	
	            	CompoundInterestCalc calcObj = new CompoundInterestCalc();
	            	double result = calcObj.calcAmount(p, r, n, t); 
	            	String resultString = String.valueOf(result);
	            	Text newTotal = new Text("New Total: ");
	            	Text displayResult = new Text(resultString);
	            	resultPane.add(newTotal, 2, 1);
	            	resultPane.add(displayResult, 2, 2);
	            	resultPane.add(button3, 0, 5);
	            	newTotal.setStyle("-fx-font: normal bold 20px 'serif' ");
	            	displayResult.setStyle("-fx-font: normal bold 30px 'serif' ");
	            	Scene scene2 = new Scene(resultPane);
	            	scene2.setFill(Color.BLUE); 
	            	primaryStage.setScene(scene2); 
	            	primaryStage.show(); 
	            } 
	        }; 
	        
	      
	    //Creating a scene object 
	      Scene scene1 = new Scene(gridPane); 
	      
	      
	      //setting color to the scene 
	      scene1.setFill(Color.BLUE);  
	      
	      //Setting the title to Stage. 
	      primaryStage.setTitle("Compound Interest Calculator"); 
	      
	   
	      //Adding the scene to Stage 
	      primaryStage.setScene(scene1); 
	      
	      //Displaying the contents of the stage 
	      primaryStage.show(); 
	      
	   // action event 
	        EventHandler<ActionEvent> clearEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	textField1.setText("");
	            	textField2.setText("");
	            	textField3.setText("");
	            	textField4.setText("");
	            	primaryStage.setScene(scene1);
	            	primaryStage.show();
	            } 
	        }; 
	        
	     // when button is pressed 
	        button1.setOnAction(event); 
	        button2.setOnAction(clearEvent);
	        button3.setOnAction(clearEvent);
	      
	   }         
	   public static void main(String args[]){           
	      launch(args);      
	   } 
	
}
