import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***********************************************************************************
 * Student Name: Josue Martinez Date: 4/15/2023 Class: CS2003 Filename:
 * UAHashTable.java Description: Implementation of a hash table (by A. Mackey)
 ***********************************************************************************/

public class UAHashTable {

	protected static final int INITIAL_SIZE = 27;
	protected UACourse[] T;
	protected int hashMapSize;
	protected int collisionCount;
	protected int inserted;
	protected int inserted1;

	/*************************************************************************
	 * Constructors: Do not modify.
	 *************************************************************************/

	public UAHashTable(int size) {
		T = new UACourse[size];
	}

	public UAHashTable() {
		this(INITIAL_SIZE);
	}

	/*************************************************************************
	 * Methods to implement in each class. DO NOT MODIFY THESE METHODS!
	 *
	 * These are only here to so that you can declare the type as UAHashTable h1 =
	 * new UAHashSpecificType() and call the methods using the parent class's
	 * declaration. Do NOT modify or add to these lines of code. You will need to
	 * *** override *** them in the child class.
	 *
	 * Methods: readFile(), insert(), search(), and size()
	 *************************************************************************/

	public void readFile(String filename) throws IOException {

	}

	public void insert(UACourse k) {

	}

	public UACourse search(int id) {
		return null;
	}

	public int size() {
		return 0;
	}

	// This should return the number of times a collision occurred.

	public int getCollisionCount() {
		return this.collisionCount;
	}

	/**************************************************************************
	 * Runtime code - MODIFY THIS SECTION TO SUPPORT PROBLEM SET REQUIREMENTS
	 *
	 * Update the main method to accept the requirements as set forth in the problem
	 * set.
	 **************************************************************************/

	public static void main(String[] args) throws IOException {
		
		
		
		

		UAHashTableLinearProbing hashTable = new UAHashTableLinearProbing();
		
		if( args.length == 1 ) {
			hashTable.hashMapSize = INITIAL_SIZE;
		} else {
			hashTable.hashMapSize = Integer.parseInt(args[1]);
		}
		
		hashTable.readFile(args[0]);
		System.out.println("Linear Probing");
		System.out.printf("  File Name:%30s%n", "input.txt");
		System.out.printf("  Initial Has Table Size:%10s%n", hashTable.hashMapSize);
		System.out.printf("  Final Has Table Size:%12s%n", hashTable.T.length);
		System.out.printf("  Number of Items Inserted:%8s%n", hashTable.size());
		System.out.printf("  Collisions:%23s%n%n", hashTable.collisionCount);

		for (int i = 0; i < hashTable.T.length; i++) {
			if (hashTable.T[i] != null) {
				System.out.println("  " + i + ":    " + hashTable.T[i].hashCode());
			} else {
				System.out.println("  " + i + ":    " + "EMPTY");
			}
		}

		System.out.println();

		UAHashTableQuadraticProbing hashTable2 = new UAHashTableQuadraticProbing();
		
		if( args.length == 1 ) {
			hashTable2.hashMapSize = INITIAL_SIZE;
		} else {
			hashTable2.hashMapSize = Integer.parseInt(args[1]);
		}
		
		hashTable2.readFile(args[0]);
		System.out.println("Quadratic Probing");
		System.out.printf("  File Name:%30s%n", "input.txt");
		System.out.printf("  Initial Has Table Size:%10s%n", hashTable2.hashMapSize);
		System.out.printf("  Final Has Table Size:%12s%n", hashTable2.T.length);
		System.out.printf("  Number of Items Inserted:%8s%n", hashTable2.size());
		System.out.printf("  Collisions:%22s%n%n", hashTable2.collisionCount);

		for (int i = 0; i < hashTable2.T.length; i++) {
			if (hashTable2.T[i] != null) {
				System.out.println("  " + i + ":    " + hashTable2.T[i].hashCode());
			} else {
				System.out.println("  " + i + ":    " + "EMPTY");
			}
		}

		System.out.println();

		UAHashTableDoubleHashing hashTable3 = new UAHashTableDoubleHashing();
		
		if( args.length == 1 ) {
			hashTable3.hashMapSize = INITIAL_SIZE;
		} else {
			hashTable3.hashMapSize = Integer.parseInt(args[1]);
		}
		
		hashTable3.readFile(args[0]);
		System.out.println("Double Hashing");
		System.out.printf("  File Name:%30s%n", "input.txt");
		System.out.printf("  Initial Has Table Size:%10s%n", hashTable3.hashMapSize);
		System.out.printf("  Final Has Table Size:%12s%n", hashTable3.T.length);
		System.out.printf("  Number of Items Inserted:%8s%n", hashTable3.size());
		System.out.printf("  Collisions:%22s%n%n", hashTable3.collisionCount);

		for (int i = 0; i < hashTable3.T.length; i++) {
			if (hashTable3.T[i] != null) {
				System.out.println("  " + i + ":    " + hashTable3.T[i].hashCode());
			} else {
				System.out.println("  " + i + ":    " + "EMPTY");
			}
		}

	}

