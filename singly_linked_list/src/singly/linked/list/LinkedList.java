package singly.linked.list;

// http://www.sanfoundry.com/java-program-implement-singly-linked-list/
public class LinkedList {
	protected Node start;
	protected Node end;
	public int size;
	
	public LinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public Node getStart() {
		return start;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int getSize() {
		return size;
	}
	
	// insert new node at beginning of the list
	public void insertAtStart(int val) {
		Node nptr = new Node(val, null);
		size ++;
		
		if (start == null) {
			start = nptr;
			end = start;
		}
		else {
			nptr.setLink(start);
			start = nptr;
		}
	}
	
	// insert new node at end of the list
	public void insertAtEnd(int val) {
		Node nptr = new Node(val, null);
		size ++;
		
		if (start == null) {
			start = nptr;
			end = start;
		}
		else {
			end.setLink(nptr);;
			end = nptr;
		}
	}
	
	public void insertAtPos(int val, int pos) {
		Node nptr = new Node(val, null);
		Node ptr = start;
		pos = pos - 1;
		
		// find a node to append a new node
		for (int i = 1; i < size; i ++) {
			if (i == pos) {
//				Node tmp = ptr.getLink();
//				ptr.setLink(nptr);
//				nptr.setLink(tmp);
				
				// point new node to next node of current node
				nptr.setLink(ptr.getLink());
				// point current node to new node
				ptr.setLink(nptr);
				
				break;
			}
			
			ptr = ptr.getLink();
		}
		
		size ++;
	}
	
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size --;
			
			return;
		}
		
		if (pos == size) {
			Node s = start;
			Node t = start;
			
			while(s != end) {
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size --;
			
			return;
		}
		
		Node ptr = start;
		pos = pos - 1;
		
		for (int i = 1; i < size; i ++)	{
			if (i == pos) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				
				break;
			}
			
			ptr = ptr.getLink();
		}
		
		size --;
	}
	
	public void print() {
		Node currentNode = start;
		
		while (currentNode != null) {
			System.out.print(currentNode.getData());
			
			if (currentNode.getLink() != null) {
				System.out.print(" -> ");
			}
			
			currentNode = currentNode.getLink();
		}
	}
}
