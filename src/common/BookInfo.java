package common;

import java.util.*;

public class BookInfo {
	
	private static int bookID;
	private String title;
	private String ISBN;
	private List<Author> authors=new ArrayList<Author>();
	private List<BookCopy> bookCopys=new ArrayList<BookCopy>();
    private int borrowDays; 

	public BookInfo(String title,String ISBN,int borrowDays) {
		this.title=title;
		this.ISBN=ISBN;	
		this.bookID++;
		
		this.setBorrowDays(borrowDays);
	}
	 
	public void addAuthor(List<Author> authors) {
		 
		for(Author aut : authors)
			addAuthor(aut);
	}
	
	public void addBookCopy(int numberOfCopy) {
	
		for(int i=0;i<numberOfCopy;i++)
			addBookCopy(new BookCopy(bookCopys.size()+1,this));
		
	}
	
	private void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	private void addBookCopy(BookCopy bookCopy) {
		this.bookCopys.add(bookCopy);
	}
	
	/*public BookInfo getBookInfo() {
		return new BookInfo("","",21);
	}*/
	
	public List<BookInfo> getBookInfoList(){
		return new ArrayList<BookInfo>();
	}

	public String getISBN()
	{
		return this.ISBN;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getNumberOfCopy() {
		return this.bookCopys.size();
	} 
	
	public int getID() {
		return this.bookID;
	}
	
	public List<BookCopy> getBookCopys() {
		return bookCopys;
	}

	public void setBookCopys(List<BookCopy> bookCopys) {
		this.bookCopys = bookCopys;
	}

	public int getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(int borrowDays) {
		this.borrowDays = borrowDays;
	}
}
