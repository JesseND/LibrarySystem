package common;

public class BookCopy {

	private int bookCopyID;
	private BookInfo book;
	private boolean borrowed;
	
	
	public BookCopy(int bookCopyID,BookInfo book) {
		this.bookCopyID=bookCopyID;
		this.book=book;
		this.borrowed = false;
	}
	
	public int getBookCopyID() {
		return bookCopyID;
	}

	public void setBookCopyID(int bookCopyID) {
		this.bookCopyID = bookCopyID;
	}

	public BookInfo getBook() {
		return book;
	}

	public void setBook(BookInfo book) {
		this.book = book;
	}


	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	private boolean isBorrowed;
	
	
}
