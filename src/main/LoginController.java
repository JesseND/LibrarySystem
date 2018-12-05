package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	protected void baLogin(ActionEvent event) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("fxml_Options.fxml"));
			Scene scene = new Scene(root,310,391);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("MPP-Team 2");
			stage.setWidth(285);
			stage.setHeight(598);
			stage.show();
			Main.loginStage=stage;
			Main.SystemMenu.hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
