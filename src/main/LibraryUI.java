package main;

import java.util.List;
import member.management.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LibraryUI extends Application {
//	private MemberWindow memberWindow;
	public static void main(String[] args) {
		launch(args);
	}
	
	Stage memberForm;
	Stage primaryStage;
	
	private void createMemberForm() {
		memberForm = new MemberForm(primaryStage);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Library System");
		createMemberForm();
				
		VBox topContainer = new VBox();
		MenuBar mainMenu = new MenuBar();
		VBox imageBox = new VBox();
		imageBox.setAlignment(Pos.CENTER);
		imageBox.setId("imageArea");
		
		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(imageBox);

		Menu memberMenu = new Menu("Member");
		MenuItem addNew = new MenuItem("Add New");
		addNew.setOnAction(evt -> {
			memberForm.show();
		});
		
		MenuItem searchMember = new MenuItem("Search for Member");
		searchMember.setOnAction(evt -> {
//			memberWindow = new MemberWindow(primaryStage);
//			LibraryMember mem = new SystemController().search("1001");
//			List<CheckoutRecordView.CheckoutRecordEntryView> entries =
//				(new CheckoutRecordView(mem)).getEntryViews();	
//			memberWindow.setData(FXCollections.observableList(entries));
//			memberWindow.show();
			primaryStage.hide();
			
		});
		MenuItem printRecord = new MenuItem("Print Checkout Record");
		printRecord.setOnAction(evt -> {}
				);
			
		memberMenu.getItems().addAll(addNew, searchMember, printRecord);

		//did not add menu item for menu edit
		Menu pubMenu = new Menu("Publication");
		MenuItem newPub = new MenuItem("Add New");
		newPub.setOnAction(evt -> {
			/*
			CatalogListWindow catalogs = CatalogListWindow.INSTANCE;
			catalogs.setStage(primaryStage);
	        catalogs.setData(DefaultData.CATALOG_LIST_DATA);
	        catalogs.show();  
	        primaryStage.hide();
			*/		
		});
		
		MenuItem addCopy = new MenuItem("Add Copy");
		addCopy.setOnAction(evt -> {
			/*
			CatalogListWindow catalogs = CatalogListWindow.INSTANCE;
			catalogs.setStage(primaryStage);
	        catalogs.setData(DefaultData.CATALOG_LIST_DATA);
	        catalogs.show();  
	        primaryStage.hide();
			*/		
		});
		
		
		pubMenu.getItems().addAll(newPub, addCopy);
		
		Menu queryMenu = new Menu("Queries");
		MenuItem statusOfPub = new MenuItem("Find Status of Publication");
		statusOfPub.setOnAction(evt -> {
			/*
			CatalogListWindow catalogs = CatalogListWindow.INSTANCE;
			catalogs.setStage(primaryStage);
	        catalogs.setData(DefaultData.CATALOG_LIST_DATA);
	        catalogs.show();  
	        primaryStage.hide();
			*/		
		});
		
		queryMenu.getItems().addAll(statusOfPub);
		
		mainMenu.getMenus().addAll(memberMenu, pubMenu, queryMenu);
		Scene scene = new Scene(topContainer, 500, 300);
		scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
}
