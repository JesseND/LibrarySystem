package book.management;

import java.util.ArrayList;
import java.util.List;

import common.*; 
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EditBookForm extends Stage {

	BookInfo currentbook;
	
	Label lblMessage=new Label();	
	Label lblMessageSearch=new Label();	
	
	Button btnSearch=new Button("Search");
	Button btnUpdate=new Button("Submit");
	
	TextField txtISBNSearch=new TextField();
		
	TextField txtISBN=new TextField();
	TextField txtTitle=new TextField();
	TextField txtCurrentNumberOfCopy=new TextField();
	TextField txtNumberOfNewCopy=new TextField();
	TextField txtNumberOfDayAllowedToBorrowed=new TextField();
	
	Label lblISBNSearch=new Label("Enter ISBN:");
	Label lblISBN=new Label("ISBN");
	Label lblTitle=new Label("Title");
	Label lblCurrentNumberOfCopy=new Label("Current Number of Copy");
	Label lblNumberOfNewCopy=new Label("Additional Copy");
	Label lblNumberOfDayAllowedToBorrowed=new Label("Max days allow to borrow");
	
	BookInfo book;
	List<Author> authors=new ArrayList<>();
	
	GridPane grid1 = new GridPane();
    private TableView<Author> tblAuthor = new TableView<>(); 
    private final ObservableList<Author> data =
            FXCollections.observableArrayList();
    
    Stage primaryStage;
	
	/*public static void main(String[] args)  {
		// TODO Auto-generated method stub
			launch(args);
	}*/

	//@Override
	//public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
	public EditBookForm(Stage ps) {
		// TODO Auto-generated method stub
		primaryStage=ps;
		setTitle("Edit Book/Add New Book Copy");
		BookRepo.getInstance().loadData();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		lblMessage.setTextFill(Color.RED);
		lblMessageSearch.setTextFill(Color.RED);
		txtNumberOfNewCopy.setText("1");
		tblAuthor.setEditable(false);
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!txtISBNSearch.getText().equals("")) {
					
					currentbook=null;
					
					currentbook=BookCopyController.getInstance().getBookInfo(txtISBNSearch.getText());
					
					if(currentbook==null) {
						lblMessageSearch.setText("Book not found.");
					}else {
						lblMessageSearch.setText("");
						displayBookInfo();
					}
					
					
					
				}else {
					lblMessageSearch.setText("*Please enter ISBN");
				}
			}
		});
		
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(validate()) {
					BookCopyController.getInstance().updateBookInfo(currentbook);
					BookCopyController.getInstance().addBookCopy(currentbook,Integer.valueOf(txtNumberOfNewCopy.getText()));
					clear();
				}else {
					lblMessage.setText("*Please fill all");
				}
			}
		});
		
		txtNumberOfNewCopy.textProperty().addListener(new ChangeListener<String>() {
			   

			@Override
			public void changed(ObservableValue<? extends String> observable, String arg1, String newValue) {
				// TODO Auto-generated method stub
				  if (!newValue.matches("\\d*")) {
					  txtNumberOfNewCopy.setText(newValue.replaceAll("[^\\d]", ""));
			        }
			}
		});
		
		txtCurrentNumberOfCopy.setEditable(false);
		txtNumberOfNewCopy.setText("0");
		
		grid.add(lblMessageSearch,1,0);
		
		grid.add(lblISBNSearch,0,1);
		grid.add(txtISBNSearch, 1, 1);
		grid.add(btnSearch, 2, 1);
		
		grid.add(lblTitle, 0, 4);
		grid.add(txtTitle, 1, 4);
	
		grid.add(lblISBN, 0, 5);
		grid.add(txtISBN, 1, 5);		
		
		grid.add(lblNumberOfDayAllowedToBorrowed, 0, 6);
		grid.add(txtNumberOfDayAllowedToBorrowed, 1, 6);	
		
		grid.add(lblCurrentNumberOfCopy, 0, 7);
		grid.add(txtCurrentNumberOfCopy, 1, 7);		 

		grid.add(lblNumberOfNewCopy, 0, 8);
		grid.add(txtNumberOfNewCopy, 1, 8);
		
		grid.add(btnUpdate, 1, 9);
		grid.add(lblMessage, 1, 10);

		
		Scene scene = new Scene(grid, 600, 500);
		primaryStage.setScene(scene);

		//scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		//primaryStage.show();
		
		setScene(scene);
	}
	
	private void clear() {
		
		txtTitle.setText("");
		txtISBN.setText("");
		txtCurrentNumberOfCopy.setText("");
		txtNumberOfNewCopy.setText("0");
	 
		lblMessage.setText("");
		
		data.clear();
	}
	
	private boolean validate() {
		 
		if(txtTitle.getText().isEmpty() || txtISBN.getText().isEmpty() || txtNumberOfNewCopy.getText().isEmpty() || currentbook==null)
			return false;
		
		return true;
		
	}
	 
	public void displayBookInfo() {
		txtTitle.setText(currentbook.getTitle());
		txtISBN.setText(currentbook.getISBN());
		txtNumberOfDayAllowedToBorrowed.setText(String.valueOf(currentbook.getBorrowDays()));
		txtCurrentNumberOfCopy.setText(String.valueOf(currentbook.getNumberOfCopy()));
		
		 
	}

}
