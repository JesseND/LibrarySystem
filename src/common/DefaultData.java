package common;

import sample.BookData;

public class DefaultData {

private static  DefaultData instance = new  DefaultData();
	 
	private  DefaultData() {}
	
	public static  DefaultData getInstance() {return instance;}
	
	public void load() {
		
		BookData.getInstance().load();
	 
	}
}
