package lectureExamples;

// in interface, only abstract methods are available
interface Contract {
	void timeSheetStatus();
	void workLocation();
}

class Vendor implements Contract {
	public void timeSheetStatus() {
		System.out.println("Pending timesheet");
	}
	
	public void workLocation() {
		System.out.println("Will work in office");
	}
}

public class InterfaceDemo {
	public static void main(String[] args) {
		Vendor vendor = new Vendor();
		vendor.timeSheetStatus();
		vendor.workLocation();
	}
}
