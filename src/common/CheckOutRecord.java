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
	
	private static int counter = 1;

	public CheckOutRecord() {
	}

	
	public CheckOutRecord(int checkOutRdId, int bookId, int bookCopyId, String userId, boolean isReturned,
			LocalDate dateOut, LocalDate expectedReturnDate) {
		this.checkOutRdId = checkOutRdId;
		this.bookId = bookId;
		this.bookCopyId = bookCopyId;
		this.userId = userId;
		this.isReturned = isReturned;
		this.dateOut = dateOut;
		this.expectedReturnDate = expectedReturnDate;
	}


	public int getCheckOutRdId() {
		return checkOutRdId;
	}

	public void setCheckOutRdId(int checkOutRdId) {
		this.checkOutRdId = counter++;
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

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	


}
