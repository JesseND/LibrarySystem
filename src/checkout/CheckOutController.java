package checkout;
import book.management.BookInfoController;
import common.CheckOutRecord;
import common.DataAccess;
import common.DataAccessImpl;
import common.LibMember;
import member.management.MemberController;
import common.BookCopy;
import common.BookInfo;

import java.time.LocalDate;
import java.util.*;

public class CheckOutController {

	static String libMemberId; 
	static BookInfo bookInfo;
	int recordCounter;
	static CheckOutRecord crd ; 
	static String message; 
	static BookCopy bookCopy;
	
	private static  CheckOutController instance = new  CheckOutController();
	private  DataAccess<Integer, CheckOutRecord> dataAccessCheckOutRecord = new DataAccessImpl<Integer, CheckOutRecord>();
	
	
	
	public String validateInputs(String userId, int bookId){
		
		libMemberId = userId;
		bookInfo = BookInfoController.getInstance().getBookInfo(bookId);
		
		if((!userId.equals(null)) && bookId!=0){
			if(checkOutBook(userId, bookInfo)){
				message = MemberController.getInstance().getMemberById(userId).toString()+" borrow "+ bookInfo.getTitle() + ", Copy No "+bookCopy.getBookCopyID();
				return message;
			}else {
				message = "No copy of this book available to borrow!!";
				return message;
			}
		}
		
     	message = "please select both library member & book!";
	    return message;
		
	}
	
	public static  CheckOutController getInstance() {return instance;}
	
	public static BookCopy getBookCopyAvailable(BookInfo book){
		
		BookCopy bCopy;
		List<BookCopy> bCopyList = book.getBookCopys();
		
		for(int i = 1; i<=bCopyList.size(); i++) {
			
			bCopy = bCopyList.get(i);
			
			if(!bCopy.isBorrowed()){
				bookCopy = bCopy;
				return bCopy;
			}
		}
		
		return null;
	}
	
	
	
	public boolean checkOutBook(String userId, BookInfo book){
		
		crd = new CheckOutRecord();
	  if(book.getBookCopys().size() == 0){
		  //print that the book has no copy available
		  return false;
		  
	  }else{
		  if(getBookCopyAvailable(book)!= null) {
			  
			  BookCopy bCopy = getBookCopyAvailable(book);
			
			  crd.setUserId(userId);
			  crd.setCopyId(bCopy.getBookCopyID());
			  crd.setBookId(book.getID());
			  crd.setDateOut(LocalDate.now()); 
			  crd.setExpectedReturnDate(LocalDate.now().plusDays(book.getBorrowDays()));
			  crd.setReturned(false);
			  
			  addNewCheckOutRecord(crd);
			  
			  return true;
			  
		  }
		  else
			  return false;  
	  }
}
	
	  public List<CheckOutRecord> getCheckOutRecords(){
			return dataAccessCheckOutRecord.getAll();
		}
	  
	  public void addNewCheckOutRecord(CheckOutRecord crd) {
			
		  crd.setCheckOutRdId(getCheckOutRecords().size()+1);
		  dataAccessCheckOutRecord.add(crd.getCheckOutRdId(), crd);
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
		List<BookInfo> books = BookInfoController.getInstance().getBookInfo();
		
		List<String> titles = new ArrayList<String>();
		for(BookInfo book: books) {
			String title = book.getTitle();
			
			titles.add(title);
		}
		
		
		return titles;
	}
}
