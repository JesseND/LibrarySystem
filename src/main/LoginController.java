package main;



import common.LibMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	TextField tfuser;
	
	
	@FXML
	TextField tfPassword;
	
	@FXML
	Label lbError;
	
	//private ObservableList<User> data = FXCollections.observableArrayList();
	
	@FXML
	protected void baLogin(ActionEvent event) {
		try {
			//User =new user();
			UserController controller = UserController.getInstance();
			//User userReview = controller.getUserByUsername("Jymmy");
			
			User userReview = controller.getUserByUsername(tfuser.getText());
			
			
			if (userReview != null)
			{
				System.out.println("paso"+userReview.getPassword());
				System.out.println("paso"+tfPassword.getText());
				if (userReview.login(tfPassword.getText())) {
					Main.alAccessLevel=userReview.getAccesslevel();
					Parent root = FXMLLoader.load(getClass().getResource("fxml_Options.fxml"));
					Scene scene = new Scene(root,310,391);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("MPP-Team 2");
					stage.setWidth(285);
					stage.setHeight(598);
					stage.show();
					lbError.setVisible(false);
					tfPassword.setText("");
					tfuser.setText("");
					Main.loginStage=stage;
					Main.SystemMenu.hide();
				}
				else
				{
					lbError.setVisible(true);
				}
			}
			else
			{
				lbError.setVisible(true);
				System.out.println("no paso");
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
