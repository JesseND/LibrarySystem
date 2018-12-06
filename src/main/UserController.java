package main;

import java.util.List;
import java.util.stream.Collectors;

import common.DataAccess;
import common.DataAccessImpl;

public class UserController {
	
	private static UserController instance = new UserController();
	
	private DataAccess<String, User> dataAccess = new DataAccessImpl<String, User>();
	
	private UserController() {}
	
	public static UserController getInstance() { return instance; }
	
	public User addNewUser(User User) {
		return dataAccess.add(User.getUsername(), User);
	}
	
	public User getUserByUsername(String id) {
		return dataAccess.get(id);
	}
	
	/*
	public User updateUser(User User) {
		return dataAccess.update(User.getId(), User);
	}
	*/
	/*
	public List<User> search(String query) {
		String q = query.toLowerCase();
		
		return getAllUsers()
				.stream()
				.filter(User -> 
					User.getId().startsWith(q) ||
					User.getFirstName().toLowerCase().startsWith(q) ||
					User.getLastName().toLowerCase().startsWith(q)
				)
				.collect(Collectors.toList());
	}
*/
	public List<User> getAllUsers() {
		return dataAccess.getAll();
	}

}
