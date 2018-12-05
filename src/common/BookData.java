package common;

 
import java.util.ArrayList;
 
import java.util.List;
 

public class BookData {
	private static  BookData instance = new  BookData();
	
	private DataAccess<Integer, BookInfo> dataAccessBookInfo = new DataAccessImpl<Integer, BookInfo>();
	 
	private  BookData() {}
	
	public static  BookData getInstance() {return instance;}
		
	public void load() {
		
	 
		List<Author> authors=new ArrayList<>();
		
		BookInfo book1= new BookInfo("UML vol1", "1-22-333-4444",21);
		BookInfo book2= new BookInfo("UML vol2", "1-55-666-7777",21);
		BookInfo book3= new BookInfo("UML vol3", "1-23-333-4444",21);
		BookInfo book4= new BookInfo("UML vol4", "1-10-100-1000",21);
		BookInfo book5= new BookInfo("UML vol5", "1-12-122-1222",21);
		
		Author auth1=new Author("Jim");
		Author auth2=new Author("Tom");
		Author auth3=new Author("Linda");
		Author auth4=new Author("Stacy");
		Author auth5=new Author("Susan");
		
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
		 
		book1.addBookCopy(12);
		book2.addBookCopy(2);
		book3.addBookCopy(3);
		book4.addBookCopy(4);
		book5.addBookCopy(7);		 
		
		dataAccessBookInfo.add(book1.getID(), book1);
		dataAccessBookInfo.add(book2.getID(), book1);
		dataAccessBookInfo.add(book3.getID(), book1);
		dataAccessBookInfo.add(book4.getID(), book1);
		dataAccessBookInfo.add(book5.getID(), book1);
		 
		
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
