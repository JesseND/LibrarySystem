package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OptionsController {

	
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
			Main.SystemMenu.close();
			Main.AddBook.close();
			Main.AddBookCopy.close();
			Main.CheckOutBook.close();
			Main.SearchBook.close();
			Main.AddMember.close();
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
			Main.AddBook.setTitle("CheckoutBook Copy");
			Main.AddBook.show();
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
