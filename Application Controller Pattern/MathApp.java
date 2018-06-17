import java.util.Scanner;

public class MathApp {

	public static void main(String[] args) {
		MathACP app = new MathACP();
		String add = "add";
		String sub = "sub";
		String mul = "mul";
		String div = "div";
		Integer num1 = -5;
		Integer num2 = 5;
		String op;
		
		Scanner in = new Scanner(System.in);
		
		/* Request input from user:
		 * First integer, math operation, and second integer
		 */
		System.out.println("First integer: ");
		num1 = Integer.parseInt(in.nextLine());
		System.out.println("Enter an operation (+ - * /): ");
		op = in.nextLine();
		System.out.println("Second integer: ");
		num2 = Integer.parseInt(in.nextLine());
		
		System.out.println(num1 + " " + op + " " + num2 + " = ");
		MathACP.handleCommand(op, num1, num2);

	}

}
