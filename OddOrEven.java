import java.util.Scanner;

public class OddOrEven {
  public static void main(String[] args) {
    int num;
    System.out.println("Enter a number please~");

    // input will be stored in the variable 'num'
    Scanner input = new Scanner(System.in);
    num = input.nextInt();

    // check if number is divisible using modular %
    // if (num % 2 == 0)
    // System.out.println(num + " is an EVEN number!");
    // else
    // System.out.println(num + " is an ODD number!");

    // ternerary
    System.out.println((num % 2) == 0 ? "EVEN" : "ODD");

  }
}