package member.management;

import java.util.List;
import java.util.stream.Collectors;

import common.*;

public class MemberController {
	private static MemberController instance = new MemberController();
	
	private DataAccess<String, LibMember> dataAccess = new DataAccessImpl<String, LibMember>();
	
	private MemberController() {}
	
	public static MemberController getInstance() { return instance; }
	
	public LibMember addNewMember(LibMember member) {
		return dataAccess.add(member.getId(), member);
	}
	
	public LibMember getMemberById(String id) {
		return dataAccess.get(id);
	}
	
	public LibMember updateMember(LibMember member) {
		return dataAccess.update(member.getId(), member);
	}
	
	public List<LibMember> search(String query) {
		String q = query.toLowerCase();
		
		return getAllMembers()
				.stream()
				.filter(member -> 
					member.getId().startsWith(q) ||
					member.getFirstName().toLowerCase().startsWith(q) ||
					member.getLastName().toLowerCase().startsWith(q)
				)
				.collect(Collectors.toList());
	}

	public List<LibMember> getAllMembers() {
		return dataAccess.getAll();
	}
	
	public void loadSample() {
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

