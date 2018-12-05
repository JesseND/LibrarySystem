package main;

public class User {
	private String username;
	private String password;
	private AccessLevel accesslevel;
	
	public User(String strUser, String strPassword,AccessLevel alAccessLevel)
	{
		username=strUser;
		password=strPassword;
		accesslevel=alAccessLevel;
	}
	
	

	public boolean login(String strPassword)
	{
		if(strPassword == this.password)
			return true;
		else
			return false;		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccessLevel getAccesslevel() {
		return accesslevel;
	}

	public void setAccesslevel(AccessLevel accesslevel) {
		this.accesslevel = accesslevel;
	}
}
