package common;

public class Author extends Person {

	public Author(String firstName, String lastName, String phone, Address address) {
		super(firstName, lastName, phone, address);
		// TODO Auto-generated constructor stub
	}
	
	public Author(String firstName,String lastName) {
		super(firstName, lastName, "", new Address("","", "", ""));
	}
	
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	public String getLastName() {
		return super.getLastName();
	}

}
