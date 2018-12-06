package common;

import java.util.List;
import java.time.LocalDate;

public class CheckOutRecord {

	private int checkOutRdId;
	private int bookId;
	private int bookCopyId;
	private String userId; 
	private boolean isReturned;
	private LocalDate dateOut;
	private LocalDate expectedReturnDate;
	
	
	private static int recordCounter = 0;
	CheckOutRecord crd ; 

	public CheckOutRecord() {
	}

	public int getCheckOutRdId() {
		return checkOutRdId;
	}

	public void setCheckOutRdId(int checkOutRdId) {
		this.checkOutRdId = checkOutRdId;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(LocalDate expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public int getBookCopyID() {
		return bookCopyId;
	}

	public void setCopyId(int bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRecordCounter() {
		return recordCounter;
	}

	public void setRecordCounter(int recordCounter) {
		this.recordCounter = recordCounter;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

public BookCopy getBookCopyAvailable(BookInfo book){
		
		BookCopy bCopy = null;
		List<BookCopy> bCopyList = book.getBookCopys();
		
		for(int i = 1; i<=bCopyList.size(); i++) {
			
			bCopy = bCopyList.get(i);
			
			if(!bCopy.isBorrowed()){
				break;
			}
		}
		
		return bCopy;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public boolean checkOutBook(String userId, BookInfo book){
		
			crd = new CheckOutRecord();
		  if(book.getBookCopys().size() == 0){
			  //print that the book has no copy available
			  return false;
			  
		  }else{
			 
			  BookCopy bCopy = getBookCopyAvailable(book);
			 
			  crd.checkOutRdId = ++recordCounter;
			  crd.userId = userId;
			  crd.bookCopyId = bCopy.getBookCopyID();
			  crd.bookId = book.getID();
			  crd.dateOut = LocalDate.now(); 
			  crd.expectedReturnDate = LocalDate.now().plusDays(book.getBorrowDays());
			  crd.isReturned = false;
//			  
//			  if(CheckOutDataAccessor.addCheckOutBookToDB(crd)){
//				  return true;
//			  }
			  
			  	return false;  
		  }

	}
	
}
