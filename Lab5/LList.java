
public class LList {
	private LLNode head;
	
	public LList() {
		head = null;
	}
	
	public void addAtHead(char data) {
		LLNode newNode = new LLNode(data);
		newNode.updateNode(head);
		head = newNode;
	}
	
	public void display() {
		LLNode temp = head;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
	
	public LLNode deleteAtHead() {
		LLNode removeOne = head;
		
		if (head != null) {
			head = head.getNext();
		} else {
			System.out.println("Nothing in the head");
		}
		
		return removeOne;
	}
	
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	public void deleteElement(String data) {
		LLNode link;
		if (head != null) {
			link = head;
			if (link.toString().equals(data)) {
				head = link.getNext();
			} else {
				LLNode lastOne = link;
				while (link.getNext() != null) {
					lastOne = link;
					link = link.getNext();
					if (link.toString().equals(data)) {
						lastOne.updateNode(link.getNext());
						break;
					}
				}
			}
		} else {
			System.out.println("There is nothing to delete");
		}
	}

}
 