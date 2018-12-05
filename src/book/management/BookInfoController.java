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

}