	/**************************************************************************
	 * STATIC CLASS THAT WILL BE USED TO STORE IN THE HASH MAP IMPLEMENTATION
	 *
	 * Student needs to update the hashCode() method only. Do not modify anything
	 * else.
	 **************************************************************************/

	public static class UACourse {

		/*************************************************************************
		 * DO NOT CHANGE THIS CONSTRUCTOR
		 *************************************************************************/
		public UACourse(int id, String courseName, String courseInstructor) {
			this.id = id;
			this.courseName = courseName;
			this.courseInstructor = courseInstructor;
		}

		/*************************************************************************
		 * DO NOT ADD ANY METHODS/FIELDS TO THIS CLASS
		 *************************************************************************/
		public int id;
		public String courseName;
		public String courseInstructor;

		/*************************************************************************
		 * DO NOT CHANGE THIS METHOD
		 *************************************************************************/
		public String toString() {
			return String.format("Hash Code: %15d      Course Info: %30s %n", this.hashCode(),
					this.courseName + ", " + this.courseInstructor);
		}

		/*************************************************************************
		 * TODO: STUDENT NEEDS TO UPDATE THIS hashCode() METHOD.
		 *
		 * Every object has a hashCode() method. This is because every child class is a
		 * direct descendant of the Object class, which is where this method is defined.
		 *
		 * When you have to override this method, your goal for a hashCode is to convert
		 * some indexed value to some integer. For example, you seek to convert some key
		 * "abc" to some integer using this function: h(abc) = some int. This should not
		 * be random or else the algorithm will not work!
		 *
		 * For this problem set, when you have an instance of some UACourse, how do you
		 * individually/uniquely identify each course?
		 *************************************************************************/
		public int hashCode() {

			return id;

		}

	} // END OF STATIC UACOURSE CLASS

	/*************************************************************************
	 * Specific implementations of hash maps. You will need to edit these.
	 *************************************************************************/

	public static class UAHashTableLinearProbing extends UAHashTable {

		public void readFile(String filename) throws IOException {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";

			while ((line = br.readLine()) != null) {

				String[] comma = line.split(",");

				UACourse course = new UACourse(Integer.parseInt(comma[0]), comma[1], comma[2]);
				insert(course);
				inserted++;

			}
			br.close();

		}

		public void insert(UACourse k) {
			
			if (hashMapSize == 0) {
			    T = new UACourse[INITIAL_SIZE];
			    hashMapSize = INITIAL_SIZE;
			}

			int index = k.hashCode() % hashMapSize;

			if (index < 0) {
			    index += hashMapSize;
			}

			UACourse exist = search(k.id);
			if (exist != null) {
			    T[index] = k;
			    return;
			}

			while (T[index] != null) {
			    if (T[index].equals(k)) {
			        T[index] = k;
			        return;
			    }
			    index = (index + 1) % hashMapSize;
			    collisionCount++;
			    if (collisionCount > 0.75 * hashMapSize) {
			        resize();
			    }
			}
			T[index] = k;
		}

		public UACourse search(int id) {
			int i = 0;
		    int index = id % hashMapSize;
		    while (T[index] != null || i != hashMapSize) {
		        if (T[index] == null) {
		            return null;
		        }
		        if (T[index].id == id) {
		            return T[index];
		        } else {
		            i++;
		            index = (id + i) % hashMapSize;
		        }
		    }

		    return null;
		}

		public int size() {
			return inserted;
		}
		
		public void resize() {
		    int oldSize = hashMapSize;
		    hashMapSize = 2 * oldSize;
		    UACourse[] oldTable = T;
		    T = new UACourse[hashMapSize];
		    int size = 0;

		    for (int i = 0; i < oldSize; i++) {
		        if (oldTable[i] != null) {
		            insert(oldTable[i]);
		        }
		    }
		}

	}

	public static class UAHashTableQuadraticProbing extends UAHashTable {

