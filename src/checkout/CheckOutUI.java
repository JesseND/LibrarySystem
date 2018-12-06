package checkout;

import member.management.MemberController;

import java.util.List;

import book.management.BookInfoController;
import member.management.MemberController;
import common.BookInfo;
import common.LibMember;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckOutUI extends Stage {
	
	    Stage primaryStage;
	
	    public CheckOutUI(Stage ps) {

	    	//get member names;
	    	List<String> names = CheckOutController.getLibMemberNames();
	    	
	    	
	    	//get bookInfo Title
	    	List<String> titles = CheckOutController.getBookInfoTitles();
	    	primaryStage = ps;
			
		    GridPane grid = new GridPane(); 
		    grid.setAlignment(Pos.CENTER);
		    grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 20, 20, 20));
		    
		    
		    //Lib member label
		    Label memberLabel = new Label("Select Lib Member: ");
		    grid.add(memberLabel, 0, 0);
		    
		    //Lib member dropdown List
		    ComboBox<String> myComboBox = new ComboBox<String>();
		    for(int i=0; i<names.size();i++ ){
		    	String name = names.get(i);
		    	myComboBox.getItems().add(name);
		    }
			myComboBox.setEditable(true); 
			grid.add(myComboBox, 4, 0);
			
			 //CheckOut button
			 Button memberCheckoutHistory = new Button("Checkout History");
			 grid.add(memberCheckoutHistory, 6, 2);
			  
			 //BookInfo label
			 Label bookInfoLabel = new Label("Select Book Title: ");
		     grid.add(bookInfoLabel, 0, 4);
		    
		     //BookInfo dropdown List
		     ComboBox<String> myComboBox2 = new ComboBox<String>();
		     myComboBox2.getItems().addAll("A","B","C","D","E");
		     myComboBox2.setEditable(true); 
		     grid.add(myComboBox2, 4, 4);
			
			//CheckOut button
			 Button checkOutButton = new Button("Add CheckOut");
			 grid.add(checkOutButton, 6, 8);
		
//			Scene scene = new Scene(grid, 600, 500);
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			Scene scene = new Scene(grid);
			primaryStage.setScene(scene);
			setScene(scene);
	    }

}





	 
	

	
	