package doubly.linked.list;

// https://www.youtube.com/watch?v=Xep50u728Z4
public class DoublyLinkedList {
	private Node head;
	private int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	public void addFront(int data) {
		if (head == null) {
			head = new Node(null, data, null);
		} else {
			Node newNode = new Node(null, data, head);
			head.previous = newNode;
			head = newNode;
		}

		size++;
	}

	public void addRear(int data) {
		if (head == null) {
			head = new Node(null, data, null);
		} else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}

			Node newNode = new Node(current.next, data, null);
			current.next = newNode;
		}
	}

	public void print() {
		Node current = head;

		while (current != null) {
			System.out.print(current.getData());
			if (current.next != null) {
				System.out.print(" -> ");
			}

			current = current.next;
		}

		System.out.println();
	}

}