		public void readFile(String filename) throws IOException {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";

			while ((line = br.readLine()) != null) {

				String[] comma = line.split(",");
				UACourse course = new UACourse(Integer.parseInt(comma[0]), comma[1], comma[2]);
				insert(course);
				inserted++;

			}
			br.close();

		}

		public void insert(UACourse k) {

			if (hashMapSize == 0) {
		        T = new UACourse[INITIAL_SIZE];
		        hashMapSize = INITIAL_SIZE;
		    }
			
		    UACourse exist = search(k.id);
		    if (exist != null) {
		        exist = k;
		        return;
		    }

		    int index = k.hashCode() % hashMapSize;
		    int c1 = 1;
		    int c2 = 3;
		    int i = 0;

		    while (T[index] != null && i < hashMapSize) {
		        if (T[index].equals(k)) {
		            T[index] = k;
		            return;
		        }
		        i++;
		        index = (index + c1 * i + c2 * (int) Math.pow(i, 2)) % hashMapSize;
		        collisionCount++;
		        if (collisionCount > 0.75 * hashMapSize) {
		             resize();
		        }
		    }

		    T[index] = k;

		}

		public UACourse search(int id) {
			int i = 0;
		    int index = id % hashMapSize;
		    int c1 = 1;
		    int c2 = 3;

		    while (T[index] != null && i < hashMapSize) {
		        if (T[index] == null) {
		            return null;
		        }
		        if (T[index].id == id) {
		            return T[index];
		        } else {
		            i++;
		            index = (index + c1 * i + c2 * i * i) % hashMapSize;
		        }
		    }

		    return null;
		}

		public int size() {
			return inserted;
		}
		
		public void resize() {
		    UACourse[] oldTable = T;
		    int oldSize = hashMapSize;
		    int newSize = 2 * oldSize;
		    UACourse[] newTable = new UACourse[newSize];
		    hashMapSize = newSize;
		    collisionCount = 0;

		    int c1 = 1;
		    int c2 = 3;

		    for (int i = 0; i < oldSize; i++) {
		        UACourse current = oldTable[i];
		        if (current != null) {
		            int index = current.hashCode() % newSize;
		            int j = 0;
		            while (newTable[index] != null && j < newSize) {
		                j++;
		                index = (index + c1 * j + c2 * (int) Math.pow(j, 2)) % newSize;
		                collisionCount++;
		            }
		            newTable[index] = current;
		        }
		    }

		    T = newTable;
		}

	}

	public static class UAHashTableDoubleHashing extends UAHashTable {

		public void readFile(String filename) throws IOException {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";

			while ((line = br.readLine()) != null) {

				String[] comma = line.split(",");
				UACourse course = new UACourse(Integer.parseInt(comma[0]), comma[1], comma[2]);
				insert(course);
				inserted++;

			}
			br.close();

		}

		public void insert(UACourse k) {
			if (hashMapSize == 0) {
				T = new UACourse[INITIAL_SIZE];
				hashMapSize = INITIAL_SIZE;
			}

			int i = 0;
		    int index = k.hashCode() % hashMapSize;
		    int h1 = index;
		    int h2 = 1 + (index % hashMapSize);

		    UACourse exist = search(k.id);
		    if (exist != null) {
		        T[index] = k;
		        return;
		    }

		    while (T[index] != null && i < hashMapSize) {
		        i++;
		        index = (h1 + i * h2) % hashMapSize;
		        collisionCount++;
		        if (collisionCount > 0.75 * hashMapSize) {
		            resize();
		        }
		    }
		    T[index] = k;
		}

		public UACourse search(int id) {
			int i = 0;
		    int index = id % hashMapSize;
		    while (T[index] != null || i != hashMapSize) {
		        if (T[index] == null) {
		            return null;
		        }
		        if (T[index].id == id) {
		            return T[index];
		        } else {
		            i++;
		            index = (id + i) % hashMapSize;
		        }
		    }

		    return null;
		}

		public int size() {
			return inserted;
		}
		
		public void resize() {
		    int oldSize = hashMapSize;
		    UACourse[] oldTable = T;

		    hashMapSize = 2 * oldSize;
		    T = new UACourse[hashMapSize];
		    collisionCount = 0;

		    for (int i = 0; i < oldSize; i++) {
		        UACourse course = oldTable[i];
		        if (course != null) {
		            int index = course.hashCode() % hashMapSize;
		            while (T[index] != null) {
		                index = (index + 1) % hashMapSize;
		                collisionCount++;
		            }
		            T[index] = course;
		        }
		    }
		}

	}

}
