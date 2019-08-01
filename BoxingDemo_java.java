package lectureExamples;

public class BoxingDemo {
	public static void main(String[] args) {
		int i = 5;
		// Boxing
		Integer integer = i;
		System.out.println(integer);
		// Un-boxing
		int j = integer;
		System.out.println(j);
	}
}
