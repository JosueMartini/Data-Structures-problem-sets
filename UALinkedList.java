import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UALinkedList extends ProblemSet5 {

	public UAEmployee head;
	public UAEmployee tail;
	public int size;

	public static final String studentName = "Josue Martinez"; // <---- complete this variable
	public static final String codeServerUser = "ua116"; // <---- complete this variable

	public static void main(String[] args) throws IOException {

		System.out.printf("***********************************************************%n");
		System.out.printf("*  %-53s  *%n", "Data Structures - Problem Set 5");
		System.out.printf("*  %-53s  *%n", "");
		System.out.printf("*  Student Name:              %-26s  *%n", studentName);
		System.out.printf("*  Code Server User (ua###):  %-26s  *%n", codeServerUser);
		System.out.printf("***********************************************************%n");
		System.out.println();

		if (args.length < 3) {
			System.out.println("ERROR:  Invalid command syntax.  You must specify three parameters.\n");
			System.out.println("        Syntax:  java  UALinkedList  file1  file2  empid");
			System.exit(10);
		}

		System.out.printf("Command Line Arguments:  %s %n%n", Arrays.toString(args));

		String argFile1 = args[0]; // used in section 1 and section 2
		String argFile2 = args[1]; // used in section 3
		int argIdToFind = Integer.parseInt(args[2]); // used in section and section 2

		System.out.println("Starting Task 1:  Loading file into list1 using buffered reader");

		List<UAEmployee> list1 = new UALinkedList(); // Do not change

		/****************************************************************************
		 * START OF SECTION 1 - Standard library API usage
		 * 
		 * Step 1: Read file from argFile1 and load each entry into list1 using a
		 * BufferedReader. Do not use the loadListFromFile() method here. Each item
		 * should be loaded into list1 using the add() method.
		 ****************************************************************************/

		BufferedReader br = new BufferedReader(new FileReader(argFile1));

		String line;

		while ((line = br.readLine()) != null) {

			UAEmployee list = new UAEmployee();

			String[] comma = line.split(",");

			list.setEmpId(Integer.parseInt(comma[0]));
			list.setEmpFirstName(comma[1]);
			list.setEmpLastName(comma[2]);
			list.setHoursWorked(Integer.parseInt(comma[3]));

			list1.add(list);

		}

		br.close();

		System.out.printf("%n                  Load complete.  Size of the list is:      %d  %n%n", list1.size());

		/****************************************************************************
		 * Step 2: Write a loop to iterate through all contents of list1 and print each
		 * object to the console.
		 ****************************************************************************/
		System.out.println("Starting Task 2:  Iterating through list and printing...");

		for (int i = 0; i <= list1.size() - 1; i++) {
			System.out.println(list1.get(i));
		}

		System.out.println("\n                  Iteration through list complete.\n");

		/****************************************************************************
		 * Step 3: Find employee id argIdToFind and print out the object by iterating
		 * through list.
		 ****************************************************************************/

		System.out.printf("Starting Task 3:  Searching for employee ID %d... %n", argIdToFind);

		for (int i = 0; i <= list1.size() - 1; i++) {
			if (list1.get(i).getEmpId() == argIdToFind) {
				System.out.println(list1.get(i));
			}
		}

		System.out.println("\n                  Search is complete.\n");

		/****************************************************************************
		 * Step 4: Find employee id argIdToFind and print out the object by iterating
		 * through list.
		 ****************************************************************************/

		System.out.printf("Starting Task 4:  Removing the first entry and printing... %n");

		list1.remove(0);
		for (int i = 0; i <= list1.size() - 1; i++) {
			System.out.println(list1.get(i));
		}

		System.out.println("\n                  Removal is complete.\n");

		/*****************************************************************************
		 * START OF SECTION 2 - Testing API implementation
		 *****************************************************************************/
		runSection2(argFile1, argIdToFind); // DO NOT MODIFY

		/*****************************************************************************
		 * START OF SECTION 3 - Evaluating API behavior and performance
		 * 
		 * Your task is to read through each line in argfile2, which contains nothing
		 * more than a list of line-delimited employee IDs. You will need to find each
		 * of them using list3 by issuing repeated calls to list3.find().
		 * 
		 * For each item that is properly found, add it to the foundList.
		 *****************************************************************************/

		System.out.println("\nStarting Task 9:  Calling loadListFromFile() for list3.  Items in list:");
		UALinkedList list3 = new UALinkedList(); // Do not change
		list3.loadListFromFile(argFile1); // Do not change
		list3.printList();
		System.out.printf("%n                  Load complete.  Size of the list is:      %d  %n", list3.size());

		UALinkedList foundList = new UALinkedList(); // Do not change

		System.out.printf("%n                  Starting to load foundList... %n");
		// -----------------------------------------------------------

		BufferedReader br2 = new BufferedReader(new FileReader(argFile2));

		String line2;
		
		UALinkedList foundListCopy = foundList;

		while ((line2 = br2.readLine()) != null) {

			String[] comma = line2.split("\\|");

			for (int i = comma.length-1; i >= 0; i--) {
				UAEmployee hold = list3.find(Integer.parseInt(comma[i]));

				if (hold != null) {
					UAEmployee copy = new UAEmployee();
					copy.setEmpId(hold.getEmpId());
					copy.setEmpFirstName(hold.getEmpFirstName());
					copy.setEmpLastName(hold.getEmpLastName());
					copy.setAccessCount(hold.getAccessCount()+1);
		            foundList.add(copy);
		            
				}
				
			}

		}

		br2.close();

		System.out.printf("%n                  Load complete.  Size of the list is:      %d  %n", foundList.size());

		System.out.printf("%n                  Original List: %n");
		list3.printList();

		System.out.printf("%n                  Found List: %n");
		foundList.printList();

	} // end of main() method

	/****************************************************************************
	 * METHODS TO IMPLEMENT
	 * 
	 * In the following section, you will find various methods that you will need to
	 * complete successfully.
	 ****************************************************************************/

	@Override
	public UAEmployee find(int empId) {

		UAEmployee i = head;

		while (i != null) {

			if (i.getEmpId() == empId) {

				i.setAccessCount(i.getAccessCount() + 1);

				return i;
			}
			i = i.getNext();
		}

		return null;
	}

	@Override
	public void printList() {

		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i));
		}

	}

	@Override
	public int size() {

		return this.size;

	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) throws NullPointerException {
		UAEmployee i = head;

		if (o == null) {
			throw new NullPointerException("Object is null.");
		}

		while (i != null) {
			if (i == o) {
				return true;
			} else {
				i = i.getNext();
			}
		}
		return false;
	}

	@Override
	public UAEmployee remove(int index) throws IndexOutOfBoundsException {

		UAEmployee i = head;
		UAEmployee removedNode = i;

		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index is not valid.");
		}

		if (index == 0) {
			i = head;
			head = head.getNext();
		}

		for (int x = 0; x < index; x++) {
			if (x == index) {
				i.setPrev(i.getNext().getPrev());
				i.setNext(i.getPrev().getNext());
			}
			i = i.getNext();
		}

		this.size--;
		return removedNode;
	}

	@Override
	public boolean remove(Object o) throws NullPointerException {

		UAEmployee i = head;

		if (o == null) {
			throw new NullPointerException("Object is not valid.");
		}

		if (head == o) {
			head = head.getNext();
			this.size--;
			return true;
		}

		while (i != null) {
			if (i == o) {
				i.getPrev().setNext(i.getNext());
				if (i.getNext() != null) {
					i.getNext().setPrev(i.getPrev());
				}
				size--;
				return true;
			}
			i = i.getNext();
		}

		return false;
	}

	@Override
	public UAEmployee get(int index) throws IndexOutOfBoundsException {
		
		UAEmployee i = head;

		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index is not valid.");
		}

		for (int x = 0; x < index; x++) {
			i = i.getNext();
		}
		
		if( i != null) {
			i.setAccessCount(i.getAccessCount()+1);
		}
		
		if( i == null ) {
			i = head;
		}
		
		

		return i;
	}

	@Override
	public void loadListFromFile(String filename) throws IOException {

		try {

			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line;

			head = null;

			while ((line = br.readLine()) != null) {

				UAEmployee i = new UAEmployee();

				String[] comma = line.split(",");

				i.setEmpId(Integer.parseInt(comma[0]));
				i.setEmpFirstName(comma[1]);
				i.setEmpLastName(comma[2]);
				i.setHoursWorked(Integer.parseInt(comma[3]));

				add(i);

			}

			br.close();

		} catch (Exception x) {

			throw new IOException("List not valid.");

		}

	}

	@Override
	public boolean add(UAEmployee e) throws NullPointerException {

		try {
			UAEmployee i = head;

			if (e == null) {
				throw new NullPointerException("Object is null.");
			}

			// If list is empty it will just add to the head
			if (head == null) {
				head = e;
				tail = e;
				size++;
				return true;
			}

			// Checks if they are the same
			while (i != null) {
				if (i == e) {
					i.setEmpFirstName(e.getEmpFirstName());
					i.setEmpLastName(e.getEmpLastName());
					return true;
				} else {
					i = i.getNext();
				}
			}

			// Adds object based on accessCount (having trouble on this one)
			i = head;

			while (i != null && i.getAccessCount() >= e.getAccessCount()) {
				i = i.getNext();

			}

			if (i == null) {
				tail.setNext(e);
				e.setPrev(tail);
				tail = e;
			} else {
				e.setPrev(i.getPrev());
				e.setNext(i);
				if (i == head) {
					head = e;
				} else {
					i.getPrev().setNext(e);
				}
				i.setPrev(e);
			}

			size++;
			return true;

		} catch (Exception x) {
			return false;
		}

	}

	/**
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @throws IOException
	 */
	public static void runSection2(String argFile1, int argIdToFind) throws IOException {
		/*****************************************************************************
		 * START OF SECTION 2
		 * 
		 * In this next section, we are going to declare a variable of type UALinkedList
		 * rather than using the generic interface List<UAEmployee> as the type. In
		 * doing so, we will have access to methods that were established in
		 * UALinkedList but not in List.
		 * 
		 * DO NOT MODIFY THE CODE IN THIS SECTION...
		 *****************************************************************************/
		System.out.println("*********************************************************************");
		UALinkedList list2 = new UALinkedList(); // Do not change

		System.out.println("\nStarting Task 5:  Calling loadListFromFile() for list2...");
		list2.loadListFromFile(argFile1);

		System.out.println("\nStarting Task 6:  Calling printList() for list2...");

		list2.printList();

		System.out.printf("%nStarting Task 7:  Searching for employee ID %d using find()...%n", argIdToFind);

		UAEmployee found = list2.find(argIdToFind);
		System.out.print("\n                  Found employee:  ");
		System.out.println(found);

		System.out.printf("%nStarting Task 8:  Removing employee ID %d by reference...%n", argIdToFind);
		System.out.println("\n                  Current list of employees:");
		list2.printList();
		list2.remove(found);

		System.out.println();
		System.out.println("                  Current list of employees after delete:");
		list2.printList();
		System.out.println("*********************************************************************");

	}

}
