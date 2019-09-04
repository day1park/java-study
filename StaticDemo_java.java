package lectureExamples;

class Organisation {
	private int orgID;
	static int groupID;
	private String name;
	
	Organisation(int orgID, int groupID, String name) {
		this.orgID = orgID;
//		this.groupID = groupID;
		Organisation.groupID = groupID;
		this.name = name;
	}
	
	public int getOrgID() {
		return orgID;
	}
	
	public String getName() {
		return name;
	}
}

public class StaticDemo {
	public static void main(String[] args) {
		Organisation o1 = new Organisation(1, 1, "TCS");
		Organisation o2 = new Organisation(2, 2, "Westpac");
		System.out.println(o1.groupID);
		Organisation.groupID = 3;
		System.out.println(o1.groupID);
	}
}
