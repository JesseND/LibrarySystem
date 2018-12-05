package book.management;
 
import common.*;

public class BookInfoController {
	
	private static  BookInfoController instance = new  BookInfoController();
	 
	private  BookInfoController() {}
	
	public static  BookInfoController getInstance() {return instance;}
	
	public void addNewBookInfo(BookInfo book,int NumberOfCopy) {
						
		book.addBookCopy(NumberOfCopy);
		
		BookRepo.getInstance().addBookInfo(book);
	}
	
		
	public BookInfo getBookInfo(String ISBN) {
		
		return BookRepo.getInstance().getBookInfo(ISBN);
	}
	
	public void updateBookInfo(BookInfo book) {
		
		BookRepo.getInstance().updateBookInfo(book);
	}	 
	
	public BookInfo getBookInfo(int bookid) {
		return BookRepo.getInstance().getBookInfo(bookid);
	}


}
