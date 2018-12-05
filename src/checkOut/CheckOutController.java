package checkout;
import common.BookRepo;
import common.CheckOutRecord;
import common.LibMember;
import member.management.MemberController;
import common.BookInfo;
import java.util.*;

public class CheckOutController {

	static String libMemberId; 
	static BookInfo bookInfo;
	static CheckOutRecord crd = new CheckOutRecord();
	static String message; 
	
	
	private static String receivedInput(String userId, String bTitle, String bISBN){
		
		libMemberId = userId;
		bookInfo = BookRepo.getInstance().getBookInfo(bTitle,bISBN);
		
		if(crd.checkOutBook(userId, bookInfo)){
			message = "You've successfully borrowed "+ message +" Book";
			
			return message;
		}
		
		message = "No copy of this book available to borrow!!";
		return message;
	}
	
	public static List<String> getLibMemberNames(){
		
		List<LibMember> members = MemberController.getInstance().getAllMembers();
		
		List<String> memberFirstAndSecondNames = new ArrayList<String>(); 
		for(LibMember member: members){
			String firstName = member.getFirstName();
			String lastName = member.getLastName();
			
			memberFirstAndSecondNames.add(firstName+" "+lastName);
					
		}

		return memberFirstAndSecondNames;
	}
	
	public static List<String> getBookInfoTitles(){
		
		
		return null;
	}
}
