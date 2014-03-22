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

		DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();

		System.out.println("addRear");
		doublyLinkedList2.addRear(1);
		doublyLinkedList2.addRear(2);
		doublyLinkedList2.addRear(3);
		doublyLinkedList2.print();
		System.out.println();
	}
}
