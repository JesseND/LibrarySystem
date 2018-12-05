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
			Main.AddBook.setTitle("Edit Book/Add New Book Copy");
			Main.AddBook.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
