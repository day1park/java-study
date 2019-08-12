package lectureExamples;

class A {
	int i = 10;
}

class B extends A {
	int j = 20;
	
	public void display() {
		System.out.println(i);
		System.out.println(j);
	}
}

public class InheritanceDemo {
	public static void main(String[] args) {
		B b = new B();
		b.display();
	}
}
