package lectureExamples;

class CommunicationDevice {
	public void display() {
		System.out.println("I am a communication device");
	}
}

class Landline extends CommunicationDevice {
	public void display() {
		System.out.println("I am a landline");
	}
}

class Mobile extends CommunicationDevice {
	public void display() {
		System.out.println("I am a mobile");
	}
}

public class ReferencingUsingParent {
	CommunicationDevice deviceList[] = new CommunicationDevice[10];
	int count = -1;
	
	public void addDevice(CommunicationDevice device) {
		deviceList[++count] = device;
	}
	
	public void listDevice() {
		Landline landline = null;
		Mobile mobile = null;
		for (CommunicationDevice device: deviceList) {
			if (device instanceof Landline) {
				landline = (Landline)device;  // example of downcasting
				landline.display();
			} else if (device instanceof Mobile) {
				mobile = (Mobile)device;
				mobile.display();
			}
		}
	}
	
	public static void main(String[] args) {
		ReferencingUsingParent obj = new ReferencingUsingParent();
		obj.addDevice(new Landline());  // example of upcasting
		obj.addDevice(new Mobile());
		obj.listDevice();
	}
}
