package main;
	
import book.management.EditBookForm;
import common.DefaultData;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import member.management.MemberForm;
import sample.SampleData;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//Stage primaryStage;
	
	public static Stage loginStage;
	public static Stage AddBook;
	public static Stage memberForm;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			loginStage= primaryStage;
			createstages();
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("fxml_Login.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			DefaultData.getInstance().loadData();
			SampleData.load();
			
			loginStage.setScene(scene);
			loginStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createstages() {
		// TODO Auto-generated method stub
		AddBook = new EditBookForm(loginStage);
		memberForm = new MemberForm(loginStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
