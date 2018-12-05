package sample;

 
import java.util.ArrayList;
 
import java.util.List;

import book.management.BookInfoController;
import common.Author;
import common.BookInfo;
import member.management.MemberController;
 

public class BookData {
	private static  BookData instance = new  BookData();
		 
	private  BookData() {}
	
	public static  BookData getInstance() {return instance;}
		
	public static void load() {
		BookInfoController controller = BookInfoController.getInstance();
	 
		List<Author> authors=new ArrayList<>();
		
		BookInfo book1= new BookInfo("UML vol1", "1-22-333-4444",21);
		BookInfo book2= new BookInfo("UML vol2", "1-55-666-7777",21);
		BookInfo book3= new BookInfo("UML vol3", "1-23-333-4444",21);
		BookInfo book4= new BookInfo("UML vol4", "1-10-100-1000",21);
		BookInfo book5= new BookInfo("UML vol5", "1-12-122-1222",21);
		
		BookInfo book6= new BookInfo("Software Engineering", "1-22-333-6122",21);
		BookInfo book7= new BookInfo("Big Data", "1-55-666-9872",21);
		BookInfo book8= new BookInfo("Algorithm", "3-23-333-7635",21);
		BookInfo book9= new BookInfo("The POWER of TM", "1-10-100-9812",21);
		BookInfo book10= new BookInfo("DMBS", "2-12-122-2124",21);
		
		Author auth1=new Author("Jim","Robinson");
		Author auth2=new Author("Tom","Robinson");
		Author auth3=new Author("Linda","Robinson");
		Author auth4=new Author("Stacy","Robinson");
		Author auth5=new Author("Susan","Robinson");
		
		authors.add(auth1);
		authors.add(auth2);
		authors.add(auth3);
		authors.add(auth4);
		authors.add(auth5);
		
		book1.addAuthor(authors);
		book2.addAuthor(authors);
		book3.addAuthor(authors);
		book4.addAuthor(authors);
		book5.addAuthor(authors);
		
		book6.addAuthor(authors);
		book7.addAuthor(authors);
		book8.addAuthor(authors);
		book9.addAuthor(authors);
		book10.addAuthor(authors);
		 
		book1.addBookCopy(12);
		book2.addBookCopy(2);
		book3.addBookCopy(3);
		book4.addBookCopy(4);
		book5.addBookCopy(7);
		book6.addBookCopy(2);
		book7.addBookCopy(6);
		book8.addBookCopy(1);
		book9.addBookCopy(8);
		book10.addBookCopy(9);
		
		System.out.println("book.getISBN() "+book1.getID());
		System.out.println("book.getISBN() "+book2.getID());
		System.out.println("book.getISBN() "+book3.getID());
		System.out.println("book.getISBN() "+book4.getID());
		System.out.println("book.getISBN() "+book5.getID());
		
		/*dataAccessBookInfo.add(book1.getID(), book1);
		dataAccessBookInfo.add(book2.getID(), book2);
		dataAccessBookInfo.add(book3.getID(), book3);
		dataAccessBookInfo.add(book4.getID(), book4);
		dataAccessBookInfo.add(book5.getID(), book5);*/
		
		controller.addNewBookInfo(book1, 0);
		controller.addNewBookInfo(book2, 0);
		controller.addNewBookInfo(book3, 0);
		controller.addNewBookInfo(book4, 0);
		controller.addNewBookInfo(book5, 0);
		
		
		controller.addNewBookInfo(book6, 0);
		controller.addNewBookInfo(book7, 0);
		controller.addNewBookInfo(book8, 0);
		controller.addNewBookInfo(book9, 0);
		controller.addNewBookInfo(book10, 0);
		
		getBookInfosSize();
	
	} 
	
	public static void getBookInfosSize() {
		List<BookInfo> bookinfos=BookInfoController.getInstance().getBookInfo();
		System.out.println("book.size() "+bookinfos.size());
	}
	
	/*public void updateBookInfo(BookInfo book) {
		dataAccessBookInfo.update(book.getID(), book);
	}
	
	public void addBookInfo(BookInfo book) {
		dataAccessBookInfo.add(book.getID(), book);
	}
	
	public BookInfo getBookInfo(int bookid) {
		return dataAccessBookInfo.get(bookid);
	}
	
	public BookInfo getBookInfo(String ISBN) {
		//System.out.println("ISBN "+ISBN);
		
		List<BookInfo> bookinfos=dataAccessBookInfo.getAll();
		
		for(BookInfo book : bookinfos) {
			
			System.out.println("book.getISBN() "+book.getISBN());
			
			if(book.getISBN().equals(ISBN))
				return book;
		}
		
		return null;
	}
	 
	public BookInfo getBookInfo(String ISBN,String Title) {
		//System.out.println("ISBN "+ISBN);
		
		List<BookInfo> bookinfos=dataAccessBookInfo.getAll();
		
		for(BookInfo book : bookinfos) {
			
			//System.out.println("book.getISBN() "+book.getISBN());
			
			if(book.getISBN().equals(ISBN) && book.getTitle().equals(Title))
				return book;
		}
		
		return null;
	}
	
	public List<BookInfo> getBookInfo(String ISBN,String Title,String Author){
		return new ArrayList<BookInfo>();
	}
	*/
}
