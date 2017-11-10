
public class DLLNode {
	private String data;
	private DLLNode next;
	private DLLNode pre;

	public DLLNode() {
		this.data = null;
		this.next = null;
		this.pre = null;
	}

	public DLLNode(String newData) {
		this.data = newData;
		this.next = null;
		this.pre = null;
	}

	public void updataNext(DLLNode nextOne) {
		this.next = nextOne;
	}

	public void updatePre(DLLNode preOne) {
		this.pre = preOne;
	}

	public String toString() {
		return this.data;
	}

	public DLLNode getNext() {
		return this.next;
	}

	public DLLNode getPre() {
		return this.pre;
	}

}
