package singly.linked.list;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList linkedList1= new LinkedList();
		linkedList1.insertAtStart(1);
		linkedList1.insertAtStart(2);
		linkedList1.insertAtStart(3);
		
		System.out.println(linkedList1.getStart().getData());
		System.out.println(linkedList1.getStart().getLink().getData());
		System.out.println(linkedList1.getStart().getLink().getLink().getData());
		
		linkedList1.print();
		System.out.println();
		System.out.println();
		
		LinkedList linkedList2 = new LinkedList();
		linkedList2.insertAtEnd(1);
		linkedList2.insertAtEnd(2);
		linkedList2.insertAtEnd(3);
		
		linkedList2.print();
		System.out.println();
		System.out.println("linkedList2.getSize(): " + linkedList2.getSize());
		System.out.println("linkedList2.getStart().getData(): " + linkedList2.getStart().getData());
		System.out.println("linkedList2.getEnd().getData(): " + linkedList2.getEnd().getData());
		System.out.println();
		
		linkedList2.insertAtPos(4, 3);
		
		linkedList2.deleteAtPos(2);
		
		System.out.println(linkedList2.getStart().getData());
		System.out.println(linkedList2.getStart().getLink().getData());
		System.out.println(linkedList2.getStart().getLink().getLink().getData());
		
		linkedList2.print();
		System.out.println();
		System.out.println();
		
		LinkedList linkedList3 = new LinkedList();
		linkedList3.insertAtEnd(1);
//		linkedList3.insertAtEnd(2);
//		linkedList3.insertAtEnd(3);
		
		linkedList3.print();
		System.out.println();
		
		linkedList3.deleteAtPos(1);
		
		System.out.println();
	}
}
