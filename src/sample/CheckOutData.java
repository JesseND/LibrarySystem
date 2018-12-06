//package sample;
//
//import java.time.LocalDate;
//
//import checkout.CheckOutController;
//import common.BookInfo;
//import common.CheckOutRecord;
//import book.management.BookInfoController;
//
//public class CheckOutData {
//	private static  CheckOutData instance = new  CheckOutData();
//	 
//	private  CheckOutData() {}
//	
//	public static  CheckOutData getInstance() {return instance;}
//	
//	public static void load() {
//		CheckOutController controller = CheckOutController.getInstance();
//		
//		BookInfo bookInfo = BookInfoController.getInstance().getBookInfo(8);
//		//CheckOutRecord crd = new CheckOutRecord(1,8,1,"001",false, LocalDate.now(), LocalDate.now().plusDays(7));
//				
//		controller.checkOutBook("001", bookInfo);	
//	}
//}
