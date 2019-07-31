package lectureExamples;

abstract class Employee {
	abstract public void role();  // abstract methods have to be defined by child
	
	public void status() {
		System.out.println("Employee of TCS");
	}
}

class Graduate extends Employee {
	public void role() {
		System.out.println("Graduate Developer");
	}
}

public class AbstractClassDemo {
	public static void main(String[] args) {
		Graduate grad1 = new Graduate();
		grad1.role();
		grad1.status();
	}
}
