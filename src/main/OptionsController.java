package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OptionsController {
	
	@FXML public Button btnAddBook;
	@FXML public Button btnAddBookCopy;
	@FXML public Button btnCheckOutBook;
	@FXML public Button btnSearchBook;
	@FXML public Button btnAddMember;
	
	@FXML
	public void initialize() {
		System.out.println("asdf");
		btnAddBook.setVisible(false);
		btnAddBookCopy.setVisible(false);
		btnAddMember.setVisible(false);
		btnSearchBook.setVisible(false);
		btnCheckOutBook.setVisible(false);		
		if(Main.alAccessLevel==AccessLevel.ADMIN || Main.alAccessLevel==AccessLevel.BOTH  )
		{
			btnAddBook.setVisible(true);
			btnAddBookCopy.setVisible(true);
			btnAddMember.setVisible(true);
		}
		if(Main.alAccessLevel==AccessLevel.LIBRARIAN|| Main.alAccessLevel==AccessLevel.BOTH )
		{
			btnSearchBook.setVisible(true);
			btnCheckOutBook.setVisible(true);			
		}
			
	}
	
	@FXML
	protected void baAddBook(ActionEvent event) {
		try {
			//Scene scene = new Scene(grid, 600, 500);
			Main.AddBook.setTitle("Edit Book/Add New Book Copy");
			Main.AddBook.setWidth(600);
			Main.AddBook.setHeight(500);
			Main.AddBook.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	protected void baloginStage(ActionEvent event) {
		try {
			Main.loginStage.close();
			//Main.SystemMenu.close();
			Main.AddBook.close();
			Main.AddBookCopy.close();
			Main.CheckOutBook.close();
			Main.SearchBook.close();
			Main.AddMember.close();
			Main.SystemMenu.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	protected void baAddBookCopy(ActionEvent event) {
		try {
			Main.AddBookCopy.setTitle("Add New Book Copy");
			Main.AddBookCopy.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	protected void baCheckOutBook(ActionEvent event) {
		try {
			Main.CheckOutBook.setTitle("Book Checkout");
			Main.CheckOutBook.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	protected void baSearchBook(ActionEvent event) {
		try {
			Main.AddBook.setTitle("Search Book");
			Main.AddBook.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	protected void baAddMember(ActionEvent event) {
		try {
			Main.AddMember.setTitle("Edit Member/Add Member");
			Main.AddMember.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
