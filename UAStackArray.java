/********************************
Name: Josue Martinez
Username: ua116
Problem Set: PS6
Due Date: 04 12, 2023
********************************/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UAStackArray {

	public UAStudent[] stack;
	public int top;
	public int size;

	public static class UAStudent {

		private int studentId;
		private String firstName;
		private String lastName;

		public UAStudent(String input) {
			String[] comma = input.split(",");
			this.lastName = comma [0];
			this.firstName = comma [1];
			this.studentId = Integer.parseInt(comma[2]);
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String toString() {
			return "Student: \t" + lastName + ", " + firstName;
		}

	}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		UAStackArray st = new UAStackArray(100);

		// ...insert code to read records.txt and load into your stack
		BufferedReader br = new BufferedReader(new FileReader("records.txt"));

		String line = "";

		while ((line = br.readLine()) != null) {
			
			String[] comma = line.split(",");
			UAStudent student = new UAStudent(line);
			
			student.setLastName(comma[0]);
			student.setFirstName(comma[1]);
			student.setStudentId(Integer.parseInt(comma[2]));

			st.push(student);

		}
		br.close();

		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		st.push(a);
		st.push(new UAStudent("Mackey,Andrew,55555"));
		st.push(new UAStudent("Mackey,Andrew,99999"));

		System.out.println("Size of Stack:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");
		System.out.println(st.pop());
		System.out.println(st.pop());
		

		System.out.println("Size of Stack:  " + st.size());

		System.out.println(st.pop());

		System.out.println("Size of Stack:  " + st.size());

	}
	/**
	 * 
	 * @param size
	 * This method will run in 0(1) time.
	 */
	public UAStackArray(int size) {

		this.stack = new UAStudent[size];
		this.top = -1;
		this.size = size;

	}
	
	/**
	 * 
	 * @param s
	 * This method will run in O(1) time.
	 */
	public void push(UAStudent s) {

		if (top == size - 1) {
			resize();
		} else {
			top++;
			stack[top] = s;
		}

	}
	
	/**
	 * 
	 * @return
	 * This method will run in O(1) time.
	 */
	public UAStudent pop() {

		if (isStackEmpty()) {
			return null;
		} else {
			UAStudent s = stack[top];
			stack[top] = null;
			top--;
			return s;
		}

	}
	
	/**
	 * 
	 * @return
	 * This method will run in O(1) time.
	 */
	public int size() {

		return top + 1;
	}

	/**
	 * 
	 * @return
	 * This method will run in O(1) time.
	 */
	public boolean isStackEmpty() {

		return top == -1;
	}

	/**
	 * 
	 * 
	 * This method will run in O(n) time.
	 */
	public void resize() {

		int newSize = (int) (size * 1.5);

		UAStudent[] copy = new UAStudent[newSize];

		for (int i = 0; i < stack.length; i++) {
			copy[i] = stack[i];
		}

		stack = copy;
		size = newSize;

	}

}