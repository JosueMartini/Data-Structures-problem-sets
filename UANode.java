public interface UANode {
	int getKey();
	String getEmail();
	UANode getLeft();
	UANode getRight();
	UANode getParent();
	void setLeft(UANode x);
	void setRight(UANode x);
	void setParent(UANode x);
	void setKey(int k);
	void setEmail(String email);
	
}
