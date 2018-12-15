//Do NOT modify
//No need to submit this file
public class Node {
	public char label;
	public Node left;
	public Node right;
	Node(){
		label = ' ';
		left = null;
		right = null;
	}
	Node(char label){
		this.label = label;
		left = null;
		right = null;
	}
	Node(char label, Node left, Node right){
		this.label = label;
		this.left = left;
		this.right = right;
	}
	void setLabel(char label){
		this.label = label;
	}
	void setLeft(Node left){
		this.left = left;
	}
	void setRight(Node right){
		this.right = right;
	}
}
