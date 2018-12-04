package member.management;

import javax.swing.text.TabExpander;
import javax.swing.text.TabableView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import common.*;

public class MemberForm extends Stage {
	Stage primaryStage;
	@SuppressWarnings("serial")

	GridPane grid = new GridPane();
	
	public MemberForm(Stage ps) {
		primaryStage = ps;
		setTitle("Member Management");
	
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label memberIdLabel = new Label("Member ID");
		grid.add(memberIdLabel, 0, 0);
		TextField memberIdTextField = new TextField();
		grid.add(memberIdTextField, 1, 0);
		
		Label firstNameLabel = new Label("First Name");
		grid.add(firstNameLabel, 0, 1);
		TextField firstNameTextField = new TextField();
		grid.add(firstNameTextField, 1, 1);

		Label lastNameLabel = new Label("Last Name");
		grid.add(lastNameLabel, 0, 2);
		TextField lastNameTextField = new TextField();
		grid.add(lastNameTextField, 1, 2);
		
		Label phoneNumberLabel = new Label("Phone Number");
		grid.add(phoneNumberLabel, 0, 3);
		TextField phoneNumberTextField = new TextField();
		grid.add(phoneNumberTextField, 1, 3);

		Label streetLabel = new Label("Street");
		grid.add(streetLabel, 0, 4);
		TextField streetTextField = new TextField();
		grid.add(streetTextField, 1, 4);

		Label cityLabel = new Label("City");
		grid.add(cityLabel, 0, 5);
		TextField cityTextField = new TextField();
		grid.add(cityTextField, 1, 5);

		Label stateLabel = new Label("State");
		grid.add(stateLabel, 0, 6);
		TextField stateTextField = new TextField();
		grid.add(stateTextField, 1, 6);

		Label zipLabel = new Label("Zip");
		grid.add(zipLabel, 0, 7);
		TextField zipTextField = new TextField();
		grid.add(zipTextField, 1, 7);
		
		Button createBtn = new Button("Create");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BASELINE_CENTER);
		hbBtn.getChildren().add(createBtn);
		grid.add(hbBtn, 1, 8);
		
		TableView table = new TableView();
		TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        table.getColumns().addAll(firstNameCol, lastNameCol);
        grid.add(table, 0, 9);
		
		createBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {		
				Address address = new Address(
						streetTextField.getText(),
						cityTextField.getText(),
						stateTextField.getText(),
						zipTextField.getText()	
					);
				
				LibMember libMember = new LibMember(
						memberIdTextField.getText(),
						firstNameTextField.getText(),
						lastNameTextField.getText(),
						phoneNumberTextField.getText(),	
						address
					);
				
				MemberController controller = MemberController.getInstance();
				controller.addNewMember(libMember);
			}
		});
		
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

}
