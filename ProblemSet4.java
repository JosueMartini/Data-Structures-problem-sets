import java.util.*;

public class ProblemSet4 {

	public static int findGreatestCommonDivisor(int a, int b) {

		if (a < b) {
			int holder = a;
			a = b;
			b = holder;

		}

		if (a % b == 0) {

			return b;

		} else {
			b = (a % b);
			a = b;
			return findGreatestCommonDivisor(a, b);
		}

	}

	public static int addTen(int x, int i) {

		if (x >= 100) {
			return i;
		} else {
			x += 10;
			i++;
			return addTen(x, i);

		}

	}

	public static String findOddNumbers(int[] input, int i, String output) {
		if (i >= input.length) {
			return output;
		} else {
			if (input[i] % 2 == 1) {
				output += input[i] + " ";
			}

			return findOddNumbers(input, ++i, output);
		}
	}

	public static void main(String[] args) {

		System.out.println("Problem Set 4 Submission");
		System.out.println("Student Name: Josue Martinez");
		System.out.println("Code Server User: ua116");
		System.out.println("\n");
		if (args.length < 4) {
			System.out.println("Invalid Syntax.");
			System.out.println("Please run: java ProblemSet4 num1 num2 num3 num4 [num5...]");
			System.exit(1);
		}
		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);
		int arg3 = Integer.parseInt(args[2]);
		int arg4 = Integer.parseInt(args[3]);
		int[] arr1 = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			arr1[i] = Integer.parseInt(args[i]);
		}
		System.out.printf("Running problem 1 with x=%d and i=%d.", arg1, arg2);
		System.out.printf("Result: %d %n %n", addTen(arg1, arg2));
		System.out.printf("Running problem 2 with x=%d and i=%d.", arg3, arg4);
		System.out.printf("Result: %d %n %n", findGreatestCommonDivisor(arg3, arg4));
		System.out.printf("Running problem 3 with array: %s %n.", Arrays.toString(arr1));
		System.out.printf("Result: %s %n %n", findOddNumbers(arr1, 0, ""));

	}

}
