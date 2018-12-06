package book.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import common.*; 
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EditBookForm extends Stage {

	BookInfo currentbook;
	
	Label lblMessage=new Label();	
	Label lblMessageSearch=new Label();	
	
	Button btnaddAuthor=new Button("Add author");
	Button btnSearch=new Button("Search");
	Button btnUpdate=new Button("Submit");
	Button btnremoveAuthor=new Button("Remove author");
	
	TextField txtISBNSearch=new TextField();
	
	TextField txtAuthorFirstName=new TextField();
	TextField txtAuthorLastName=new TextField();
		
	TextField txtISBN=new TextField();
	TextField txtTitle=new TextField();
	TextField txtCurrentNumberOfCopy=new TextField();
	TextField txtNumberOfNewCopy=new TextField();
	TextField txtNumberOfDayAllowedToBorrowed=new TextField();
	
	Label lblAuthorF=new Label("Author First Name");
	Label lblAuthorL=new Label("Author Last Name");
	
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
		 
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		lblMessage.setTextFill(Color.RED);
		lblMessageSearch.setTextFill(Color.RED);
		txtNumberOfNewCopy.setText("1");
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
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!txtISBNSearch.getText().equals("")) {
					
					clear();
					currentbook=BookInfoController.getInstance().getBookInfo(txtISBNSearch.getText());
					
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
		
		btnaddAuthor.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						if(validateAuthor()) {
							addAuthor();
							clearAuthor();
						}
					}
		});
		

		btnremoveAuthor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				removeAuthor(tblAuthor.getSelectionModel().getSelectedItem());
			}
		});
		
		
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(validate()) {
					BookInfoController.getInstance().updateBookInfo(getBookInfo(),Integer.valueOf(txtNumberOfNewCopy.getText()));
			 
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
		
		txtNumberOfDayAllowedToBorrowed.textProperty().addListener(new ChangeListener<String>() {
			   
			@Override
			public void changed(ObservableValue<? extends String> observable, String arg1, String newValue) {
				// TODO Auto-generated method stub
				  if (!newValue.matches("\\d*")) {
					  txtNumberOfDayAllowedToBorrowed.setText(newValue.replaceAll("[^\\d]", ""));
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
		
		grid.add(lblAuthorF, 0, 7);
		grid.add(txtAuthorFirstName, 1, 7);
		
		grid.add(lblAuthorL, 0, 8);
		grid.add(txtAuthorLastName, 1, 8);
		
		grid.add(btnaddAuthor, 2, 8);
		 
		grid.add(tblAuthor, 1, 9);
		grid.add(btnremoveAuthor, 2, 9);
		
		grid.add(lblCurrentNumberOfCopy, 0, 10);
		grid.add(txtCurrentNumberOfCopy, 1, 10);		 

		grid.add(lblNumberOfNewCopy, 0, 11);
		grid.add(txtNumberOfNewCopy, 1, 11);
		
		grid.add(btnUpdate, 1, 12);
		grid.add(lblMessage, 1, 13);

		
		Scene scene = new Scene(grid, 700, 600);
		primaryStage.setScene(scene);
 
		//scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		//primaryStage.show();
		clear();
		setScene(scene);
	}
	
	private void showSaveAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Successfully update! ", ButtonType.CLOSE);
		alert.showAndWait();
	}
	
	private void clear() {
		
		txtTitle.setText("");
		txtISBN.setText("");
		txtCurrentNumberOfCopy.setText("");
		txtNumberOfNewCopy.setText("0");
	 
		lblMessage.setText("");
		
		currentbook=null;
		data.clear();
		authors.clear();
	}
	
	private boolean validate() {
		 
		if(txtTitle.getText().isEmpty() || txtISBN.getText().isEmpty() || txtNumberOfNewCopy.getText().isEmpty() || txtNumberOfDayAllowedToBorrowed.getText().isEmpty() || currentbook==null || this.authors.size()==0)
			return false;
		
		return true;
		
	}
	 
	public void displayBookInfo() {
		txtTitle.setText(currentbook.getTitle());
		txtISBN.setText(currentbook.getISBN());
		txtNumberOfDayAllowedToBorrowed.setText(String.valueOf(currentbook.getBorrowDays()));
		txtCurrentNumberOfCopy.setText(String.valueOf(currentbook.getNumberOfCopy()));
		addAuthor(currentbook.getAuthorList());
		 
	}
	
	private BookInfo getBookInfo() {
		 
		this.currentbook.setTitle(txtTitle.getText().trim());
		this.currentbook.setISBN(txtISBN.getText().trim());
		this.currentbook.setBorrowDays(Integer.valueOf(txtNumberOfDayAllowedToBorrowed.getText().trim()));
		this.currentbook.clearAuthor();
		this.currentbook.addAuthor(this.authors);
		
		return currentbook;
	}
	
	private void clearAuthor() {
		txtAuthorFirstName.setText("");
		txtAuthorLastName.setText("");
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
	 
		private void addAuthor() {
			Author aut=new Author(txtAuthorFirstName.getText(),txtAuthorLastName.getText());
		 
			data.add(aut);
			authors.add(aut);
		}
		
		private void addAuthor(List<Author> authors) {
			for(Author aut : authors) {
				data.add(aut);
				this.authors.add(aut);
			}
			 
		}
		
		private void removeAuthor(Author aut) {
			data.remove(aut);
			authors.remove(aut);
		}
}
