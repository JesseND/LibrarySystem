package common;

public class DefaultData {

private static  DefaultData instance = new  DefaultData();
	 
	private  DefaultData() {}
	
	public static  DefaultData getInstance() {return instance;}
	
	public void loadData() {
		
		BookRepo.getInstance().loadData();
	 
	}
}
