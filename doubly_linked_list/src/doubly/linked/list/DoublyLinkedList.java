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
		// if list is empty, add a new node as head
		if (head == null) {
			head = new Node(null, data, null);
		} 
		else {
			// create a new node with next pointer pointing to head
			Node newNode = new Node(null, data, head);
			// point previous pointer of head to new node
			head.previous = newNode;
			// make new node as head
			head = newNode;
		}
		
		// increase size of the list
		size ++;
	}

	public void addRear(int data) {
		// if list is empty, add a new node as head
		if (head == null) {
			head = new Node(null, data, null);
		} 
		else {
			Node current = head;

			// find last node of the list
			while (current.next != null) {
				current = current.next;
			}
			
			// create a new node with previous pointer pointing to last node of the list
			Node newNode = new Node(current, data, null);
			// point next pointer of last node of the list to a new node
			current.next = newNode;
		}
		
		// increase size of the list
		size ++;
	}
	
	public void removeFront() {
		// if list is empty, do nothing
		if (head == null) {
			return;
		}
		
		// make a node pointed by next pointer of current head to be new head
		head = head.next;
		// remove previous pointer from new head
		head.previous = null;
		// decrease size of the list
		size --;
	}
	
	public void removeRear() {
		// if list is empty, do nothing
		if (head == null) {
			return;
		}
		
		// if there is only one node in the list
		if (head.next == null) {
			// remove the only node in the list
			head = null;
			// decrease size of the list
			size --;
			
			return;
		}
		
		// if there is more than one node in the list
		Node current = head;
		// find a node pointing to last node of the list
		while (current.next.next != null) {
			current = current.next;
		}
		// remove last node of the list
		current.next = null;
		
		// decrease size of the list
		size --;
	}
	
	public void insertAt(int data, int index) {
		// if list is empty, do nothing
		if (head == null) {
			return;
		}
		
		// if index is not valid, do nothing
		if (index < 1 || index > size) {
			return;
		}
		
		Node current = head;
		
		int i = 1;
		// find a node which will be pointed by next pointer of a new node
		while (i < index) {
			current = current.next;
			i ++;
		}
		
		// if current node is the first node in the list
		if (current.previous == null) {
			// create a new node with next pointer pointing to current node (first node)
			Node newNode = new Node(null, data, current);
			// point previous pointer of current node (first node) to a new node
			current.previous = newNode;
			// make a new node as head
			head = newNode;
		}
		else {
			// create a new node with previous pointer pointing to a node pointed by previous pointer 
			// of current node and with next pointer pointing to current node
			Node newNode = new Node(current.previous, data, current);
			// point next pointer of previous node of current node to a new node
			current.previous.next = newNode;
			// point previous pointer of current node to a new node
			current.previous = newNode;
		}
		
		// increase size of the list
		size ++;
	}
	
	public void removeAt(int index) {
		// if list is empty, do nothing
		if (head == null) {
			return;
		}
		
		// if index is invalid, do nothing
		if (index < 1 || index > size) {
			return;
		}
		
		Node current = head;
		int i = 1;
		// find a node to be removed
		while (i < index) {
			current = current.next;
			i ++;
		}
		
		// if a node to be removed is last node of the list
		if (current.next == null) {
			// remove next pointer of previous node of current node
			current.previous.next = null;
		}
		// if a node to be removed is first node of the list 
		else if (current.previous == null) {
			// set current node to next node
			current = current.next;
			// remove previous pointer of new current node
			current.previous = null;
			// make new current node as head
			head = current;
		}
		else {
			// point next pointer of previous node of current node to next node of current node
			current.previous.next = current.next;
			// point previous pointer of next node of current node to previous node of current node
			current.next.previous = current.previous;
		}
		
		// decrease size of the list
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