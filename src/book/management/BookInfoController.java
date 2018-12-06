package book.management;
 
import java.util.ArrayList;
import java.util.List;

import common.*;

public class BookInfoController {
	
	private static  BookInfoController instance = new  BookInfoController();
	
	private DataAccess<Integer, BookInfo> dataAccessBookInfo = new DataAccessImpl<Integer, BookInfo>();
	 
	private  BookInfoController() {}
	
	public static  BookInfoController getInstance() {return instance;}
	
	public void addNewBookInfo(BookInfo book,int NumberOfCopy) {
						
		book.addBookCopy(NumberOfCopy);
		
		dataAccessBookInfo.add(book.getID(), book);
	}	
	
	/*public BookInfo getBookInfo(String ISBN,String Title) {

		//System.out.println("ISBN "+ISBN);
		
		return BookRepo.getInstance().getBookInfo(ISBN,Title);
	}
	
	public List<BookInfo> getBookInfo(String ISBN,String Title,String Author){
		return new ArrayList<BookInfo>();
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
	*/
	public void updateBookInfo(BookInfo book, int NumberOfCopy) {
		
		book.addBookCopy(NumberOfCopy);
		
		dataAccessBookInfo.update(book.getID(), book);
	}	 
	
	public List<BookInfo> getBookInfo(){
		return dataAccessBookInfo.getAll();
	}
	
	public BookInfo getBookInfo(int bookid) {
		return dataAccessBookInfo.get(bookid);
	}
	
	public BookInfo getBookInfo(String ISBN) {
		 
		List<BookInfo> bookinfos=dataAccessBookInfo.getAll();
		System.out.println("book.size() "+bookinfos.size());
		for(BookInfo book : bookinfos) {
			
			System.out.println("book.getISBN() "+book.getISBN());
			
			if(book.getISBN().equals(ISBN))
				return book;
		}
		
		return null;
	}
	 
	public BookInfo getBookInfo(String ISBN,String Title) {
		 		 
		List<BookInfo> bookinfos=dataAccessBookInfo.getAll();
	
		for(BookInfo book : bookinfos) {			
	 
			System.out.println("book.getISBN() "+book.getISBN());
			if(book.getISBN().equals(ISBN) && book.getTitle().toUpperCase().equals(Title.toUpperCase()))
				return book;
		}
		
		return null;
	}
	
	public List<BookInfo> getBookInfoByTitle(String Title){
		//System.out.println("book.size() "+bookinfos.size());
		List<BookInfo> bookinfos=dataAccessBookInfo.getAll();
		List<BookInfo> results=new ArrayList<>();
		for(BookInfo book : bookinfos) {
			
			System.out.println("book.getISBN() "+book.getISBN());
			
			if(book.getTitle().equals(Title))
				results.add(book);
		}
		
		return results;
	}
	
	
}
