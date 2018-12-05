package common;

public class Author extends Person {

	public Author(String firstName, String lastName, String phone, Address address) {
		super(firstName, lastName, phone, address);
		// TODO Auto-generated constructor stub
	}
	
	public Author(String firstName) {
		super(firstName, "", "", new Address("","", "", ""));
	}

}
