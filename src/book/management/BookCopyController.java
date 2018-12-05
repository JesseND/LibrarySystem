package book.management;

import common.*;

public class BookCopyController {
	
	private static BookCopyController instance = new BookCopyController();
	 
	private BookCopyController() {}
	
	public static BookCopyController getInstance() {return instance;}
				
	public BookInfo getBookInfo(String ISBN) {
		return BookRepo.getInstance().getBookInfo(ISBN);
	}
	
	public void updateBookInfo(BookInfo book) {
		BookRepo.getInstance().updateBookInfo(book);
	}
	
	public void addBookCopy(BookInfo book,int numberOfCopy) {
		book.addBookCopy(numberOfCopy);
	}
	
	
}
