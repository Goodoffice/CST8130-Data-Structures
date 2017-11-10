
public class DLList {

	private DLLNode head;
	private DLLNode tail;

	public DLList() {
		head = null;
		tail = null;
	}

	public void addAtHead(String newData) {
		DLLNode node = new DLLNode(newData);
		if (head != null) {
			head.updatePre(node);
		}
		node.updataNext(head);
		head = node;

		if (tail == null) {
			tail = node;
		}
	}

	// Need to debug
	public void addAtTail(String newData) {
		DLLNode node = new DLLNode(newData);
		if (tail != null) {
			tail.updatePre(node);
		}
		node.updataNext(tail);
		tail = node;

		if (head == null) {
			head = node;
		}
	}

	public void displayFromHead() {
		DLLNode temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}

	public void displayFromTail() {
		DLLNode temp = tail;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getPre();
		}
	}

	public DLLNode deleteAtHead() {
		DLLNode removedOne = head;
		if (head != null) {
			head = head.getNext();

		} else {
			System.out.println("Nothing in the head");
		}

		return removedOne;
	}

	public boolean searchDelete(String remove) {
		if (head == null) {
			return false;
		}

		DLLNode current = head;
		while (current != null && !(current.toString().equals(remove))) {
			current = current.getNext();
		}

		// find the remove one
		if (current != null) {
			// only one node in the list
			if (head == current && tail == current) {
				head = null;
				tail = null;
			} else if (current == head) { // node in the head
				head = current.getNext();
				current.getNext().updatePre(null); // pre be null
			} else if (current == tail) { // node in the tail
				tail = current.getPre();
				current.getPre().updataNext(null);
			} else {
				current.getPre().updataNext(current.getNext());
				current.getNext().updatePre(current.getPre());
			}

			return true;
		} else
			return false; // not find it
	}

}
