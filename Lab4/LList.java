
public class LList {
	private LLNode head;

	public LList() {
		head = null;
	}

	public void addAtHead(String newData) {
		LLNode newNode = new LLNode(newData);
		newNode.updateNode(head);
		head = newNode;

		System.out.println("Successfully added");
	}

	public void display() {
		LLNode temp = head;

		if (head == null) {
			System.out.println("Nothing to display");
		} else {
			while (temp != null) {
				System.out.println(temp);
				temp = temp.getNext();
			}
		}
	}

	public LLNode deleteAtHead() {
		LLNode temp = head;
		if (head == null) {
			System.out.println("Nothing to delete");
		} else {
			head = head.getNext();
			System.out.println("Successfully delete at head...");
		}

		return temp;
	}

	public void delete(String data) {
		LLNode temp;

		if (head == null) {
			System.out.println("Nothing to delete");
		} else {
			temp = head;
			if (temp.toString().equals(data)) {
				head = temp.getNext();
				
			} else {
				LLNode link = temp;

				while (temp.getNext() != null) {
					link = temp;
					temp = temp.getNext();

					if (temp.toString().equals(data)) {
						link.updateNode(temp.getNext());
						break;
					}
				}
			}
			System.out.println("Successfully delete...");

		}

	}
}
