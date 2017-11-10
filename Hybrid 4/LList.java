
public class LList {
	private LLNode head;

	public LList() {
		head = null;
	}

	public void addAtHead(char newData) {
		LLNode newNode = new LLNode(newData);
		newNode.updateNode(head);
		head = newNode;
	}

	public void display() {
		LLNode temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}

	public void deleteAtHead(char newData) {
		head = head.getNext();

	}

	public boolean isEmpty() {
		return (this.head == null);
	}

}
