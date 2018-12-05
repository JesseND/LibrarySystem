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
}

