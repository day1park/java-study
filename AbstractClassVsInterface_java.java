package lectureExamples;

abstract class Standard1 {
	abstract public void executeQuery();
	abstract public void postQuery();
}

interface Standard2 {
	void executeQuery();
	void postQuery();
}

class Oracle extends Standard1 {
	public void executeQuery() {
		System.out.println("CREATE Oracle");
	}

	public void postQuery() {
		System.out.println("INSERT Oracle");
	}
}

class MySQL implements Standard2 {
	public void executeQuery() {
		System.out.println("CREATE MySQL");
	}

	public void postQuery() {
		System.out.println("INSERT MySQL");
	}
}

public class AbstractClassVsInterface {
	public static void main(String[] args) {
		Oracle oracle = new Oracle();
		oracle.executeQuery();
		oracle.postQuery();
		MySQL mysql = new MySQL();
		mysql.executeQuery();
		mysql.postQuery();
	}
}
