package doubly.linked.list;

// https://www.youtube.com/watch?v=Xep50u728Z4
public class DoublyLinkedList {
	private Node head;
	private int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void addFront(int data) {
		if (head == null) {
			head = new Node(null, data, null);
		} else {
			Node newNode = new Node(null, data, head);
			head.previous = newNode;
			head = newNode;
		}

		size ++;
	}

	public void addRear(int data) {
		if (head == null) {
			head = new Node(null, data, null);
		} else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}

			Node newNode = new Node(current, data, null);
			current.next = newNode;
		}
		
		size ++;
	}
	
	public void removeFront() {
		if (head == null) {
			return;
		}
		
		head = head.next;
		head.previous = null;
		size --;
	}
	
	public void removeRear() {
		if (head == null) {
			return;
		}
		
		if (head.next == null) {
			head = null;
			size --;
			
			return;
		}
		
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		
		size --;
	}
	
	public void insertAt(int data, int index) {
		if (head == null) {
			return;
		}
		
		if (index < 1 || index > size) {
			return;
		}
		
		Node current = head;
		
		int i = 1;
		while (i < index) {
			current = current.next;
			i ++;
		}
		
		if (current.previous == null) {
			Node newNode = new Node(null, data, current);
			current.previous = newNode;
			head = newNode;
		}
		else {
			Node newNode = new Node(current.previous, data, current);
			current.previous.next = newNode;
			current.previous = newNode;
		}
		
		size ++;
	}
	
	public void removeAt(int index) {
		if (head == null) {
			return;
		}
		
		if (index < 1 || index > size) {
			return;
		}
		
		Node current = head;
		int i = 1;
		while (i < index) {
			current = current.next;
			i ++;
		}
		
		if (current.next == null) {
			current.previous.next = null;
		}
		else if (current.previous == null) {
			current = current.next;
			current.previous = null;
			head = current;
		}
		else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		
		size --;
	}
	
	public boolean isEmpty() {
		return head == null;
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