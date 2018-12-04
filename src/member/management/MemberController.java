package member.management;

import common.*;

public class MemberController {
	private static MemberController instance = new MemberController();
	
	private DataAccess<String, LibMember> dataAccess = new DataAccessImpl<String, LibMember>();
	
	private MemberController() {}
	
	public static MemberController getInstance() { return instance; }
	
	public LibMember addNewMember(LibMember libMember) {
		return dataAccess.add(libMember.getId(), libMember);
	}
	
	public LibMember getMemberById(String id) {
		return dataAccess.get(id);
	}
}
