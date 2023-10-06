/********************************
Name: Josue Martinez
Username: ua116
Problem Set: PS6
Due Date: 04 12, 2023
********************************/
import java.io.*;

public class UAQueueLinkedList {

	public UAStudent head;
    public UAStudent tail;
    public int size;
   
    

	public static class UAStudent {

		private int studentId;
		private String firstName;
		private String lastName;
		private UAStudent next;

		public UAStudent(String input) {
			String[] comma = input.split(",");
			this.lastName = comma [0];
			this.firstName = comma [1];
			this.studentId = Integer.parseInt(comma[2]);
		}
		
		public UAStudent getNext() {
	        return next;
	    }

	    public void setNext(UAStudent next) {
	        this.next = next;
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

	public static void main(String[] args) throws IOException, FileNotFoundException{

		UAQueueLinkedList st = new UAQueueLinkedList();

		// ...insert code to read records.txt and load into your stack
		BufferedReader br = new BufferedReader(new FileReader("records.txt"));

		String line = "";

		while ((line = br.readLine()) != null) {
			
			String[] comma = line.split(",");
			UAStudent student = new UAStudent(line);
			
			student.setLastName(comma[0]);
			student.setFirstName(comma[1]);
			student.setStudentId(Integer.parseInt(comma[2]));

			st.enqueue(student);

		}
		br.close();

		System.out.println("=== Start ==============================");
		System.out.println("Size of Queue:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		st.enqueue(a);
		st.enqueue(new UAStudent("Mackey,Andrew,55555"));
		st.enqueue(new UAStudent("Mackey,Andrew,99999"));

		System.out.println("Size of Queue:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");
		System.out.println(st.dequeue());
		System.out.println(st.dequeue());

		System.out.println("Size of Queue:  " + st.size());

		System.out.println(st.dequeue());

		System.out.println("Size of Queue:  " + st.size());

	}
	
	/**
	 * 
	 * @param s
	 * This method will run in O(1) time.
	 */
    public void enqueue(UAStudent s) {
        if (isEmpty()) {
            head = s;
            tail = s;
        } else {
            tail.setNext(s);
            tail = s;
        }
        size++;
    }
    
    
    /**
     * 
     * @return
     * This method will run in O(1) time.
     */
    public UAStudent dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            UAStudent s = head;
            head = head.getNext();
            size--;
            if (isEmpty()) {
            	head = null;
                tail = null;
            }
            return s;
        }
    }
    
    /**
     * 
     * @return
     * This method will run in O(1) time.
     */
    public int size() {
        return size;
    }
    
    /**
     * 
     * @return
     * This method will run in O(1) time.
     */
    public boolean isEmpty() {
    	if(size == 0) {
    		return true;
    	}
        return false;
    }
    
    /**
     * 
     * @return
     * This method will run in O(1) time.
     */
    public UAStudent peek() {
        return head;
    }
}
