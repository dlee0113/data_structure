package doubly.linked.list;

public class Node {
	private int data;
	public Node previous;
	public Node next;
	
	public Node(int data) {
		previous = null;
		this.data = data;
		next = null;
	}
	
	public Node(Node previous, int data, Node next) {
		this.previous = previous;
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}
}
