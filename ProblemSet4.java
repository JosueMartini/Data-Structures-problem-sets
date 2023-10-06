public class ProblemSet4 {
	
	public static int addTen(int x, int i) {
		
		if(x > 100) {
			return i;
		} else {
			x += 10;
			i++;
			return addTen(x,i);
			
		}
		
		
	}
	
	public static int findGreatestCommonDivisor(int a, int b) {
		
		
		
		return 0;
	}
	
	public static String findOddNumbers(int[] input, int i, String output) {
		if(i >= input.length) {
			return output;
		} else {
			if(input[i] % 2 == 1) {
				output += input[i] + " ";
			}
			
			return findOddNumbers(input,++i,output);
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(addTen(50,0));
		
		int[] x = {1, 2, 3, 4, 5};
		System.out.println(findOddNumbers(x,0,""));
		
	}

}
