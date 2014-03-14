package singly.linked.list;

// http://www.sanfoundry.com/java-program-implement-singly-linked-list/
public class LinkedList {
	protected Node start; // first node
	protected Node end; // last node (a node pointing to null)
	public int size;
	
	public LinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public Node getStart() {
		return start;
	}
	
	public Node getEnd() {
		return end;
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
		// remove first node of the list
		if (pos == 1) {
			// set first node to next node (a node pointed by first node)
			start = start.getLink();
			// decrease size of the list
			size --;
			
			return;
		}
		
		// remove last node of the list (a node pointing to null)
		if (pos == size) {
			Node s = start;
			Node t = start;
			
			// loop and find a node pointing to last node (a node pointing to null)
			while(s != end) {
				t = s; // save current node
				s = s.getLink(); // set to next node for next iteration
			}
			// set last node to a node pointing to last node
			end = t;
			// set pointer of a node pointing to last node to null
			end.setLink(null);
			// decrease size of the list
			size --;
			
			return;
		}
		
		Node ptr = start;
		pos = pos - 1;
		
		// find a node pointing to a node at given position
		// point a node pointing to the selected node to a node pointed by the selected node
		for (int i = 1; i < size; i ++)	{
			if (i == pos) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				
				break;
			}
			
			ptr = ptr.getLink();
		}
		
		// decrease size of the list
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
