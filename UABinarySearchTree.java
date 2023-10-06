/********************************
Name: Josue Martinez
Username: jmarti14
Problem Set: PS8
Due Date: May 05, 2023
********************************/

import java.io.*;

public class UABinarySearchTree {

	public int size;
	public UANode root;

	/**
	 * 
	 * @param fileName
	 * This method will run in O(n) time.
	 */
	public void load(String fileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;

		while ((line = br.readLine()) != null) {
			UABinarySearchTreeNode student = new UABinarySearchTreeNode();
			String[] comma = line.split(",");

			student.setKey(Integer.parseInt(comma[0]));
			student.setEmail(comma[2]);
			insert(student);
			size++;
			
		}
		
		br.close();
		
	}

	/**
	 * 
	 * @param z
	 * This method will run in O(n) time.
	 */
	public void insert(UANode z) {
        UANode y = null;
        UANode x = root;

        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        z.setParent(y);

        if (y == null) {
            root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }
	
	/**
	 * 
	 * @param x
	 * @param k
	 * This method will run in O(1) time.
	 */
	public UANode search(UANode x, int k) {
		
		if( x == null || k == x.getKey()) {
			return x;
		}
		
		if(k < x.getKey()) {
			return search(x.getLeft(),k);
		} else {
			return search(x.getRight(),k);
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
	 * @param x
	 * This method will run in O(1) time.
	 */
	public void print(UANode x) {
		if( x != null) {
			print(x.getRight());
			System.out.println(x.getKey() + " ");
			print(x.getLeft());
		}
		
		

	}

	/**
	 * 
	 * @param k
	 * This method will run in O(1) time.
	 */
	public void delete(int k) {
	    root = delete(root, k);
	}
	
	
	/**
	 * 
	 * @param x
	 * @param k
	 * This method will run in O(1) time.
	 */
	private UANode delete(UANode x, int k) {
	    if (x == null) {
	        return null;
	    }
	    
	    if (k < x.getKey()) {
	    	
	        x.setLeft(delete(x.getLeft(), k));
	       
	    } else if (k > x.getKey()) {
	    	
	        x.setRight(delete(x.getRight(), k));
	        
	    } else {
	        if (x.getLeft() == null) {
	        	size--;
	            return x.getRight();
	        } else if (x.getRight() == null) {
	        	size--;
	            return x.getLeft();
	        }
	        
	        UANode temp = getMinimum(x.getRight());
	        x.setKey(temp.getKey());
	        x.setEmail(temp.getEmail());
	        x.setRight(delete(x.getRight(), temp.getKey()));
	    }
	    
	    
	    return x;
	}

	/**
	 * 
	 * @param k
	 * This method will run in O(1) time.
	 */
	public void remove(int k) {
	    if (root == null) {
	        return;
	    }
	    
	    UANode x = search(root, k);
	    if (x == null) {
	        return;
	    }
	    
	    
	    root = remove(root, x);
	    
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * This method will run in O(1) time.
	 */
	private UANode remove(UANode x, UANode y) {
	    if (x == null) {
	        return null;
	    }
	    
	    if (y.getKey() < x.getKey()) {
	        x.setLeft(remove(x.getLeft(), y));
	    } else if (y.getKey() > x.getKey()) {
	        x.setRight(remove(x.getRight(), y));
	    } else {
	        if (x.getLeft() == null) {
	            return x.getRight();
	        } else if (x.getRight() == null) {
	            return x.getLeft();
	        }
	        
	        UANode temp = getMinimum(x.getRight());
	        x.setKey(temp.getKey());
	        x.setEmail(temp.getEmail());
	        x.setRight(remove(x.getRight(), temp));
	    }
	    
	    
	    return x;
	}

	/**
	 * 
	 * @param x
	 * This method will run in O(n) time.
	 */
	public UANode getMinimum(UANode x) {

		while (x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;
	}
	
	/**
	 * 
	 * @param x
	 * This method will run in O(1) time.
	 */
	public UANode getMaximum(UANode x) {

		while (x.getRight() != null) {
			x = x.getRight();
		}
		return x;
	}

	/**
	 * 
	 * @param x
	 * This method will run in O(1) time.
	 */
	public int getTreeHeight(UANode x) {
		
	    if (x == null) {
	        return 0;
	    }
	    
	    int leftHeight = getTreeHeight(x.getLeft());
	    int rightHeight = getTreeHeight(x.getRight());
	    return Math.max(leftHeight, rightHeight) + 1;
	}


	/**
	 * 
	 * @param x
	 * This method will run in O(1) time.
	 */
	public void walk(UANode x) {
	    if (x == null) {
	        return;
	    }
	    
	    walk(x.getLeft());
	    System.out.print(x.getKey() + ", ");
	    walk(x.getRight());
	}

	/**
	 * 
	 * @return
	 * This method will run in O(1) time.
	 */
	public void walk() {
	    walk(root);
	}

	public static void main(String[] args) throws IOException {
	    UABinarySearchTree tree = new UABinarySearchTree();
	    tree.load("input.txt");
	    System.out.println("Tree Size: " + tree.size);
	    System.out.println("\nWalking the tree: ");
	    tree.walk();
	 
	    UANode root = tree.root;
	    UANode minNode = tree.getMinimum(root);
	    UANode maxNode = tree.getMaximum(root);
	    int treeHeight = tree.getTreeHeight(root);

	    System.out.println("\n\nMinimum key: " + minNode.getKey());
	    System.out.println("Maximum key: " + maxNode.getKey());
	    System.out.println("Height of tree: " + treeHeight);
	    
	    tree.delete(5);
	    
	    System.out.println("\nWalking the tree after deleting: ");
	    tree.walk();
	    

	}

	public static class UABinarySearchTreeNode implements UANode {
	    private int key;
	    private String email;
	    private UANode left;
	    private UANode right;
	    private UANode parent;

	    public int getKey() {
	        return key;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public UANode getLeft() {
	        return left;
	    }

	    public UANode getRight() {
	        return right;
	    }

	    public UANode getParent() {
	        return parent;
	    }

	    public void setLeft(UANode x) {
	        this.left = x;
	    }

	    public void setRight(UANode x) {
	        this.right = x;
	    }

	    public void setParent(UANode x) {
	        this.parent = x;
	    }

	    public void setKey(int k) {
	        this.key = k;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String toString() {
	        return "ID: " + getKey() + " Email: " + getEmail();
	    }

	    public int hashCode() {
	        return getKey();
	    }
	}


}
