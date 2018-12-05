package book.management;

import common.*;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Set;
 
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
 
import javafx.scene.Node;
 
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
 
import javafx.scene.control.cell.PropertyValueFactory;
 
 
 

public class AddBookInfoForm extends Stage {
	
	Label lblMessage=new Label();
	
	Button btnaddAuthors=new Button("Add author");
	Button btnsubmit=new Button("Submit");
	Button btnremoveAuthors=new Button("Remove author");
		
	TextField txtISBN=new TextField();
	TextField txtTitle=new TextField();
	TextField txtAuthorFirstName=new TextField();
	TextField txtAuthorLastName=new TextField();
	TextField txtNumberOfNewCopy=new TextField();
	TextField txtNumberOfDayAllowedToBorrowed=new TextField();
	
	Label lblISBN=new Label("ISBN");
	Label lblTitle=new Label("Title");
	Label lblNumberOfNewCopy=new Label("Number of Copy");
	Label lblAuthorF=new Label("Author First Name");
	Label lblAuthorL=new Label("Author Last Name");
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
		
		public AddBookInfoForm(Stage ps) {
		// TODO Auto-generated method stub
		primaryStage=ps;
		setTitle("Add New Book"); 
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		  
		lblMessage.setTextFill(Color.RED);
		txtNumberOfNewCopy.setText("1");
		txtNumberOfDayAllowedToBorrowed.setText("21");
		tblAuthor.setEditable(false);
		TableColumn<Author, String> dateCol1 = new TableColumn<>("FirstName");
		dateCol1.setPrefWidth(100);
        dateCol1.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        
        TableColumn<Author, String> dateCol2 = new TableColumn<>("LastName");
        dateCol2.setPrefWidth(100);
        dateCol2.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        
        ScrollBar table1VerticalScrollBar = findScrollBar( tblAuthor, Orientation.VERTICAL);
        tblAuthor.getColumns().add(dateCol1);
        tblAuthor.getColumns().add(dateCol2);
		//loadAuthors();
		tblAuthor.setItems(data);	
		System.out.print("data "+data.size());
		btnaddAuthors.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(validateAuthor()) {
					addAuthor();
					txtAuthorFirstName.setText("");
					txtAuthorLastName.setText("");
				}
			}
		});
		
		btnsubmit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
								
				if(validate()) {
					BookInfoController.getInstance().addNewBookInfo(getBookInfo(),Integer.valueOf(txtNumberOfNewCopy.getText()));
					clear();
					showSaveAlert();
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
		
		grid.add(lblTitle, 0, 0);
		grid.add(txtTitle, 1, 0);
	
		grid.add(lblISBN, 0, 1);
		grid.add(txtISBN, 1, 1);
		
		
		grid.add(lblNumberOfDayAllowedToBorrowed, 0, 2);
		grid.add(txtNumberOfDayAllowedToBorrowed, 1, 2);
		
		grid.add(lblAuthorF, 0, 3);
		grid.add(txtAuthorFirstName, 1, 3);
		
		grid.add(lblAuthorL, 0, 4);
		grid.add(txtAuthorLastName, 1, 4);
		
		grid.add(btnaddAuthors, 3, 4);
		 
		grid.add(tblAuthor, 1, 5);
		 

		grid.add(lblNumberOfNewCopy, 0, 6);
		grid.add(txtNumberOfNewCopy, 1, 6);
	
		
		grid.add(btnsubmit, 1, 7);
		
		grid.add(lblMessage, 1, 8);
		
		Scene scene = new Scene(grid, 1000, 700);
		//ps.setScene(scene);

		//scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		//ps.show();
		clear();
		setScene(scene);
		
	}
		
		
	private void showSaveAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Successfully Save! ", ButtonType.CLOSE);
		alert.showAndWait();
	}
	
	
	private void clear() {
		
		txtTitle.setText("");
		txtISBN.setText("");
		txtNumberOfNewCopy.setText("1");
		txtAuthorFirstName.setText("");
		txtAuthorLastName.setText("");
		lblMessage.setText("");
		
		data.clear();
	}
	 
	private boolean validateAuthor() {
		if(txtAuthorFirstName.getText().trim().isEmpty() || txtAuthorLastName.getText().trim().isEmpty())
			return false;
		
		if(isAuthorAlreadyExists(txtAuthorFirstName.getText().trim(),txtAuthorLastName.getText()))
			return false;
		
		return true;
	}
	
	private boolean isAuthorAlreadyExists(String firstName,String lastName) {
		for(Author aut : authors) {
			if(aut.getFirstName().equals(firstName) && aut.getLastName().equals(lastName))
				return true;
		}
		
		return false;
	}
	
	private boolean validate() {
		
		if(txtTitle.getText().isEmpty()|| txtISBN.getText().isEmpty() || txtNumberOfNewCopy.getText().isEmpty() || txtNumberOfDayAllowedToBorrowed.getText().isEmpty() || authors.size()==0)
			return false;
		
		return true;
		
	}
	
	 private ScrollBar findScrollBar(TableView<?> table, Orientation orientation) {

	        // this would be the preferred solution, but it doesn't work. it always gives back the vertical scrollbar
	        //      return (ScrollBar) table.lookup(".scroll-bar:horizontal");
	        //      
	        // => we have to search all scrollbars and return the one with the proper orientation

	        Set<Node> set = table.lookupAll(".scroll-bar");
	        for( Node node: set) {
	            ScrollBar bar = (ScrollBar) node;
	            if( bar.getOrientation() == orientation) {
	                return bar;
	            }
	        }

	        return null;

	    }
	
	
	private BookInfo getBookInfo() {
		BookInfo book= new BookInfo(txtTitle.getText().trim(),txtISBN.getText().trim(),Integer.valueOf(txtNumberOfDayAllowedToBorrowed.getText().trim()));
		
		book.addAuthor(this.authors);
		
		return book;
	}
	
	private void addAuthor() {
		Author aut=new Author(txtAuthorFirstName.getText(),txtAuthorLastName.getText());
		data.clear();
		data.add(aut);
		authors.add(aut);
	}

}
