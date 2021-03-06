package main;
	
import book.management.AddBookInfoForm;
import book.management.EditBookForm;
import checkout.CheckOutUI;
import common.DefaultData;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import member.management.MemberController;
import member.management.MemberForm;
import sample.SampleData;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//Stage primaryStage;
	
	public static Stage SystemMenu;
	public static Stage loginStage;
	public static Stage AddBook;
	public static Stage AddBookCopy;
	public static Stage CheckOutBook;
	public static Stage SearchBook;
	public static Stage AddMember;
	public static AccessLevel alAccessLevel;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			SystemMenu= primaryStage;
			createstages();
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("fxml_Login.fxml"));
			Scene scene = new Scene(root,310,391);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			SystemMenu.setScene(scene);
			SystemMenu.setTitle("MPP TEAM 2");
			SystemMenu.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createstages() {
		// TODO Auto-generated method stub
		AddBook = new AddBookInfoForm(SystemMenu);
		/// WE HAVE TO CHANGE WIHT THE OFFICIAL OPTIONS
		AddBookCopy = new EditBookForm(SystemMenu);
		CheckOutBook = new CheckOutUI(SystemMenu);
		SearchBook = new EditBookForm(SystemMenu);
		AddMember = new MemberForm(SystemMenu);
	
	}

	public static void main(String[] args) {
		SampleData.load();
		launch(args);
	}
}
