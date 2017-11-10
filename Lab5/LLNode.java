
public class LLNode {
	private char data;
	private LLNode next;
	
	public LLNode() {
		this.data = ' ';
		this.next = null;
	}
	
	public LLNode(char newData) {
		this.data = (newData);
		this.next = null;
	}
	
	public void updateNode(LLNode nextOne) {
		this.next = nextOne;
	}
	
	public String toString() {
		return String.valueOf(this.data);
	}
	
	public LLNode getNext() {
		return this.next;
	}
	
	public char getData() {
		return this.data;
	}

}
