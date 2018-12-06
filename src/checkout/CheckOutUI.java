package checkout;

import java.util.List;

import book.management.BookInfoController;
import common.BookInfo;
import common.LibMember;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import member.management.MemberController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CheckOutUI extends Stage {
	
	    Stage primaryStage;
	    String libMemberId;
		int bookId  ;
	
	    public CheckOutUI(Stage ps) {


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
		    ObservableList<LibMember> members = FXCollections.observableArrayList();
		    members.addAll(MemberController.getInstance().getAllMembers());
		    ComboBox<LibMember> myComboBox = new ComboBox<>();
		    myComboBox.setItems(members);
			myComboBox.setEditable(true); 
			grid.add(myComboBox, 4, 0);
			myComboBox.valueProperty().addListener((obs, oldval, newval) -> {
	    	    if(newval != null) {
	    	    	libMemberId = newval.getId();
	    	    }
	    	});
			
//			 //CheckOut button
//			 Button memberCheckoutHistory = new Button("Checkout History");
//			 grid.add(memberCheckoutHistory, 6, 2);
			  
			 //BookInfo label
			 Label bookInfoLabel = new Label("Select Book Title: ");
		     grid.add(bookInfoLabel, 0, 4);
		    
		     //BookInfo dropdown List
		     ObservableList<BookInfo> books = FXCollections.observableArrayList();
		     books.addAll(BookInfoController.getInstance().getBookInfo());
		     ComboBox<BookInfo> myComboBox2 = new ComboBox<>();
		     myComboBox2.setItems(books);
		     myComboBox2.setEditable(true); 
		     grid.add(myComboBox2, 4, 4);
		     myComboBox2.valueProperty().addListener((obs, oldval, newval) -> {
		    	    if(newval != null){
		    	    	bookId = newval.getID();
		    	    }
		    	    	
		    	           
		    	});
			
			//CheckOut button
			 Button checkOutButton = new Button("Add CheckOut");
			 grid.add(checkOutButton, 6, 8);
			 checkOutButton.setOnAction(e->{
				 
				 System.out.println(libMemberId +" "+bookId);
				 String msg = CheckOutController.getInstance().validateInputs(libMemberId, bookId);
				 System.out.println(msg);
			 });
		
             
			
			Scene scene = new Scene(grid);
			primaryStage.setScene(scene);
			setScene(scene);
	    }
}





	 
	

	
	