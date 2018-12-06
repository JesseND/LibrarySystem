package sample;

import main.AccessLevel;
import main.User;
import main.UserController;
import member.management.MemberController;

public class UserData {
	public static void load() {
		UserController controller = UserController.getInstance();
		User user1 = new User("Jymmy","12345678.",AccessLevel.ADMIN);
		User user2 = new User("Bealfan","12345678.",AccessLevel.ADMIN);
		User user3 = new User("Edwin","12345678.",AccessLevel.ADMIN);
		User user4 = new User("Jesse","12345678.",AccessLevel.ADMIN);
		User user5 = new User("Vorlea","12345678.",AccessLevel.ADMIN);
		controller.addNewUser(user1);
		controller.addNewUser(user2);
		controller.addNewUser(user3);
		controller.addNewUser(user4);
		controller.addNewUser(user5);
	}
}
