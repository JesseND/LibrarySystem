package main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//Stage primaryStage;
	
	public static Stage loginStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			loginStage= primaryStage;
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("fxml_Login.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			loginStage.setScene(scene);
			loginStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
