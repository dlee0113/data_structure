package doubly.linked.list;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();

		System.out.println("addFront");
		doublyLinkedList1.addFront(1);
		doublyLinkedList1.addFront(2);
		doublyLinkedList1.addFront(3);
		doublyLinkedList1.print();
		System.out.println();
		
		System.out.println("removeFront");
		doublyLinkedList1.removeFront();
		doublyLinkedList1.print();
		System.out.println();

		DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();

		System.out.println("addRear");
		doublyLinkedList2.addRear(1);
		doublyLinkedList2.addRear(2);
		doublyLinkedList2.addRear(3);
		doublyLinkedList2.addRear(4);
		doublyLinkedList2.print();
		System.out.println();
		
		System.out.println("removeRear");
		doublyLinkedList2.removeRear();
		doublyLinkedList2.print();
		System.out.println();
		
		System.out.println("insertAt");
		doublyLinkedList2.insertAt(5, 2);
		doublyLinkedList2.print();
		System.out.println();
		
		System.out.println("removeAt");
		doublyLinkedList2.removeAt(3);
		doublyLinkedList2.print();
		System.out.println();
	}
}
