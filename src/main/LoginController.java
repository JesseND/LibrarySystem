package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("fxml_Options.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("safd");
			stage.show();
			Main.loginStage.hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
