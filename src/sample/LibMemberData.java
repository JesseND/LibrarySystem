package sample;

import common.Address;
import common.LibMember;
import member.management.MemberController;

public class LibMemberData {
	public static void load() {
		MemberController controller = MemberController.getInstance();
		LibMember member1 = new LibMember("001", "Edwin", "Bernal", "18677451787", new Address("1000 North Fourth Street", "Fairfield", "Iowa", "52557"));
		LibMember member2 = new LibMember("002", "Phyo Lin", "Tun", "6587522787", new Address("2000 N Ct St #20-D", "Fairfield", "Iowa", "52556"));
		LibMember member3 = new LibMember("003", "Jesse", "Ndamutsa", "1234567890", new Address("1000 North Fourth Street", "Fairfield", "Iowa", "52557"));
		LibMember member4 = new LibMember("004", "Bealfan", "Haile", "1234567890", new Address("1000 North Fourth Street", "Fairfield", "Iowa", "52557"));
		LibMember member5 = new LibMember("005", "Vorleak", "Chy", "1234567890", new Address("1000 North Fourth Street", "Fairfield", "Iowa", "52557"));
		
		controller.addNewMember(member1);
		controller.addNewMember(member2);
		controller.addNewMember(member3);
		controller.addNewMember(member4);
		controller.addNewMember(member5);
	}
}
